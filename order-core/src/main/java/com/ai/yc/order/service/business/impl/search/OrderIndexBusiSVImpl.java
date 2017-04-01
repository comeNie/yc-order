package com.ai.yc.order.service.business.impl.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.components.ses.SESClientFactory;
import com.ai.opt.sdk.dubbo.util.DubboConsumerFactory;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.yc.common.api.sysuser.interfaces.ISysUserQuerySV;
import com.ai.yc.common.api.sysuser.param.SysUserQueryRequest;
import com.ai.yc.common.api.sysuser.param.SysUserQueryResponse;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.constants.SearchConstants;
import com.ai.yc.order.dao.mapper.bo.OrdEvaluate;
import com.ai.yc.order.dao.mapper.bo.OrdOdFeeTotal;
import com.ai.yc.order.dao.mapper.bo.OrdOdProd;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdExtend;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdLevel;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.search.bo.OrdProdExtend;
import com.ai.yc.order.search.bo.OrdProdLevel;
import com.ai.yc.order.search.bo.OrderInfo;
import com.ai.yc.order.service.atom.interfaces.IOrdEvaluateAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdFeeTotalAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdExtendAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdLevelAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.business.interfaces.search.IOrderIndexBusiSV;
import com.ai.yc.translator.api.translatorservice.interfaces.IYCTranslatorServiceSV;
import com.ai.yc.translator.api.translatorservice.param.SearchYCTranslatorRequest;
import com.ai.yc.translator.api.translatorservice.param.YCLSPInfoReponse;
import com.ai.yc.translator.api.translatorservice.param.YCTranslatorInfoResponse;
import com.ai.yc.translator.api.translatorservice.param.searchYCLSPInfoRequest;
import com.ai.yc.user.api.userservice.interfaces.IYCUserServiceSV;
import com.ai.yc.user.api.userservice.param.SearchYCUserRequest;
import com.ai.yc.user.api.userservice.param.YCUserInfoResponse;

@Service
public class OrderIndexBusiSVImpl implements IOrderIndexBusiSV {

