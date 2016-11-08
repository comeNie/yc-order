package com.ai.yc.order.service.business.impl.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.components.ses.SESClientFactory;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.yc.order.constants.SearchConstants;
import com.ai.yc.order.dao.mapper.bo.OrdBalacneIf;
import com.ai.yc.order.dao.mapper.bo.OrdOdFeeTotal;
import com.ai.yc.order.dao.mapper.bo.OrdOdProd;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdExtend;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.search.bo.OrdProdExtend;
import com.ai.yc.order.search.bo.OrderInfo;
import com.ai.yc.order.service.atom.interfaces.IOrdBalacneIfAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdFeeTotalAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdExtendAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.business.interfaces.search.IOrderIndexBusiSV;

@Service
public class OrderIndexBusiSVImpl implements IOrderIndexBusiSV {

	@Autowired
	private IOrdOdProdAtomSV ordOdProdAtomSV;
	@Autowired
	private IOrdOdProdExtendAtomSV ordOdProdExtendAtomSV;
	@Autowired
	private IOrdOdFeeTotalAtomSV ordOdFeeTotalAtomSV;
	@Autowired
	private IOrdBalacneIfAtomSV ordBalacneIfAtomSV;
	@Autowired
	private IOrdOrderAtomSV ordOrderAtomSV;
	@Override
	public List<OrderInfo> orderFillQuery(List<OrdOrder> ordList) throws BusinessException, SystemException {

		List<OrderInfo> ordInfoList = new ArrayList<>();
		List<OrdProdExtend> ordextendList = new ArrayList<OrdProdExtend>();
		for (OrdOrder ord : ordList) {
			OrderInfo ordInfo = new OrderInfo();
			ordInfo.setOrderid(ord.getOrderId().toString());
			ordInfo.setBusitype(ord.getBusiType());
			ordInfo.setCorpoarid(ord.getCorporaId());
			ordInfo.setFlag(ord.getFlag());
			ordInfo.setInterperid(ord.getInterperId());
			ordInfo.setInterpertype(ord.getInterperType());
			ordInfo.setTimezone(ord.getTimeZone());
			ordInfo.setDisplayflag(ord.getDisplayFlag());
			ordInfo.setFinishtime(ord.getFinishTime());
			ordInfo.setChlid(ord.getChlId());
			ordInfo.setLspid(ord.getLspId());
			ordInfo.setKeywords(ord.getKeywords());
			ordInfo.setOrderlevel(ord.getOrderLevel());
			ordInfo.setOrdertype(ord.getOrderType());
			ordInfo.setStatechgtime(ord.getStateChgTime());
			ordInfo.setState(ord.getState());
			ordInfo.setUsertype(ord.getUserType());
			ordInfo.setUpdateflag(ord.getUpdateFlag());
			ordInfo.setOrdertime(ord.getOrderTime());
			ordInfo.setLocktime(ord.getLockTime());
			ordInfo.setTranslatename(ord.getTranslateName());
			ordInfo.setTranslatetype(ord.getTranslateType());
			ordInfo.setSubflag(ord.getSubFlag());
			//赋值假数据
			ordInfo.setUsername("test");
			ordInfo.setLspname("test");
			//BeanUtils.copyProperties(ordInfo, ord);
			// 查询商品信息
			OrdOdProd ordOdProd = ordOdProdAtomSV.findByOrderId(ord.getOrderId());
			if (ordOdProd != null) {
				ordInfo.setStarttime(ordOdProd.getStateTime());
				ordInfo.setEndtime(ordOdProd.getEndTime());
				ordInfo.setUsecode(ordOdProd.getUseCode());
				ordInfo.setField(ordOdProd.getFieldCode());
				ordInfo.setProddetailid(ordOdProd.getProdDetalId());
			}
			// 查询语言对信息
			List<OrdOdProdExtend> ordOdProdExtendList = ordOdProdExtendAtomSV.findByOrderId(ord.getOrderId());
			if (!CollectionUtil.isEmpty(ordOdProdExtendList)) {
				for (OrdOdProdExtend extend : ordOdProdExtendList) {
					OrdProdExtend prodextend = new OrdProdExtend();
					prodextend.setLangungechname(extend.getLangungePairName());
					prodextend.setLangungeenname(extend.getLangungeNameEn());
					prodextend.setLangungeid(extend.getLangungePair());
					ordextendList.add(prodextend);
				}
				ordInfo.setOrdextendes(ordextendList);
			}
			// 查询费用信息
			OrdOdFeeTotal ordOdFeeTotal = ordOdFeeTotalAtomSV.findByOrderId(ord.getOrderId());
			if (ordOdFeeTotal != null) {
				ordInfo.setUpdateoperid(ordOdFeeTotal.getUpdateOperId());
				ordInfo.setUpdatetime(ordOdFeeTotal.getUpdateTime());
			}
			// 查询支付信息
			OrdBalacneIf ordBalacneIf = ordBalacneIfAtomSV.findByOrderId(ord.getOrderId());
			if (ordBalacneIf != null) {
				ordInfo.setPaystyle(ordBalacneIf.getPayStyle());
				ordInfo.setPaytime(ordBalacneIf.getPayTime());
			}
			ordInfoList.add(ordInfo);
			
		}
		return ordInfoList;
	}

