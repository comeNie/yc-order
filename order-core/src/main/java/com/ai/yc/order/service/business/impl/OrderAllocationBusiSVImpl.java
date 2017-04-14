package com.ai.yc.order.service.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.yc.order.api.orderallocation.param.OrdAlloInterperFeeInfoResponse;
import com.ai.yc.order.api.orderallocation.param.OrdAllocationPersonInfo;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationReceiveFollowInfo;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationRequest;
import com.ai.yc.order.api.orderallocation.param.OrderAllocationResponse;
import com.ai.yc.order.constants.OrdOdStateChgConstants;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.dao.mapper.attach.OrdOrderInferperFeeAttach;
import com.ai.yc.order.dao.mapper.bo.OrdOdPersonInfo;
import com.ai.yc.order.dao.mapper.bo.OrdOdReceiveFollow;
import com.ai.yc.order.dao.mapper.bo.OrdOdStateChg;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.service.atom.interfaces.IOrdOdPersonInfoAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdReceiveFollowAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdStateChgAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAttachAtomSV;
import com.ai.yc.order.service.business.interfaces.IOrderAllocationBusiSV;
import com.ai.yc.order.util.SequenceUtil;

@Service
@Transactional
public class OrderAllocationBusiSVImpl implements IOrderAllocationBusiSV {
	@Autowired
	private IOrdOdPersonInfoAtomSV ordOdPersonInfoAtomSV;// 分配人员信息服务
	@Autowired
	private IOrdOdReceiveFollowAtomSV ordOdReceiveFollowAtomSV;// 任务跟踪服务
	@Autowired
	private IOrdOrderAtomSV ordOrderAtomSV;// 订单主表
	@Autowired
	private IOrdOdStateChgAtomSV ordOdStateChgAtomSV;// 订单轨迹表
	@Autowired
	private IOrdOrderAttachAtomSV ordOrderAttachAtomSV;
	/**
	 * 订单分配
	 */
	private final static String ORDER_ALLOCATION_CN = " %s 分配翻译订单";
	private final static String ORDER_ALLOCATION_EN = " %s assigned the order";
	private final static String ORDER_ALLOCATION_CHECK_CN = " %s 分配审校订单";
	private final static String ORDER_ALLOCATION_CHECK_EN = " %s assigned the proofreading order to Translator";

