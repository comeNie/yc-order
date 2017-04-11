package com.ai.yc.order.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.yc.order.api.translatesave.param.SaveTranslateInfoRequest;
import com.ai.yc.order.api.translatesave.param.TranslateFileVo;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.constants.ResultCodeConstants;
import com.ai.yc.order.dao.mapper.bo.OrdOdProd;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdFile;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdWithBLOBs;
import com.ai.yc.order.dao.mapper.bo.OrdOdReceiveFollow;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdFileAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdReceiveFollowAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.business.interfaces.ITranslateSaveBusiSV;
import com.ai.yc.order.service.business.interfaces.search.IOrderIndexBusiSV;
import com.ai.yc.order.util.SequenceUtil;

@Service
@Transactional
public class TranslateSaveBusiSVImpl implements ITranslateSaveBusiSV {
	
	@Autowired
	private transient IOrdOrderAtomSV iOrdOrderAtomSV;
	
	@Autowired
	private transient IOrdOdProdAtomSV iOrdOdProdAtomSV;
	
	@Autowired
	private transient IOrdOdProdFileAtomSV iOrdOdProdFileAtomSV;
	
	@Autowired
	private IOrderIndexBusiSV orderIndexBusiSV;
	
	@Autowired
	private IOrdOdReceiveFollowAtomSV ordOdReceiveFollowAtomSV;// 任务跟踪服务

	@Override
	public BaseResponse saveTranslateInfo(SaveTranslateInfoRequest request) {
		OrdOrder record = iOrdOrderAtomSV.findByPrimaryKey(request.getOrderId());
		if(record==null){
			throw new BusinessException(ExceptCodeConstants.Special.NO_RESULT, "订单不存在");
		}
		if(OrdersConstants.TranslateType.ORDER_TYPE_FAST.equals(record.getTranslateType())){
			OrdOdProdWithBLOBs ordOdProd = new OrdOdProdWithBLOBs();
			ordOdProd.setTranslateInfo(request.getTranslateInfo());
			iOrdOdProdAtomSV.updateByOrderIdSelective(ordOdProd, request.getOrderId());
		}else if(OrdersConstants.TranslateType.ORDER_TYPE_DOC.equals(record.getTranslateType())){
			OrdOdProd prodRecord = iOrdOdProdAtomSV.findByOrderId(request.getOrderId());
			if(prodRecord!=null&&request.getFileVos()!=null){
				iOrdOdProdFileAtomSV.deleteByProdDetalId(prodRecord.getProdDetalId());
				for(TranslateFileVo prodFile:request.getFileVos()){
					OrdOdProdFile ordOdProdFile = new OrdOdProdFile();
					Long prodFileId = SequenceUtil.createProdDetailFileId();
					BeanUtils.copyProperties(ordOdProdFile, prodFile);
					ordOdProdFile.setProdFileId(String.valueOf(prodFileId));
					ordOdProdFile.setProdDetalId(prodRecord.getProdDetalId());
					iOrdOdProdFileAtomSV.insertSelective(ordOdProdFile);
				}
			}
		}
		//根据任务跟踪id修改任务跟踪信息
		if(null!=request.getReceiveFollowId()){
			OrdOdReceiveFollow ordOdReceiveFollow = new OrdOdReceiveFollow();
			ordOdReceiveFollow.setReceiveFollowId(request.getReceiveFollowId());
			OrdOdReceiveFollow ordOdFollow = ordOdReceiveFollowAtomSV.find(ordOdReceiveFollow);
			//判断当前步骤是否是最后步骤
			String curentStep = ordOdFollow.getStep();
			int nextstep = Integer.parseInt(curentStep)+1;
			ordOdReceiveFollow = new OrdOdReceiveFollow();
			ordOdReceiveFollow.setOrderId(request.getOrderId());
			ordOdReceiveFollow.setStep(String.valueOf(nextstep));
			OrdOdReceiveFollow ordOdNextFollow = ordOdReceiveFollowAtomSV.find(ordOdReceiveFollow);
			if(null!=ordOdNextFollow){
				//将当前步骤修改为已完成，下步骤领取状态为待领取，将订单状态改回已分配
				ordOdFollow.setFinishState("2");
				ordOdReceiveFollowAtomSV.updateSelective(ordOdFollow);
				ordOdNextFollow.setReceiveState("2");
				ordOdReceiveFollowAtomSV.updateSelective(ordOdNextFollow);
				OrdOrder order = new OrdOrder();
				order.setOrderId(request.getOrderId());
				order.setState("211");
				iOrdOrderAtomSV.updateByPrimaryKeySelective(order);
				//添加轨迹信息
			}else {
				//将当前步骤改成已完成，将订单状态改成LSP待审核
				ordOdFollow.setFinishState("2");
				ordOdReceiveFollowAtomSV.updateSelective(ordOdFollow);
				OrdOrder order = new OrdOrder();
				order.setOrderId(request.getOrderId());
				order.setState("93");
				iOrdOrderAtomSV.updateByPrimaryKeySelective(order);
			}
		}
		 //更新搜索引擎
		orderIndexBusiSV.insertSesData(request.getOrderId());
		BaseResponse resp = new BaseResponse();
		resp.setResponseHeader(new ResponseHeader(true, ResultCodeConstants.SUCCESS_CODE, "查询成功"));
		return resp;
	}

}
