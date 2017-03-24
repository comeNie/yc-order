package com.ai.yc.order.service.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.yc.common.api.sysdomain.param.QuerySysDomainDetailsRes;
import com.ai.yc.common.api.syspurpose.param.QuerySysPurposeDetailsRes;
import com.ai.yc.common.api.sysuser.param.SysUserQueryRequest;
import com.ai.yc.common.api.sysuser.param.SysUserQueryResponse;
import com.ai.yc.order.api.orderdetails.param.ContactsVo;
import com.ai.yc.order.api.orderdetails.param.EvaluateVo;
import com.ai.yc.order.api.orderdetails.param.OrderFeeVo;
import com.ai.yc.order.api.orderdetails.param.OrderStateChgVo;
import com.ai.yc.order.api.orderdetails.param.PersonInfoVo;
import com.ai.yc.order.api.orderdetails.param.ProdExtendVo;
import com.ai.yc.order.api.orderdetails.param.ProdFileVo;
import com.ai.yc.order.api.orderdetails.param.ProdLevelVo;
import com.ai.yc.order.api.orderdetails.param.ProdVo;
import com.ai.yc.order.api.orderdetails.param.QueryOrderDetailsResponse;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.constants.ResultCodeConstants;
import com.ai.yc.order.dao.mapper.bo.OrdEvaluate;
import com.ai.yc.order.dao.mapper.bo.OrdOdFeeTotal;
import com.ai.yc.order.dao.mapper.bo.OrdOdLogistics;
import com.ai.yc.order.dao.mapper.bo.OrdOdPersonInfo;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdExtend;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdFile;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdLevel;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdWithBLOBs;
import com.ai.yc.order.dao.mapper.bo.OrdOdReceiveFollow;
import com.ai.yc.order.dao.mapper.bo.OrdOdStateChg;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.service.atom.interfaces.IOrdEvaluateAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdFeeTotalAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdLogisticsAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdPersonInfoAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdExtendAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdFileAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdLevelAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdReceiveFollowAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdStateChgAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.atom.interfaces.ISysConfigAtomSV;
import com.ai.yc.order.service.atom.interfaces.ISysUserAtomSV;
import com.ai.yc.order.service.business.interfaces.IQueryOrderDetailsBusiSV;

/**
 * @Description: 订单详情查询
 * @author hougang@asiainfo.com
 * @date 2016年11月5日 上午10:02:18
 * @version V1.0
 */
@Service
public class QueryOrderDetailsBusiSVImpl implements IQueryOrderDetailsBusiSV {

	@Autowired
	private transient IOrdOrderAtomSV iOrdOrderAtomSV;

	@Autowired
	private transient IOrdOdLogisticsAtomSV iOrdOdLogisticsAtomSV;

	@Autowired
	private transient IOrdOdPersonInfoAtomSV iOrdOdPersonInfoAtomSV;

	@Autowired
	private transient IOrdOdProdAtomSV iOrdOdProdAtomSV;

	@Autowired
	private transient IOrdOdProdExtendAtomSV iOrdOdProdExtendAtomSV;

	@Autowired
	private transient IOrdOdProdLevelAtomSV iOrdOdProdLevelAtomSV;

	@Autowired
	private transient IOrdOdStateChgAtomSV iOrdOdStateChgAtomSV;

	@Autowired
	private transient IOrdOdFeeTotalAtomSV iOrdOdFeeTotalAtomSV;

	@Autowired
	private transient IOrdOdProdFileAtomSV iOrdOdProdFileAtomSV;

	@Autowired
	private transient ISysConfigAtomSV iSysConfigAtomSV;

	@Autowired
	private transient ISysUserAtomSV iSysUserAtomSV;

	@Autowired
	private IOrdEvaluateAtomSV ordEvaluateAtomSV;
	@Autowired
	private IOrdOdReceiveFollowAtomSV ordOdReceiveFollowAtomSV;// 任务跟踪服务