	@Override
	@Transactional
	public OrderAllocationResponse saveOrderAllocation(OrderAllocationRequest request) {

		OrderAllocationResponse response = new OrderAllocationResponse();
		// 1 先查询订单主表信息
		OrdOrder ordOrderDb = this.ordOrderAtomSV.findByPrimaryKey(request.getOrderAllocationBaseInfo().getOrderId());
		if (null == ordOrderDb) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "此订单信息不存在");
		}
		//获取翻译类型
		String orderTypr = ordOrderDb.getTranslateType();
		// 2、任务跟踪信息入库
		List<OrderAllocationReceiveFollowInfo> followInfoList = request.getOrderAllocationReceiveFollowList();
		for (OrderAllocationReceiveFollowInfo follow : followInfoList) {
			OrdOdReceiveFollow ordOdfollow = new OrdOdReceiveFollow();
			BeanUtils.copyVO(ordOdfollow, follow);
			long followId = SequenceUtil.createFollowId();
			ordOdfollow.setReceiveFollowId(followId);
			ordOdfollow.setOrderId(request.getOrderAllocationBaseInfo().getOrderId());
			ordOdReceiveFollowAtomSV.insertSelective(ordOdfollow);
			// 2.分配人员信息表入库
			for (OrdAllocationPersonInfo ordAllocationPersonInfo : follow.getOrdAllocationPersonInfoList()) {
				OrdOdPersonInfo ordOdPersonInfo = new OrdOdPersonInfo();
				BeanUtils.copyVO(ordOdPersonInfo, ordAllocationPersonInfo);
				ordOdPersonInfo.setStep(follow.getStep());
				ordOdPersonInfo.setReceiveFollowId(followId);
				ordOdPersonInfo.setCreartTime(DateUtil.getSysDate());
				if (null != ordAllocationPersonInfo.getPersonId()) {
					//判断订单是否被领取，如果领取返回错误信息
					OrdOdReceiveFollow odFollow = new OrdOdReceiveFollow();
					odFollow.setReceiveFollowId(follow.getFollowId());
					OrdOdReceiveFollow followOdInfo = ordOdReceiveFollowAtomSV.find(odFollow);
					if(null==followOdInfo){
						throw new BusinessException(ExceptCodeConstants.Special.NO_RESULT, "该任务为空");
					}else{
						if("1".equals(followOdInfo.getReceiveState())){
							throw new BusinessException(ExceptCodeConstants.Special.PARAM_TYPE_NOT_RIGHT, "该任务已被领取不能进行修改");
						}
					}
					//修改分配人员
					ordOdPersonInfo.setPersonId(ordAllocationPersonInfo.getPersonId());
					ordOdPersonInfoAtomSV.updateSelective(ordOdPersonInfo);
				} else {
					ordOdPersonInfo.setPersonId(SequenceUtil.createPersonId());
					this.ordOdPersonInfoAtomSV.insertSelective(ordOdPersonInfo);
				}
			}
			// 3.入库订单轨迹表 状态为---211：已分配（口译订单则为瞬时状态，直接为“50：待确认”）
			OrdOdStateChg ordOdStateChg = new OrdOdStateChg();
			ordOdStateChg.setStateChgId(SequenceUtil.createStateChgId());
			ordOdStateChg.setOrderId(request.getOrderAllocationBaseInfo().getOrderId());
			// 获取中英文轨迹信息
			String descCn = String.format(ORDER_ALLOCATION_CN, request.getOrderAllocationBaseInfo().getOperName());
			String descEn = String.format(ORDER_ALLOCATION_EN, request.getOrderAllocationBaseInfo().getOperName());
			String descCheckCn = String.format(ORDER_ALLOCATION_CHECK_CN,
					request.getOrderAllocationBaseInfo().getOperName());
			String descCheckEn = String.format(ORDER_ALLOCATION_CHECK_EN,
					request.getOrderAllocationBaseInfo().getOperName());
			ordOdStateChg.setChgDescEn(descEn);
			ordOdStateChg.setChgDescD(descCn);
			ordOdStateChg.setChgDescUEn(descEn);
			ordOdStateChg.setChgDesc(descCn);
			if (OrdersConstants.OrdOperType.OPER_CHECK_TYPE.equals(follow.getOperType())) {
				ordOdStateChg.setChgDescEn(descCheckEn);
				ordOdStateChg.setChgDescD(descCheckCn);
				ordOdStateChg.setChgDescUEn(descCheckEn);
				ordOdStateChg.setChgDesc(descCheckCn);
			}
			ordOdStateChg.setFlag(OrdOdStateChgConstants.FLAG_USER);
			ordOdStateChg.setOrgId("1");
			ordOdStateChg.setOperId(request.getOrderAllocationBaseInfo().getUserId());
			ordOdStateChg.setOperName(request.getOrderAllocationBaseInfo().getOperName());
			ordOdStateChg.setOrgState(ordOrderDb.getState());
			if("2".equals(orderTypr)){
				ordOdStateChg.setNewState("50");
			}else{
				ordOdStateChg.setNewState("211");
			}
			ordOdStateChg.setStateChgTime(DateUtil.getSysDate());
			//
			this.ordOdStateChgAtomSV.insertSelective(ordOdStateChg);
		}

		// 2.2 修改订单主表状态
		//判断如果为口译那么后端和前段状态为待确认，如果是笔译只改变后端状态为已分配
		if("2".equals(orderTypr)){
			ordOrderDb.setState("50");
			ordOrderDb.setStateChgTime(DateUtil.getSysDate());
			ordOrderDb.setDisplayFlag("50");
			ordOrderDb.setDisplayFlagChgTime(DateUtil.getSysDate());
		}else{
			ordOrderDb.setState("211");
			ordOrderDb.setStateChgTime(DateUtil.getSysDate());
		}
		//操作分配领取人
		ordOrderDb.setOperInterperId("");
		this.ordOrderAtomSV.updateByPrimaryKeySelective(ordOrderDb);

		//
		response.setOrderId(request.getOrderAllocationBaseInfo().getOrderId());
		//
		return response;
	}

	@Override
	public OrdAlloInterperFeeInfoResponse queryAllocationInterperFee(long orderId) {
		OrdAlloInterperFeeInfoResponse response = new OrdAlloInterperFeeInfoResponse();
		OrdOrderInferperFeeAttach ordOrderFeeAttach = this.ordOrderAttachAtomSV.queryAlocationInterperFee(orderId,
				OrdersConstants.RECEIVE_ALREADY_STATE);
		if (ordOrderFeeAttach != null) {
			BeanUtils.copyVO(response, ordOrderFeeAttach);
		}
		ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstants.Special.SUCCESS, "订单对应的译员佣金查询成功");
		response.setResponseHeader(responseHeader);
		return response;
	}

}