	@Autowired
	private IOrdOdProdAtomSV ordOdProdAtomSV;
	@Autowired
	private IOrdOdProdExtendAtomSV ordOdProdExtendAtomSV;
	@Autowired
	private IOrdOdFeeTotalAtomSV ordOdFeeTotalAtomSV;
	@Autowired
	private IOrdOrderAtomSV ordOrderAtomSV;
	@Autowired
	private IOrdOdProdLevelAtomSV ordOdProdLevelAtomSV;
	@Autowired
	private IOrdEvaluateAtomSV ordEvaluateAtomSV;
	@Override
	public List<OrderInfo> orderFillQuery(List<OrdOrder> ordList) throws BusinessException, SystemException {

		List<OrderInfo> ordInfoList = new ArrayList<>();
		for (OrdOrder ord : ordList) {
			List<OrdProdExtend> ordextendList = new ArrayList<OrdProdExtend>();
			List<OrdProdLevel> ordLevelLists = new ArrayList<OrdProdLevel>();
			OrderInfo ordInfo = new OrderInfo();
			ordInfo.setOrderid(ord.getOrderId().toString());
			ordInfo.setParentorderid(ord.getParentOrderId());
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
			ordInfo.setOperid(ord.getOperId());
			ordInfo.setUserid(ord.getUserId());
			ordInfo.setEndchgtime(ord.getEndChgTime());
			//获取昵称
			IYCUserServiceSV userServiceSV = DubboConsumerFactory.getService(IYCUserServiceSV.class);
			if(!StringUtil.isBlank(ord.getUserId())){
				SearchYCUserRequest request = new SearchYCUserRequest();
				request.setUserId(ord.getUserId());
				YCUserInfoResponse response = userServiceSV.searchYCUserInfo(request);
				if(response.getResponseHeader().isSuccess()==true){
					ordInfo.setUsername(response.getNickname());
				}
			}
			IYCTranslatorServiceSV iYCTranslatorServiceSV = DubboConsumerFactory.getService(IYCTranslatorServiceSV.class);
			//获取lsp名称
			if(!StringUtil.isBlank(ord.getLspId())){
				searchYCLSPInfoRequest lSPInfoRequest = new searchYCLSPInfoRequest();
				lSPInfoRequest.setLspId(ord.getLspId());
				YCLSPInfoReponse lsp = iYCTranslatorServiceSV.searchLSPInfo(lSPInfoRequest);
				if(lsp.getResponseHeader().isSuccess()==true){
					ordInfo.setLspname(lsp.getLspName());
				}
			}
			//获取译员昵称
			if(!StringUtil.isBlank(ord.getInterperId())){
				SearchYCTranslatorRequest  translatorRequest = new SearchYCTranslatorRequest();
				translatorRequest.setUserId(ord.getInterperId());
				YCTranslatorInfoResponse  interper = iYCTranslatorServiceSV.searchYCTranslatorInfo(translatorRequest);
				if(interper.getResponseHeader().isSuccess()==true){
					ordInfo.setInterpername(interper.getNickname());
					ordInfo.setInterperlevel(interper.getVipLevel());
				}
			}
			//获取评价信息
			OrdEvaluate ordEvaluate = ordEvaluateAtomSV.findByOrderId(ord.getOrderId());
			if(ordEvaluate!=null){
				ordInfo.setServemanner(ordEvaluate.getServeManner());
				ordInfo.setServequality(ordEvaluate.getServeQuality());
				ordInfo.setServespeed(ordEvaluate.getServeSpeen());
				ordInfo.setEvaluatecontent(ordEvaluate.getEvaluateContent());
				ordInfo.setEvaluatesun(ordEvaluate.getEvaluateSun());
				ordInfo.setEvaluatetime(ordEvaluate.getEvaluateTime());
				ordInfo.setEvaluatestate(ordEvaluate.getState());
			}
			// 查询商品信息
			OrdOdProd ordOdProd = ordOdProdAtomSV.findByOrderId(ord.getOrderId());
			if (ordOdProd != null) {
				ordInfo.setStarttime(ordOdProd.getStateTime());
				ordInfo.setEndtime(ordOdProd.getEndTime());
				ordInfo.setUsecode(ordOdProd.getUseCode());
				ordInfo.setField(ordOdProd.getFieldCode());
				ordInfo.setProddetailid(ordOdProd.getProdDetalId());
				ordInfo.setTakeday(ordOdProd.getTakeDay());
				ordInfo.setTaketime(ordOdProd.getTakeTime());
				ordInfo.setProdupdatetime(ordOdProd.getUpdateTime());
				ordInfo.setEsendtime(ordOdProd.getEsEndTime());
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
			//查询翻译级别信息
			List<OrdOdProdLevel> levelLists = ordOdProdLevelAtomSV.findByOrderId(ord.getOrderId());
			if(!CollectionUtil.isEmpty(levelLists)){
				for(OrdOdProdLevel level:levelLists){
					OrdProdLevel ordLevel = new OrdProdLevel();
					ordLevel.setTranslatelevel(level.getTranslateLevel());
					ordLevelLists.add(ordLevel);
				}
				ordInfo.setOrdprodleveles(ordLevelLists);
			}
			// 查询费用信息
			OrdOdFeeTotal ordOdFeeTotal = ordOdFeeTotalAtomSV.findByOrderId(ord.getOrderId());
			if (ordOdFeeTotal != null) {
				if(!StringUtil.isBlank(ordOdFeeTotal.getUpdateOperId())){
					ISysUserQuerySV iSysUserQuerySV = DubboConsumerFactory.getService(ISysUserQuerySV.class);
					SysUserQueryRequest req = new SysUserQueryRequest();
					req.setId(ordOdFeeTotal.getUpdateOperId());
					req.setTenantId(OrdersConstants.TENANT_ID);
					SysUserQueryResponse userInfo = iSysUserQuerySV.queryUserInfo(req);
					if(userInfo!=null){
						ordInfo.setUpdatename((StringUtil.isBlank(userInfo.getName())?userInfo.getLoginName():userInfo.getName()));
					}
				}
				ordInfo.setUpdateoperid(ordOdFeeTotal.getUpdateOperId());
				ordInfo.setUpdatetime(ordOdFeeTotal.getUpdateTime());
				ordInfo.setTotalfee(ordOdFeeTotal.getTotalFee());
				ordInfo.setDiscountfee(ordOdFeeTotal.getDiscountFee());
				ordInfo.setCurrencyunit(ordOdFeeTotal.getCurrencyUnit());
				ordInfo.setPaystyle(ordOdFeeTotal.getPayStyle());
				ordInfo.setPaytime(ordOdFeeTotal.getPayTime());
				if(ordOdFeeTotal.getPlatFee()!=null){
					ordInfo.setPlatfee(ordOdFeeTotal.getPlatFee());
				}
				if(ordOdFeeTotal.getInterperFee()!=null){
					ordInfo.setInterperfee(ordOdFeeTotal.getInterperFee());
				}
				if(ordOdFeeTotal.getPaidFee()!=null){
					ordInfo.setPaidfee(ordOdFeeTotal.getPaidFee());
				}
				
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
				List<OrdProdLevel> ordLevelList = new ArrayList<OrdProdLevel>();
				if(ord!=null){
					OrderInfo ordInfo = new OrderInfo();
					ordInfo.setOrderid(ord.getOrderId().toString());
					ordInfo.setParentorderid(ord.getParentOrderId());
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
					ordInfo.setOperid(ord.getOperId());
					ordInfo.setUserid(ord.getUserId());
					ordInfo.setEndchgtime(ord.getEndChgTime());
					//获取昵称
					try{
						IYCUserServiceSV userServiceSV = DubboConsumerFactory.getService(IYCUserServiceSV.class);
						if(!StringUtil.isBlank(ord.getUserId())){
							SearchYCUserRequest request = new SearchYCUserRequest();
							request.setUserId(ord.getUserId());
							YCUserInfoResponse response = userServiceSV.searchYCUserInfo(request);
							if(response.getResponseHeader().isSuccess()==true){
								ordInfo.setUsername(response.getNickname());
							}
						}
					}catch(Exception e){
						 throw new SystemException("","调用用户中心获取昵称失败");
					}
					try{
						//获取lsp名称
						IYCTranslatorServiceSV iYCTranslatorServiceSV = DubboConsumerFactory.getService(IYCTranslatorServiceSV.class);
						if(!StringUtil.isBlank(ord.getLspId())){
							searchYCLSPInfoRequest lSPInfoRequest = new searchYCLSPInfoRequest();
							lSPInfoRequest.setLspId(ord.getLspId());
							YCLSPInfoReponse lsp = iYCTranslatorServiceSV.searchLSPInfo(lSPInfoRequest);
							if(lsp.getResponseHeader().isSuccess()==true){
								ordInfo.setLspname(lsp.getLspName());
							}
						}
						//获取译员昵称
						if(!StringUtil.isBlank(ord.getInterperId())){
							SearchYCTranslatorRequest  translatorRequest = new SearchYCTranslatorRequest();
							translatorRequest.setUserId(ord.getInterperId());
							YCTranslatorInfoResponse  interper = iYCTranslatorServiceSV.searchYCTranslatorInfo(translatorRequest);
							if(interper.getResponseHeader().isSuccess()==true){
								ordInfo.setInterpername(interper.getNickname());
								ordInfo.setInterperlevel(interper.getVipLevel());
							}
						}
					}catch(Exception e){
						 throw new SystemException("","调用译员中心获取名称失败");
					}
					//获取评价信息
					OrdEvaluate ordEvaluate = ordEvaluateAtomSV.findByOrderId(ord.getOrderId());
					if(ordEvaluate!=null){
						ordInfo.setServemanner(ordEvaluate.getServeManner());
						ordInfo.setServequality(ordEvaluate.getServeQuality());
						ordInfo.setServespeed(ordEvaluate.getServeSpeen());
						ordInfo.setEvaluatecontent(ordEvaluate.getEvaluateContent());
						ordInfo.setEvaluatesun(ordEvaluate.getEvaluateSun());
						ordInfo.setEvaluatetime(ordEvaluate.getEvaluateTime());
						ordInfo.setEvaluatestate(ordEvaluate.getState());
					}
					// 查询商品信息
					OrdOdProd ordOdProd = ordOdProdAtomSV.findByOrderId(ord.getOrderId());
					if (ordOdProd != null) {
						ordInfo.setStarttime(ordOdProd.getStateTime());
						ordInfo.setEndtime(ordOdProd.getEndTime());
						ordInfo.setUsecode(ordOdProd.getUseCode());
						ordInfo.setField(ordOdProd.getFieldCode());
						ordInfo.setProddetailid(ordOdProd.getProdDetalId());
						ordInfo.setTakeday(ordOdProd.getTakeDay());
						ordInfo.setTaketime(ordOdProd.getTakeTime());
						ordInfo.setProdupdatetime(ordOdProd.getUpdateTime());
						ordInfo.setEsendtime(ordOdProd.getEsEndTime());
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
						ordInfo.setCurrencyunit(ordOdFeeTotal.getCurrencyUnit());
						ordInfo.setTotalfee(ordOdFeeTotal.getTotalFee());
						ordInfo.setDiscountfee(ordOdFeeTotal.getDiscountFee());
						ordInfo.setPaystyle(ordOdFeeTotal.getPayStyle());
						ordInfo.setPaytime(ordOdFeeTotal.getPayTime());
						if(ordOdFeeTotal.getPlatFee()!=null){
							ordInfo.setPlatfee(ordOdFeeTotal.getPlatFee());
						}
						if(ordOdFeeTotal.getInterperFee()!=null){
							ordInfo.setInterperfee(ordOdFeeTotal.getInterperFee());
						}
						if(ordOdFeeTotal.getPaidFee()!=null){
							ordInfo.setPaidfee(ordOdFeeTotal.getPaidFee());
						}
						if(!StringUtil.isBlank(ordOdFeeTotal.getUpdateOperId())){
							ISysUserQuerySV iSysUserQuerySV = DubboConsumerFactory.getService(ISysUserQuerySV.class);
							SysUserQueryRequest req = new SysUserQueryRequest();
							req.setTenantId(OrdersConstants.TENANT_ID);
							req.setId(ordOdFeeTotal.getUpdateOperId());
							SysUserQueryResponse userInfo = iSysUserQuerySV.queryUserInfo(req);
							if(userInfo!=null){
								ordInfo.setUpdatename(userInfo.getName());
							}
						}
					}
					//查询翻译级别信息
					List<OrdOdProdLevel> levelLists = ordOdProdLevelAtomSV.findByOrderId(ord.getOrderId());
					if(!CollectionUtil.isEmpty(levelLists)){
						for(OrdOdProdLevel level:levelLists){
							OrdProdLevel ordLevel = new OrdProdLevel();
							ordLevel.setTranslatelevel(level.getTranslateLevel());
							ordLevelList.add(ordLevel);
						}
						ordInfo.setOrdprodleveles(ordLevelList);
					}
					orderList.add(ordInfo);
					SESClientFactory.getSearchClient(SearchConstants.SearchNameSpace).bulkInsert(orderList);
				}
		 }catch(Exception e){
			 throw new SystemException("","订单信息加入搜索引擎失败,订单ID:"+orderId);
		 }
            return true;
	}

}
