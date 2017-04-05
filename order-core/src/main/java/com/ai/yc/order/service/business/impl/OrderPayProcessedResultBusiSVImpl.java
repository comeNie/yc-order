package com.ai.yc.order.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.yc.order.api.orderpay.param.OrderPayProcessedResultRequest;
import com.ai.yc.order.api.orderpay.param.OrderPayProcessedResultResponse;
import com.ai.yc.order.api.orderpay.param.OrderPayProcessedResultStateChgInfo;
import com.ai.yc.order.constants.OrdOdStateChgConstants;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.dao.mapper.bo.OrdBalacneIf;
import com.ai.yc.order.dao.mapper.bo.OrdOdFeeTotal;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdWithBLOBs;
import com.ai.yc.order.dao.mapper.bo.OrdOdStateChg;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.service.atom.interfaces.IOrdBalacneIfAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdFeeTotalAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdStateChgAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.business.interfaces.IOrderPayProcessedResultBusiSV;
import com.ai.yc.order.util.DateCycleUtil;
import com.ai.yc.order.util.SequenceUtil;

/**
 * 
 * @author zhangzd
 *
 */
@Service
public class OrderPayProcessedResultBusiSVImpl implements IOrderPayProcessedResultBusiSV {
	@Autowired
	private IOrdOrderAtomSV ordOrderAtomSV;
	@Autowired
	private IOrdOdFeeTotalAtomSV ordOdFeeTotalAtomSV;
	@Autowired
	private IOrdOdProdAtomSV ordOdProdAtomSV;
	@Autowired
	private IOrdBalacneIfAtomSV ordBalacneIfAtomSV;
	@Autowired
	private IOrdOdStateChgAtomSV ordOdStateChgAtomSV;// 订单轨迹表