	@Override
    @Transactional
	public boolean insertSesData(long orderId) throws BusinessException, SystemException {
		 try {
			 OrdOrder ord = ordOrderAtomSV.findByPrimaryKey(orderId);
				List<OrdProdExtend> ordextendList = new ArrayList<OrdProdExtend>();
				List<OrderInfo> orderList = new ArrayList<OrderInfo>();
				if(ord!=null){
					OrderInfo ordInfo = new OrderInfo();
					ordInfo.setOrderid(ord.getOrderId().toString());
					ordInfo.setBusitype(ord.getBusiType());
					ordInfo.setCorpoarid(ord.getCorporaId());
					ordInfo.setFlag(ord.getFlag());
					ordInfo.setInterperid(ord.getInterperId());
					ordInfo.setInterpertype(ord.getInterperType());
					ordInfo.setTimezone(ord.getTimeZone());
					ordInfo.setDisplayflag(ord.getDisplayFlag());
					ordInfo.setFinishtime(ord.getFinishTime());
					ordInfo.setChlid(ord.getChlId());
					ordInfo.setLspid(ord.getLspId());
					ordInfo.setKeywords(ord.getKeywords());
					ordInfo.setOrderlevel(ord.getOrderLevel());
					ordInfo.setOrdertype(ord.getOrderType());
					ordInfo.setStatechgtime(ord.getStateChgTime());
					ordInfo.setState(ord.getState());
					ordInfo.setUsertype(ord.getUserType());
					ordInfo.setUpdateflag(ord.getUpdateFlag());
					ordInfo.setOrdertime(ord.getOrderTime());
					ordInfo.setLocktime(ord.getLockTime());
					ordInfo.setTranslatename(ord.getTranslateName());
					ordInfo.setTranslatetype(ord.getTranslateType());
					ordInfo.setSubflag(ord.getSubFlag());
					//赋值假数据
					ordInfo.setUsername("test");
					ordInfo.setLspname("test");
					// 查询商品信息
					OrdOdProd ordOdProd = ordOdProdAtomSV.findByOrderId(ord.getOrderId());
					if (ordOdProd != null) {
						ordInfo.setStarttime(ordOdProd.getStateTime());
						ordInfo.setEndtime(ordOdProd.getEndTime());
						ordInfo.setUsecode(ordOdProd.getUseCode());
						ordInfo.setField(ordOdProd.getFieldCode());
						ordInfo.setProddetailid(ordOdProd.getProdDetalId());
					}
					// 查询语言对信息
					List<OrdOdProdExtend> ordOdProdExtendList = ordOdProdExtendAtomSV.findByOrderId(ord.getOrderId());
					if (!CollectionUtil.isEmpty(ordOdProdExtendList)) {
						for (OrdOdProdExtend extend : ordOdProdExtendList) {
							OrdProdExtend prodextend = new OrdProdExtend();
							prodextend.setLangungechname(extend.getLangungePairName());
							prodextend.setLangungeenname(extend.getLangungeNameEn());
							prodextend.setLangungeid(extend.getLangungePair());
							ordextendList.add(prodextend);
						}
						ordInfo.setOrdextendes(ordextendList);
					}
					// 查询费用信息
					OrdOdFeeTotal ordOdFeeTotal = ordOdFeeTotalAtomSV.findByOrderId(ord.getOrderId());
					if (ordOdFeeTotal != null) {
						ordInfo.setUpdateoperid(ordOdFeeTotal.getUpdateOperId());
						ordInfo.setUpdatetime(ordOdFeeTotal.getUpdateTime());
					}
					// 查询支付信息
					OrdBalacneIf ordBalacneIf = ordBalacneIfAtomSV.findByOrderId(ord.getOrderId());
					if (ordBalacneIf != null) {
						ordInfo.setPaystyle(ordBalacneIf.getPayStyle());
						ordInfo.setPaytime(ordBalacneIf.getPayTime());
					}
					orderList.add(ordInfo);
					SESClientFactory.getSearchClient(SearchConstants.SearchNameSpace).bulkInsert(orderList);
				}
		 }catch(Exception e){
			 
		 }
            return true;
	}

}
