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
import com.ai.opt.sdk.util.StringUtil;
import com.ai.yc.order.api.updateorder.param.UProdFileVo;
import com.ai.yc.order.api.updateorder.param.UProdLevelVo;
import com.ai.yc.order.api.updateorder.param.UpdateOrderRequest;
import com.ai.yc.order.api.updateorder.param.UpdateOrderResponse;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.constants.ResultCodeConstants;
import com.ai.yc.order.dao.mapper.bo.OrdOdFeeTotal;
import com.ai.yc.order.dao.mapper.bo.OrdOdLogistics;
import com.ai.yc.order.dao.mapper.bo.OrdOdProd;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdFile;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdLevel;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdWithBLOBs;
import com.ai.yc.order.dao.mapper.bo.OrdOdStateChg;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.service.atom.interfaces.IOrdOdFeeTotalAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdLogisticsAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdFileAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdLevelAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.business.interfaces.IOrdOdStateChgBusiSV;
import com.ai.yc.order.service.business.interfaces.IUpdateOrderBusiSV;
import com.ai.yc.order.service.business.interfaces.search.IOrderIndexBusiSV;
import com.ai.yc.order.util.SequenceUtil;

/**
 * @author hougang@asiainfo.com
 * @date 2016年11月7日 下午5:22:22
 * @version V1.0
 */
@Service
@Transactional
public class UpdateOrderBusiSVImpl implements IUpdateOrderBusiSV {

	@Autowired
	private transient IOrdOrderAtomSV iOrdOrderAtomSV;

	@Autowired
	private transient IOrdOdLogisticsAtomSV iOrdOdLogisticsAtomSV;

	@Autowired
	private transient IOrdOdProdAtomSV iOrdOdProdAtomSV;

	@Autowired
	private transient IOrdOdProdLevelAtomSV iOrdOdProdLevelAtomSV;

	@Autowired
	private transient IOrdOdProdFileAtomSV iOrdOdProdFileAtomSV;

	@Autowired
	private transient IOrdOdFeeTotalAtomSV iOrdOdFeeTotalAtomSV;

	@Autowired
	private IOrdOdStateChgBusiSV iOrdOdStateChgBusiSV;

	@Autowired
	private IOrderIndexBusiSV orderIndexBusiSV;