	@Override
	@Transactional
	public OrderPayProcessedResultResponse updateOrderPayProcessedResult(OrderPayProcessedResultRequest request) {
		OrderPayProcessedResultResponse response = new OrderPayProcessedResultResponse();
		OrdOrder ordOrderDb = this.ordOrderAtomSV.findByPrimaryKey(request.getBaseInfo().getOrderId());
		if (null == ordOrderDb) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "此订单信息不存在");
		}
		//判断是否支付
		OrdBalacneIf ordBalacneIf = this.ordBalacneIfAtomSV.findByOrderId(request.getBaseInfo().getOrderId());
		if(null != ordBalacneIf){
			throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR, "此订单已经支付，请不要重复支付");
		}
		//
		this.baseInfo(request);
		this.feeInfo(request);
		this.prodInfo(request);
		this.payInfo(request);

		String userId = request.getBaseInfo().getUserId();
		Long orderId = request.getBaseInfo().getOrderId();
		String translateType = ordOrderDb.getTranslateType();// 数据库获取订单翻译类型
		String oldState = ordOrderDb.getState();// 数据库获取订单当前状态
		String newState = OrdersConstants.OrderState.STATE_WAIT_RECEIVE;// 新状态为
																		// 待领取
		// return operName 2017-01-17 17:13 zhangzd
		String operName = this.returnOperName(request.getStateChgInfo());
		//
		this.orderStateChgInfoSubmit(userId, orderId, translateType, oldState, newState, operName);
		//
		response.setOrderId(request.getBaseInfo().getOrderId());
		//
		return response;
	}

	/**
	 * 基本信息
	 */
	public void baseInfo(OrderPayProcessedResultRequest request) {
		// 订单基本信息修改
		OrdOrder ordOrder = new OrdOrder();
		//
		BeanUtils.copyVO(ordOrder, request.getBaseInfo());
		// 订单状态
		ordOrder.setState(OrdersConstants.OrderState.STATE_WAIT_RECEIVE);// 待领取
		// 客户端显示状态
		ordOrder.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_TRASLATING);// 翻译中
		// 客户端显示状态修改时间
		ordOrder.setDisplayFlagChgTime(DateUtil.getSysDate());
		//
		this.ordOrderAtomSV.updateByPrimaryKeySelective(ordOrder);
	}

	/**
	 * 费用信息
	 */
	public void feeInfo(OrderPayProcessedResultRequest request) {
		// 订单费用信息修改
		OrdOdFeeTotal ordOdFeeTotal = new OrdOdFeeTotal();
		//
		BeanUtils.copyVO(ordOdFeeTotal, request.getFeeInfo());
		ordOdFeeTotal.setDiscountSum(request.getFeeInfo().getDiscountFee());
		//
		this.ordOdFeeTotalAtomSV.updateByOrderIdSelective(request.getBaseInfo().getOrderId(), ordOdFeeTotal);

	}

	/**
	 * 产品信息
	 */
	public void prodInfo(OrderPayProcessedResultRequest request) {
		OrdOdProdWithBLOBs ordOdProdDb = this.ordOdProdAtomSV.findByOrderId(request.getBaseInfo().getOrderId());
		//
		if (OrdersConstants.TranslateType.ORDER_TYPE_FAST.equals(ordOdProdDb.getTranslateType())
				|| OrdersConstants.TranslateType.ORDER_TYPE_DOC.equals(ordOdProdDb.getTranslateType())) {

			// 订单产品下单成功时间修改
			OrdOdProdWithBLOBs ordOdProdWithBLOBs = new OrdOdProdWithBLOBs();
			ordOdProdWithBLOBs.setStateTime(request.getProdInfo().getStateTime());

			//
			Integer takeDay = Integer.valueOf(ordOdProdDb.getTakeDay());
			Integer takeTime = Integer.valueOf(ordOdProdDb.getTakeTime());
			//
			ordOdProdWithBLOBs.setEndTime(
					DateCycleUtil.getTimestamp(request.getProdInfo().getStateTime(), "H", takeDay * 24 + takeTime));
			//es_end_time
			ordOdProdWithBLOBs.setEsEndTime(ordOdProdWithBLOBs.getEndTime());
			
			//
			this.ordOdProdAtomSV.updateByOrderIdSelective(ordOdProdWithBLOBs, request.getBaseInfo().getOrderId());
		}
	}

	/**
	 * 支付信息
	 */
	public void payInfo(OrderPayProcessedResultRequest request) {
		// 添加支付机构信息
		OrdBalacneIf ordBalacneIf = new OrdBalacneIf();
		//
		Long balacneIfId = SequenceUtil.createBalacneIfId();
		ordBalacneIf.setBalacneIfId(balacneIfId);// 自动编号
		// 订单编号
		ordBalacneIf.setOrderId(request.getBaseInfo().getOrderId());
		// 支付方式
		ordBalacneIf.setPayStyle(request.getFeeInfo().getPayStyle());
		// 币种
		OrdOdFeeTotal ordOdFeeTotal = this.ordOdFeeTotalAtomSV.findByOrderId(request.getBaseInfo().getOrderId());
		if (null != ordOdFeeTotal) {
			if (null != ordOdFeeTotal.getCurrencyUnit()) {
				ordBalacneIf.setCurrencyUnit(ordOdFeeTotal.getCurrencyUnit());
			}
		}

		// 支付费用
		ordBalacneIf.setPayFee(request.getFeeInfo().getTotalFee());
		// 支付中心编号 默认为1
		ordBalacneIf.setPaySystemId("1");
		// 支付时间
		ordBalacneIf.setPayTime(request.getFeeInfo().getPayTime());
		ordBalacneIf.setCreateTime(request.getFeeInfo().getPayTime());
		// 外部流水号
		ordBalacneIf.setExternalId(request.getFeeInfo().getExternalId());
		this.ordBalacneIfAtomSV.insertSelective(ordBalacneIf);
		//
	}

	/**
	 * 订单提交-订单轨迹表
	 */
	public void orderStateChgInfoSubmit(String userId, Long orderId, String translateType, String oldState,
			String newState,String operName) {
		OrdOdStateChg ordOdStateChg = new OrdOdStateChg();
		//
		Long stateChgId = SequenceUtil.createStateChgId();
		//
		ordOdStateChg.setStateChgId(stateChgId);
		ordOdStateChg.setOrderId(orderId);
		ordOdStateChg.setOperId(userId);
		ordOdStateChg.setOperName(operName);
		ordOdStateChg.setOrgState(oldState);
		ordOdStateChg.setNewState(newState);
		ordOdStateChg.setChgDesc("客户支付了订单");
		ordOdStateChg.setChgDescEn("The client has paid for the order");
		ordOdStateChg.setChgDescD("订单已支付成功，进入任务中心等待译员领取");
		ordOdStateChg.setChgDescUEn("Your order has been paid and released to the task center.  A translator will be assigned to deal with the task.");
		ordOdStateChg.setFlag(OrdOdStateChgConstants.FLAG_USER);
		ordOdStateChg.setStateChgTime(DateUtil.getSysDate());
		this.ordOdStateChgAtomSV.insertSelective(ordOdStateChg);
	}
	/**
	 * return operName
	 * @author zhangzd
	 */
	public String returnOperName(OrderPayProcessedResultStateChgInfo stateChgInfo){
		//
		String operName = "";
		if(null == stateChgInfo){
			operName = "";
		}else{
			if(!StringUtil.isBlank(stateChgInfo.getOperName())){
				operName = stateChgInfo.getOperName();
			}
		}
		//
		return operName;
	}

}
