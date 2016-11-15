package com.ai.yc.order.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.yc.order.api.paystatus.param.UpdatePayStatusRequest;
import com.ai.yc.order.api.paystatus.param.UpdatePayStatusResponse;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.constants.ResultCodeConstants;
import com.ai.yc.order.dao.mapper.bo.OrdOdFeeTotal;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdWithBLOBs;
import com.ai.yc.order.dao.mapper.bo.OrdOdStateChg;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.service.atom.interfaces.IOrdOdFeeTotalAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.business.interfaces.IOrdOdStateChgBusiSV;
import com.ai.yc.order.service.business.interfaces.IUpdatePayStatusBusiSV;
import com.ai.yc.order.service.business.interfaces.search.IOrderIndexBusiSV;

/**
 * @author hougang@asiainfo.com
 * @date 2016年11月7日 下午1:41:11 
 * @version V1.0
 */
@Service
@Transactional
public class UpdatePayStatusBusiSVImpl implements IUpdatePayStatusBusiSV {
	
	@Autowired
	private transient IOrdOrderAtomSV iOrdOrderAtomSV;
	
	@Autowired
	private transient IOrdOdFeeTotalAtomSV iOrdOdFeeTotalAtomSV;
	
	@Autowired
	private transient IOrdOdProdAtomSV iOrdOdProdAtomSV;
	
	@Autowired
	private IOrdOdStateChgBusiSV iOrdOdStateChgBusiSV;
	
	@Autowired
	private IOrderIndexBusiSV orderIndexBusiSV;

	@Override
	public UpdatePayStatusResponse updatePayStatus(UpdatePayStatusRequest req) {
		UpdatePayStatusResponse resp = new UpdatePayStatusResponse();
		//支付轨迹
		OrdOdStateChg chg = new OrdOdStateChg();
		OrdOrder record = iOrdOrderAtomSV.findByPrimaryKey(req.getOrderId());
		if(record==null){
			throw new BusinessException(ExceptCodeConstants.Special.NO_RESULT, "订单不存在");
		}
		if(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_OFFER.equals(record.getDisplayFlag())){
			throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR, "订单等待报价中");
		}
		if(OrdersConstants.OrderDisplayFlag.FLAG_CANCEL.equals(record.getDisplayFlag())){
			throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR, "订单已取消");
		}
		if(OrdersConstants.OrderDisplayFlag.FLAG_REFUNDED.equals(record.getDisplayFlag())){
			throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR, "订单已退款");
		}
		if(!OrdersConstants.OrderDisplayFlag.FLAG_WAIT_PAY.equals(record.getDisplayFlag())){
			throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR, "订单已支付");
		}
		chg.setOrgState(record.getState());
		chg.setNewState(OrdersConstants.OrderState.STATE_WAIT_RECEIVE);
		//修改主表信息
		record.setState(OrdersConstants.OrderState.STATE_WAIT_RECEIVE);
		record.setStateChgTime(DateUtil.getSysDate());
		record.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_TRASLATING);
		record.setDisplayFlagChgTime(DateUtil.getSysDate());
		record.setPayRemark(req.getOrderFee().getRemark());
		iOrdOrderAtomSV.updateByPrimaryKeySelective(record);
		
		//修改费用信息
		OrdOdFeeTotal feeTotal = new OrdOdFeeTotal();
		BeanUtils.copyProperties(feeTotal, req.getOrderFee());
		feeTotal.setPayTime(DateUtil.getSysDate());
		iOrdOdFeeTotalAtomSV.updateByOrderIdSelective(req.getOrderId(), feeTotal);
		
		//修改产品信息
		if(!OrdersConstants.TranslateType.ORDER_TYPE_ORAL.equals(record.getTranslateType())){
			OrdOdProdWithBLOBs ordOdProd = new  OrdOdProdWithBLOBs();
			ordOdProd.setStateTime(DateUtil.getSysDate());
			iOrdOdProdAtomSV.updateByOrderIdSelective(ordOdProd, req.getOrderId());
		}
		
		//添加订单状态支付轨迹
		chg.setOperId(req.getOperId());
		chg.setOperName(req.getOperName());
		chg.setOrgId(OrdersConstants.OrgID.ORG_ID_SYS);
		chg.setOrderId(req.getOrderId());
		iOrdOdStateChgBusiSV.addPayChgDesc(chg);
		 //更新搜索引擎
		orderIndexBusiSV.insertSesData(req.getOrderId());
		resp.setOrderId(req.getOrderId());
		resp.setResponseHeader(new ResponseHeader(true, ResultCodeConstants.SUCCESS_CODE, "查询成功"));
		return resp;
	}

}