	@Override
	public UpdateOrderResponse updateOrderInfo(UpdateOrderRequest req) {
		UpdateOrderResponse resp = new UpdateOrderResponse();
		resp.setResponseHeader(new ResponseHeader(true, ResultCodeConstants.SUCCESS_CODE, "查询成功"));
		OrdOrder record = iOrdOrderAtomSV.findByPrimaryKey(req.getOrderId());
		if (record == null) {
			throw new BusinessException(ExceptCodeConstants.Special.NO_RESULT, "订单不存在");
		}
		resp.setOrderId(req.getOrderId());

		// 修改联系人信息
		if (req.getContacts() != null) {
			OrdOdLogistics logistics = new OrdOdLogistics();
			BeanUtils.copyProperties(logistics, req.getContacts());
			iOrdOdLogisticsAtomSV.updateByOrderIdSelective(logistics, req.getOrderId());
		}

		OrdOdProd ordOdProdRecord = iOrdOdProdAtomSV.findByOrderId(req.getOrderId());
		// 产品信息
		if (req.getProd() != null) {
			OrdOdProdWithBLOBs ordOdProd = new OrdOdProdWithBLOBs();
			BeanUtils.copyProperties(ordOdProd, req.getProd());
			iOrdOdProdAtomSV.updateByOrderIdSelective(ordOdProd, req.getOrderId());
			// 修改翻译级别
			List<UProdLevelVo> prodLevels = req.getProd().getProdLevels();
			if (ordOdProdRecord != null && prodLevels != null) {
				iOrdOdProdLevelAtomSV.deleteByOrderId(req.getOrderId());
				for (UProdLevelVo prodLevel : prodLevels) {
					OrdOdProdLevel ordOdProdLevel = new OrdOdProdLevel();
					ordOdProdLevel.setProdDetalExtendId(SequenceUtil.createProdDetailLevelId());
					ordOdProdLevel.setOrderId(req.getOrderId());
					ordOdProdLevel.setProdDetalId(ordOdProdRecord.getProdDetalId());
					ordOdProdLevel.setTranslateLevel(prodLevel.getTranslateLevel());
					ordOdProdLevel.setInfoJson(prodLevel.getInfoJson());
					iOrdOdProdLevelAtomSV.insertSelective(ordOdProdLevel);
				}
			}
		}

		// 产品文件信息
		if (ordOdProdRecord != null && req.getProdFiles() != null) {
			iOrdOdProdFileAtomSV.deleteByProdDetalId(ordOdProdRecord.getProdDetalId());
			for (UProdFileVo prodFile : req.getProdFiles()) {
				OrdOdProdFile ordOdProdFile = new OrdOdProdFile();
				Long prodFileId = SequenceUtil.createProdDetailFileId();
				BeanUtils.copyProperties(ordOdProdFile, prodFile);
				ordOdProdFile.setProdFileId(String.valueOf(prodFileId));
				ordOdProdFile.setProdDetalId(ordOdProdRecord.getProdDetalId());
				iOrdOdProdFileAtomSV.insertSelective(ordOdProdFile);
			}
		}
		// 添加修改轨迹
		OrdOdStateChg chg = new OrdOdStateChg();
		chg.setOrderId(record.getOrderId());
		chg.setOrgState(record.getState());
		chg.setNewState(record.getState());
		chg.setOperId(req.getOperId());
		chg.setOperName(req.getOperName());
		iOrdOdStateChgBusiSV.addUpdateChgDesc(chg);
		// 非待报价和非待支付，无法修改下面内容
		if (!OrdersConstants.OrderState.STATE_WAIT_OFFER.equals(record.getState())
				&& !OrdersConstants.OrderState.STATE_WAIT_PAY.equals(record.getState())) {
			// 更新搜索引擎
			orderIndexBusiSV.insertSesData(req.getOrderId());
			return resp;
		}

		// 修改费用信息
		if (req.getOrderFee() != null) {
			Long totalFee = req.getOrderFee().getTotalFee();
			if (totalFee != null && totalFee > 0) {
				OrdOdFeeTotal ordOdFeeTotal = new OrdOdFeeTotal();
				ordOdFeeTotal.setUpdateTime(DateUtil.getSysDate());
				BeanUtils.copyProperties(ordOdFeeTotal, req.getOrderFee());
				iOrdOdFeeTotalAtomSV.updateByOrderIdSelective(req.getOrderId(), ordOdFeeTotal);
				// 如果是报价，则修改订单状态并添加报价轨迹
				if (OrdersConstants.OrderState.STATE_WAIT_OFFER.equals(record.getState())) {
					// 修改订单状态
					record.setState(OrdersConstants.OrderState.STATE_WAIT_PAY);
					record.setStateChgTime(DateUtil.getSysDate());
					record.setDisplayFlag(OrdersConstants.OrderDisplayFlag.FLAG_WAIT_PAY);
					record.setDisplayFlagChgTime(DateUtil.getSysDate());
					iOrdOrderAtomSV.updateByPrimaryKeySelective(record);
					// 添加报价轨迹
					chg.setNewState(OrdersConstants.OrderState.STATE_WAIT_PAY);
					iOrdOdStateChgBusiSV.addOfferChgDesc(chg);
				}

			}
		}
		// 修改订单级别
		if (!StringUtil.isBlank(req.getOrderLevel())) {
			OrdOrder order = new OrdOrder();
			order.setOrderId(req.getOrderId());
			order.setOrderLevel(req.getOrderLevel());
			iOrdOrderAtomSV.updateByPrimaryKeySelective(order);
		}
		// 更新搜索引擎
		orderIndexBusiSV.insertSesData(req.getOrderId());
		return resp;
	}

}
