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
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdFileAtomSV;
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
		 //更新搜索引擎
		orderIndexBusiSV.insertSesData(request.getOrderId());
		BaseResponse resp = new BaseResponse();
		resp.setResponseHeader(new ResponseHeader(true, ResultCodeConstants.SUCCESS_CODE, "查询成功"));
		return resp;
	}

}