	@Override
	public QueryOrderDetailsResponse queryOrderDetails(Long orderId, String flag) {
		QueryOrderDetailsResponse resp = new QueryOrderDetailsResponse();
		// 订单主信息
		OrdOrder ordOrder = iOrdOrderAtomSV.findByPrimaryKey(orderId);
		if (ordOrder == null) {
			throw new BusinessException(ExceptCodeConstants.Special.NO_RESULT, "订单不存在");
		}
		BeanUtils.copyProperties(resp, ordOrder);

		// 联系人
		OrdOdLogistics logistics = iOrdOdLogisticsAtomSV.findByOrderId(orderId);
		if (logistics != null) {
			ContactsVo contacts = new ContactsVo();
			BeanUtils.copyProperties(contacts, logistics);
			resp.setContacts(contacts);
		}

		// 评价信息
		OrdEvaluate ordEvaluate = ordEvaluateAtomSV.findByOrderId(orderId);
		if (ordEvaluate != null) {
			EvaluateVo evaluteVo = new EvaluateVo();
			BeanUtils.copyProperties(evaluteVo, ordEvaluate);
			evaluteVo.setServeSpeed(ordEvaluate.getServeSpeen());
			resp.setEvaluateVo(evaluteVo);
		}

		// 分配人员信息
		List<PersonInfoVo> personInfos = new ArrayList<PersonInfoVo>();
		// 根据订单id获取任务跟踪id
		OrdOdReceiveFollow ordOdReceiveFollow = ordOdReceiveFollowAtomSV.findByOrderId(orderId);
		if (ordOdReceiveFollow != null) {
			long followId = ordOdReceiveFollow.getReceiveFollowId();
			OrdOdPersonInfo personRequst = new OrdOdPersonInfo();
			personRequst.setReceiveFollowId(followId);
			List<OrdOdPersonInfo> ordOdPersonInfos = iOrdOdPersonInfoAtomSV.findPersonInfo(personRequst);
			for (OrdOdPersonInfo ordOdPersonInfo : ordOdPersonInfos) {
				PersonInfoVo personInfoVo = new PersonInfoVo();
				BeanUtils.copyProperties(personInfoVo, ordOdPersonInfo);
				personInfos.add(personInfoVo);
			}
			resp.setPersonInfos(personInfos);
		}
		/*
		 * List<OrdOdPersonInfo> ordOdPersonInfos =
		 * iOrdOdPersonInfoAtomSV.findByOrderId(Long.valueOf(orderId));
		 * for(OrdOdPersonInfo ordOdPersonInfo:ordOdPersonInfos){ PersonInfoVo
		 * personInfoVo = new PersonInfoVo();
		 * BeanUtils.copyProperties(personInfoVo, ordOdPersonInfo);
		 * personInfos.add(personInfoVo); } resp.setPersonInfos(personInfos);
		 */

		// 产品明细信息
		OrdOdProdWithBLOBs ordOdProd = iOrdOdProdAtomSV.findByOrderId(orderId);
		if (ordOdProd != null) {
			ProdVo prod = new ProdVo();
			BeanUtils.copyProperties(prod, ordOdProd);
			if (!StringUtil.isBlank(prod.getUseCode())) {
				QuerySysPurposeDetailsRes purpose = iSysConfigAtomSV.querySysPurposeDetails(prod.getUseCode());
				prod.setUseCn(purpose.getPurposeCn());
				prod.setUseEn(purpose.getPurposeEn());
			}

			if (!StringUtil.isBlank(prod.getFieldCode())) {
				QuerySysDomainDetailsRes domain = iSysConfigAtomSV.querySysDomainDetails(prod.getFieldCode());
				prod.setFieldCn(domain.getDomainCn());
				prod.setFieldEn(domain.getDomainEn());
			}

			resp.setProd(prod);
		}

		// 语言对列表
		List<ProdExtendVo> prodExtends = new ArrayList<ProdExtendVo>();
		List<OrdOdProdExtend> ordOdProdExtends = iOrdOdProdExtendAtomSV.findByOrderId(orderId);
		for (OrdOdProdExtend ordOdProdExtend : ordOdProdExtends) {
			ProdExtendVo prodExtend = new ProdExtendVo();
			BeanUtils.copyProperties(prodExtend, ordOdProdExtend);
			prodExtends.add(prodExtend);
		}
		resp.setProdExtends(prodExtends);

		// 翻译级别列表
		List<ProdLevelVo> prodLevels = new ArrayList<ProdLevelVo>();
		List<OrdOdProdLevel> ordOdProdLevels = iOrdOdProdLevelAtomSV.findByOrderId(orderId);
		for (OrdOdProdLevel ordOdProdLevel : ordOdProdLevels) {
			ProdLevelVo prodLevel = new ProdLevelVo();
			BeanUtils.copyProperties(prodLevel, ordOdProdLevel);
			prodLevels.add(prodLevel);
		}
		resp.setProdLevels(prodLevels);

		// 文件列表
		List<ProdFileVo> prodFiles = new ArrayList<ProdFileVo>();
		if (ordOdProd != null) {
			List<OrdOdProdFile> ordOdProdFiles = iOrdOdProdFileAtomSV.findByProdDetalId(ordOdProd.getProdDetalId());
			for (OrdOdProdFile ordOdProdFile : ordOdProdFiles) {
				ProdFileVo prodFile = new ProdFileVo();
				BeanUtils.copyProperties(prodFile, ordOdProdFile);
				prodFiles.add(prodFile);
			}
		}
		resp.setProdFiles(prodFiles);

		// 订单费用信息
		OrdOdFeeTotal ordOdFeeTotal = iOrdOdFeeTotalAtomSV.findByOrderId(OrdersConstants.OrdOdFeeTotal.PAY_FLAG_IN,
				orderId);
		if (ordOdFeeTotal != null) {
			OrderFeeVo orderFee = new OrderFeeVo();
			BeanUtils.copyProperties(orderFee, ordOdFeeTotal);
			// 获取操作员工姓名
			if (!StringUtil.isBlank(orderFee.getUpdateOperId())) {
				SysUserQueryRequest req = new SysUserQueryRequest();
				req.setTenantId(OrdersConstants.TENANT_ID);
				req.setId(orderFee.getUpdateOperId());
				SysUserQueryResponse userInfo = iSysUserAtomSV.queryUserInfo(req);
				if (userInfo != null) {
					orderFee.setUpdateOperName(
							StringUtil.isBlank(userInfo.getName()) ? userInfo.getLoginName() : userInfo.getName());
				}
			}
			resp.setOrderFee(orderFee);
		}

		// 订单状态轨迹
		List<OrderStateChgVo> orderStateChgs = new ArrayList<OrderStateChgVo>();
		List<OrdOdStateChg> ordOdStateChgs = iOrdOdStateChgAtomSV.findByOrderIdAndFlag(orderId, flag);
		for (OrdOdStateChg ordOdStateChg : ordOdStateChgs) {
			OrderStateChgVo orderStateChgVo = new OrderStateChgVo();
			BeanUtils.copyProperties(orderStateChgVo, ordOdStateChg);
			orderStateChgs.add(orderStateChgVo);
		}
		resp.setOrderStateChgs(orderStateChgs);
		resp.setResponseHeader(new ResponseHeader(true, ResultCodeConstants.SUCCESS_CODE, "查询成功"));
		return resp;
	}

	@Override
	public QueryOrderDetailsResponse queryOrderDetails4Portal(Long orderId, String flag) {
		QueryOrderDetailsResponse resp = new QueryOrderDetailsResponse();
		// 订单主信息
		OrdOrder ordOrder = iOrdOrderAtomSV.findByPrimaryKey(orderId);
		if (ordOrder == null) {
			throw new BusinessException(ExceptCodeConstants.Special.NO_RESULT, "订单不存在");
		}
		BeanUtils.copyProperties(resp, ordOrder);

		// 联系人
		OrdOdLogistics logistics = iOrdOdLogisticsAtomSV.findByOrderId(orderId);
		if (logistics != null) {
			ContactsVo contacts = new ContactsVo();
			BeanUtils.copyProperties(contacts, logistics);
			resp.setContacts(contacts);
		}
		// 评价信息
		OrdEvaluate ordEvaluate = ordEvaluateAtomSV.findByOrderId(orderId);
		if (ordEvaluate != null) {
			EvaluateVo evaluteVo = new EvaluateVo();
			BeanUtils.copyProperties(evaluteVo, ordEvaluate);
			evaluteVo.setServeSpeed(ordEvaluate.getServeSpeen());
			resp.setEvaluateVo(evaluteVo);
		}
		// 分配人员信息
		List<PersonInfoVo> personInfos = new ArrayList<PersonInfoVo>();
		// 根据订单id获取任务跟踪id
		OrdOdReceiveFollow ordOdReceiveFollow = ordOdReceiveFollowAtomSV.findByOrderId(orderId);
		if (ordOdReceiveFollow != null) {
			long followId = ordOdReceiveFollow.getReceiveFollowId();
			OrdOdPersonInfo personRequst = new OrdOdPersonInfo();
			personRequst.setReceiveFollowId(followId);
			List<OrdOdPersonInfo> ordOdPersonInfos = iOrdOdPersonInfoAtomSV.findPersonInfo(personRequst);
			for (OrdOdPersonInfo ordOdPersonInfo : ordOdPersonInfos) {
				PersonInfoVo personInfoVo = new PersonInfoVo();
				BeanUtils.copyProperties(personInfoVo, ordOdPersonInfo);
				personInfos.add(personInfoVo);
			}
			resp.setPersonInfos(personInfos);
		}
		/*
		 * //分配人员信息 List<PersonInfoVo> personInfos = new
		 * ArrayList<PersonInfoVo>(); OrdOdPersonInfo personRequst = new
		 * OrdOdPersonInfo(); personRequst.setReceiveFollowId(receiveFollowId);
		 * List<OrdOdPersonInfo> ordOdPersonInfos =
		 * iOrdOdPersonInfoAtomSV.findByOrderId(Long.valueOf(orderId));
		 * for(OrdOdPersonInfo ordOdPersonInfo:ordOdPersonInfos){ PersonInfoVo
		 * personInfoVo = new PersonInfoVo();
		 * BeanUtils.copyProperties(personInfoVo, ordOdPersonInfo);
		 * personInfos.add(personInfoVo); } resp.setPersonInfos(personInfos);
		 */

		// 产品明细信息
		OrdOdProdWithBLOBs ordOdProd = iOrdOdProdAtomSV.findByOrderId(orderId);
		if (ordOdProd != null) {
			ProdVo prod = new ProdVo();
			BeanUtils.copyProperties(prod, ordOdProd);
			if (!StringUtil.isBlank(prod.getUseCode())) {
				QuerySysPurposeDetailsRes purpose = iSysConfigAtomSV.querySysPurposeDetails(prod.getUseCode());
				prod.setUseCn(purpose.getPurposeCn());
				prod.setUseEn(purpose.getPurposeEn());
			}

			if (!StringUtil.isBlank(prod.getFieldCode())) {
				QuerySysDomainDetailsRes domain = iSysConfigAtomSV.querySysDomainDetails(prod.getFieldCode());
				prod.setFieldCn(domain.getDomainCn());
				prod.setFieldEn(domain.getDomainEn());
			}

			resp.setProd(prod);
		}

		// 语言对列表
		List<ProdExtendVo> prodExtends = new ArrayList<ProdExtendVo>();
		List<OrdOdProdExtend> ordOdProdExtends = iOrdOdProdExtendAtomSV.findByOrderId(orderId);
		for (OrdOdProdExtend ordOdProdExtend : ordOdProdExtends) {
			ProdExtendVo prodExtend = new ProdExtendVo();
			BeanUtils.copyProperties(prodExtend, ordOdProdExtend);
			prodExtends.add(prodExtend);
		}
		resp.setProdExtends(prodExtends);

		// 翻译级别列表
		List<ProdLevelVo> prodLevels = new ArrayList<ProdLevelVo>();
		List<OrdOdProdLevel> ordOdProdLevels = iOrdOdProdLevelAtomSV.findByOrderId(orderId);
		for (OrdOdProdLevel ordOdProdLevel : ordOdProdLevels) {
			ProdLevelVo prodLevel = new ProdLevelVo();
			BeanUtils.copyProperties(prodLevel, ordOdProdLevel);
			prodLevels.add(prodLevel);
		}
		resp.setProdLevels(prodLevels);

		// 文件列表
		List<ProdFileVo> prodFiles = new ArrayList<ProdFileVo>();
		if (ordOdProd != null) {
			List<OrdOdProdFile> ordOdProdFiles = iOrdOdProdFileAtomSV.findByProdDetalId(ordOdProd.getProdDetalId());
			for (OrdOdProdFile ordOdProdFile : ordOdProdFiles) {
				ProdFileVo prodFile = new ProdFileVo();
				BeanUtils.copyProperties(prodFile, ordOdProdFile);
				prodFiles.add(prodFile);
			}
		}
		resp.setProdFiles(prodFiles);

		// 订单费用信息
		OrdOdFeeTotal ordOdFeeTotal = iOrdOdFeeTotalAtomSV.findByOrderId(OrdersConstants.OrdOdFeeTotal.PAY_FLAG_IN,
				orderId);
		if (ordOdFeeTotal != null) {
			OrderFeeVo orderFee = new OrderFeeVo();
			BeanUtils.copyProperties(orderFee, ordOdFeeTotal);
			// 获取操作员工姓名
			if (!StringUtil.isBlank(orderFee.getUpdateOperId())) {
				SysUserQueryRequest req = new SysUserQueryRequest();
				req.setTenantId(OrdersConstants.TENANT_ID);
				req.setId(orderFee.getUpdateOperId());
				SysUserQueryResponse userInfo = iSysUserAtomSV.queryUserInfo(req);
				if (userInfo != null) {
					orderFee.setUpdateOperName(
							StringUtil.isBlank(userInfo.getName()) ? userInfo.getLoginName() : userInfo.getName());
				}
			}
			resp.setOrderFee(orderFee);
		}

		// 订单状态轨迹
		List<OrderStateChgVo> orderStateChgs = new ArrayList<OrderStateChgVo>();
		List<OrdOdStateChg> ordOdStateChgs = iOrdOdStateChgAtomSV.findByOrderIdAndFlag4Portal(orderId, flag);
		for (OrdOdStateChg ordOdStateChg : ordOdStateChgs) {
			OrderStateChgVo orderStateChgVo = new OrderStateChgVo();
			BeanUtils.copyProperties(orderStateChgVo, ordOdStateChg);
			orderStateChgs.add(orderStateChgVo);
		}
		resp.setOrderStateChgs(orderStateChgs);
		resp.setResponseHeader(new ResponseHeader(true, ResultCodeConstants.SUCCESS_CODE, "查询成功"));
		return resp;
	}

}
