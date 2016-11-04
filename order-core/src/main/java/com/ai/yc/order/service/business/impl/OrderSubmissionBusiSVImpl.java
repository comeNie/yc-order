package com.ai.yc.order.service.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.yc.order.api.ordersubmission.param.FileInfo;
import com.ai.yc.order.api.ordersubmission.param.LanguagePairInfo;
import com.ai.yc.order.api.ordersubmission.param.OrderSubmissionRequest;
import com.ai.yc.order.api.ordersubmission.param.OrderSubmissionResponse;
import com.ai.yc.order.api.ordersubmission.param.TranslateLevelInfo;
import com.ai.yc.order.dao.mapper.bo.OrdOdFeeTotal;
import com.ai.yc.order.dao.mapper.bo.OrdOdLogistics;
import com.ai.yc.order.dao.mapper.bo.OrdOdPersonInfo;
import com.ai.yc.order.dao.mapper.bo.OrdOdProd;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdExtend;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdFile;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdLevel;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdWithBLOBs;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.service.atom.interfaces.IOrdOdFeeTotalAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdLogisticsAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdPersonInfoAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdExtendAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdFileAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdLevelAtomSV;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;
import com.ai.yc.order.service.business.interfaces.IOrdOdFeeTotalBusiSV;
import com.ai.yc.order.service.business.interfaces.IOrderSubmissionBusiSV;
import com.ai.yc.order.util.SequenceUtil;

@Service
public class OrderSubmissionBusiSVImpl implements IOrderSubmissionBusiSV {
	@Autowired
	private IOrdOrderAtomSV ordOrderAtomSV;// 订单主表
	@Autowired
	private IOrdOdProdAtomSV ordOdProdAtomSV;// 产品明细表
	@Autowired
	private IOrdOdProdExtendAtomSV ordOdProdExtendAtomSV;// 产品语言表
	@Autowired
	private IOrdOdProdFileAtomSV ordOdProdFileAtomSV;// 产品文件表
	@Autowired
	private IOrdOdLogisticsAtomSV ordOdLogisticsAtomSV;// 联系人信息表
	@Autowired
	private IOrdOdProdLevelAtomSV ordOdProdLevelAtomSV;// 翻译级别表
	@Autowired
	private IOrdOdFeeTotalAtomSV ordOdFeeTotalAtomSV;// 费用信息表

	private static final String TRANSLATE_TYPE_0 = "0";
	private static final String TRANSLATE_TYPE_1 = "1";
	private static final String TRANSLATE_TYPE_2 = "2";

	@Override
	@Transactional
	public OrderSubmissionResponse saveOrderSubmission(OrderSubmissionRequest request) {
		OrderSubmissionResponse response = new OrderSubmissionResponse();

		// --------------订单基本信息---------------------
		Long orderId = SequenceUtil.createOrderId();
		OrdOrder ordOrder = new OrdOrder();
		BeanUtils.copyVO(ordOrder, request.getBaseInfo());
		ordOrder.setOrderId(orderId);
		if (TRANSLATE_TYPE_0.equals(request.getBaseInfo().getTranslateType())) {
			ordOrder.setState("11");// 待支付
			ordOrder.setStateChgTime(DateUtil.getSysDate());
			ordOrder.setDisplayFlag("11");
			ordOrder.setDisplayFlagChgTime(DateUtil.getSysDate());
			ordOrder.setUpdateFlag("N");
			ordOrder.setTimeZone("default");
		}
		if (TRANSLATE_TYPE_1.equals(request.getBaseInfo().getTranslateType())) {
			ordOrder.setState("13");// 待报价
			ordOrder.setStateChgTime(DateUtil.getSysDate());
			ordOrder.setDisplayFlag("11");
			ordOrder.setDisplayFlagChgTime(DateUtil.getSysDate());
			ordOrder.setUpdateFlag("N");
			ordOrder.setTimeZone("default");
		}
		if (TRANSLATE_TYPE_2.equals(request.getBaseInfo().getTranslateType())) {
			ordOrder.setState("13");// 待报价
			ordOrder.setStateChgTime(DateUtil.getSysDate());
			ordOrder.setDisplayFlag("11");
			ordOrder.setDisplayFlagChgTime(DateUtil.getSysDate());
			ordOrder.setUpdateFlag("N");
			ordOrder.setTimeZone("default");
		}
		//
		this.ordOrderAtomSV.insertSelective(ordOrder);

		// --------------产品信息---------------------
		Long prodDetailId = SequenceUtil.createProdDetailId();
		OrdOdProdWithBLOBs ordOdProdWithBLOBs = new OrdOdProdWithBLOBs();
		BeanUtils.copyVO(ordOdProdWithBLOBs, request.getProductInfo());
		ordOdProdWithBLOBs.setProdDetalId(prodDetailId);
		ordOdProdWithBLOBs.setTranslateType(ordOrder.getTranslateType());
		ordOdProdWithBLOBs.setTranslateName(ordOrder.getTranslateName());
		ordOdProdWithBLOBs.setOrderId(orderId);
		if (TRANSLATE_TYPE_0.equals(request.getBaseInfo().getTranslateType())) {
			ordOdProdWithBLOBs.setProdDetalState("0");// 未处理
			// 翻译字数
			ordOdProdWithBLOBs.setTranslateSum(request.getProductInfo().getTranslateSum().toString());
			// 用途ID
			ordOdProdWithBLOBs.setUseCode(request.getProductInfo().getUseCode());// productInfo.setUseCode("1111");
			// 领域ID
			ordOdProdWithBLOBs.setFieldCode(request.getProductInfo().getFieldCode()); // productInfo.setFieldCode("2222");
			// 是否排版
			ordOdProdWithBLOBs.setIsSetType(request.getProductInfo().getIsSetType());// productInfo.setIsSetType("0");
			// 是否加急
			ordOdProdWithBLOBs.setIsUrgent(request.getProductInfo().getIsUrgent());// productInfo.setIsUrgent("0");
		}
		if (TRANSLATE_TYPE_1.equals(request.getBaseInfo().getTranslateType())) {
			ordOdProdWithBLOBs.setProdDetalState("0");// 未处理
			// 用途ID
			ordOdProdWithBLOBs.setUseCode(request.getProductInfo().getUseCode());// productInfo.setUseCode("1111");
			// 领域ID
			ordOdProdWithBLOBs.setFieldCode(request.getProductInfo().getFieldCode()); // productInfo.setFieldCode("2222");
			// 是否排版
			ordOdProdWithBLOBs.setIsSetType(request.getProductInfo().getIsSetType());// productInfo.setIsSetType("0");
			// 是否加急
			ordOdProdWithBLOBs.setIsUrgent(request.getProductInfo().getIsUrgent());// productInfo.setIsUrgent("0");

		}
		if (TRANSLATE_TYPE_2.equals(request.getBaseInfo().getTranslateType())) {
			ordOdProdWithBLOBs.setProdDetalState("0");// 未处理
			// 会场数量
			ordOdProdWithBLOBs.setMeetingSum(request.getProductInfo().getMeetingSum());// productInfo.setMeetingSum(10l);
			// 译员性别
			ordOdProdWithBLOBs.setInterperGen(request.getProductInfo().getInterperGen());// productInfo.setInterperGen("0");
			// 会议地点
			ordOdProdWithBLOBs.setMeetingAddress(request.getProductInfo().getMeetingAddress());// productInfo.setMeetingAddress("北京市石景山区");
			// 译员数量
			ordOdProdWithBLOBs.setInterperSum(request.getProductInfo().getInterperSum());// productInfo.setInterperSum(10l);
		}
		// 语言对信息
		List<LanguagePairInfo> languafePairInfoList = request.getProductInfo().getLanguagePairInfoList();
		//
		if (!CollectionUtil.isEmpty(languafePairInfoList)) {
			//
			OrdOdProdExtend ordOdProdExtend = null;
			for (LanguagePairInfo languagePairInfo : languafePairInfoList) {
				Long prodDetalExtendId = SequenceUtil.createProdDetailExtendId();
				ordOdProdExtend = new OrdOdProdExtend();
				BeanUtils.copyVO(ordOdProdExtend, languagePairInfo);
				ordOdProdExtend.setProdDetalExtendId(prodDetalExtendId);// 主键
				ordOdProdExtend.setProdDetalId(prodDetailId);// 产品信息表id
				ordOdProdExtend.setOrderId(orderId);// 当前订单id
				ordOdProdExtend.setLangungePair(languagePairInfo.getLanguagePairId());
				ordOdProdExtend.setLangungePairName(languagePairInfo.getLanguagePairName());
				// 循环添加语言对信息
				this.ordOdProdExtendAtomSV.insertSelective(ordOdProdExtend);
			}

		}
		// 翻译级别信息
		List<TranslateLevelInfo> translateLevelInfoList = request.getProductInfo().getTranslateLevelInfoList();
		//
		if (!CollectionUtil.isEmpty(translateLevelInfoList)) {
			//
			OrdOdProdLevel ordOdProdLevel = null;
			//
			for (TranslateLevelInfo translateLevelInfo : translateLevelInfoList) {
				Long prodDetalLevelId = SequenceUtil.createProdDetailLevelId();
				ordOdProdLevel = new OrdOdProdLevel();
				BeanUtils.copyVO(ordOdProdLevel, translateLevelInfo);
				ordOdProdLevel.setProdDetalExtendId(prodDetalLevelId);// 主键
				ordOdProdLevel.setProdDetalId(prodDetailId);// 产品信息表id
				ordOdProdLevel.setOrderId(orderId);// 当前订单id
				// 循环添加翻译级别信息
				this.ordOdProdLevelAtomSV.insertSelective(ordOdProdLevel);
			}

		}

		// 产品文件信息
		List<FileInfo> fileInfoList = request.getProductInfo().getFileInfoList();
		//
		if (!CollectionUtil.isEmpty(fileInfoList)) {
			//
			OrdOdProdFile ordOdProdFile = null;
			//
			for (FileInfo fileInfo : fileInfoList) {
				Long prodFileId = SequenceUtil.createProdDetailFileId();
				ordOdProdFile = new OrdOdProdFile();
				BeanUtils.copyVO(ordOdProdFile, fileInfo);
				ordOdProdFile.setProdFileId(prodFileId.toString());
				ordOdProdFile.setProdDetalId(prodDetailId);
				// 循环添加翻译级别信息
				this.ordOdProdFileAtomSV.insertSelective(ordOdProdFile);
			}

		}
		// 添加产品信息
		this.ordOdProdAtomSV.insertSelective(ordOdProdWithBLOBs);

		// --------------费用信息---------------------
		OrdOdFeeTotal ordOdFeeTotal = new OrdOdFeeTotal();
		BeanUtils.copyVO(ordOdFeeTotal, request.getFeeInfo());
		ordOdFeeTotal.setOrderId(orderId);
		ordOdFeeTotal.setPayFlag("in");
		// 总优惠金额
		ordOdFeeTotal.setDiscountFee(0l);
		// 总减免费用
		ordOdFeeTotal.setOperDiscountFee(0l);
		// 总应收费用
		ordOdFeeTotal.setAdjustFee(0l);
		// 总实收费用
		ordOdFeeTotal.setPaidFee(0l);
		// 总待收费用
		ordOdFeeTotal.setPayFee(0l);
		// 下单费用列表 修改时间为下单时间
		ordOdFeeTotal.setUpdateTime(DateUtil.getSysDate());
		// 添加费用信息
		this.ordOdFeeTotalAtomSV.insertSelective(ordOdFeeTotal);

		// --------------联系人信息---------------------
		OrdOdLogistics ordOdLogistics = new OrdOdLogistics();
		Long contactId = SequenceUtil.createContactId();
		if (null != request.getContactInfo()) {
			BeanUtils.copyVO(ordOdLogistics, request.getContactInfo());
			ordOdLogistics.setContactId(contactId);
			ordOdLogistics.setOrderId(orderId);
			// 添加联系人信息
			this.ordOdLogisticsAtomSV.insertSelective(ordOdLogistics);
		}
		// --------------产品信息---------------------
		return response;
	}
	@Override
	@Transactional
	public OrderSubmissionResponse saveOrderSubmissionSupper(OrderSubmissionRequest request) {
		OrderSubmissionResponse response = new OrderSubmissionResponse();

		// --------------订单基本信息---------------------
		Long orderId = SequenceUtil.createOrderId();
		this.orderBaseInfoSubmit(request);
		this.orderProductInfoSubmit(request, orderId);
		this.orderFeeInfoSubmit(request, orderId);
		this.orderContactInfoSubmit(request, orderId);
		
		// --------------产品信息---------------------
		return response;
	}

	/**
	 * 提交订-单基本信息
	 */
	public void orderBaseInfoSubmit(OrderSubmissionRequest request) {
		// --------------订单基本信息---------------------
		Long orderId = SequenceUtil.createOrderId();
		OrdOrder ordOrder = new OrdOrder();
		BeanUtils.copyVO(ordOrder, request.getBaseInfo());
		ordOrder.setOrderId(orderId);
		if (TRANSLATE_TYPE_0.equals(request.getBaseInfo().getTranslateType())) {
			ordOrder.setState("11");// 待支付
			ordOrder.setStateChgTime(DateUtil.getSysDate());
			ordOrder.setDisplayFlag("11");
			ordOrder.setDisplayFlagChgTime(DateUtil.getSysDate());
			ordOrder.setUpdateFlag("N");
			ordOrder.setTimeZone("default");
		}
		if (TRANSLATE_TYPE_1.equals(request.getBaseInfo().getTranslateType())) {
			ordOrder.setState("13");// 待报价
			ordOrder.setStateChgTime(DateUtil.getSysDate());
			ordOrder.setDisplayFlag("11");
			ordOrder.setDisplayFlagChgTime(DateUtil.getSysDate());
			ordOrder.setUpdateFlag("N");
			ordOrder.setTimeZone("default");
		}
		if (TRANSLATE_TYPE_2.equals(request.getBaseInfo().getTranslateType())) {
			ordOrder.setState("13");// 待报价
			ordOrder.setStateChgTime(DateUtil.getSysDate());
			ordOrder.setDisplayFlag("11");
			ordOrder.setDisplayFlagChgTime(DateUtil.getSysDate());
			ordOrder.setUpdateFlag("N");
			ordOrder.setTimeZone("default");
		}
		//
		this.ordOrderAtomSV.insertSelective(ordOrder);
	}

	/**
	 * 提交订单-产品信息
	 */
	public void orderProductInfoSubmit(OrderSubmissionRequest request, Long orderId) {
		// --------------产品信息---------------------
		Long prodDetailId = SequenceUtil.createProdDetailId();
		OrdOdProdWithBLOBs ordOdProdWithBLOBs = new OrdOdProdWithBLOBs();
		BeanUtils.copyVO(ordOdProdWithBLOBs, request.getProductInfo());
		ordOdProdWithBLOBs.setProdDetalId(prodDetailId);
		ordOdProdWithBLOBs.setTranslateType(request.getBaseInfo().getTranslateType());
		ordOdProdWithBLOBs.setTranslateName(request.getBaseInfo().getTranslateName());
		ordOdProdWithBLOBs.setOrderId(orderId);
		if (TRANSLATE_TYPE_0.equals(request.getBaseInfo().getTranslateType())) {
			ordOdProdWithBLOBs.setProdDetalState("0");// 未处理
			// 翻译字数
			ordOdProdWithBLOBs.setTranslateSum(request.getProductInfo().getTranslateSum().toString());
			// 用途ID
			ordOdProdWithBLOBs.setUseCode(request.getProductInfo().getUseCode());// productInfo.setUseCode("1111");
			// 领域ID
			ordOdProdWithBLOBs.setFieldCode(request.getProductInfo().getFieldCode()); // productInfo.setFieldCode("2222");
			// 是否排版
			ordOdProdWithBLOBs.setIsSetType(request.getProductInfo().getIsSetType());// productInfo.setIsSetType("0");
			// 是否加急
			ordOdProdWithBLOBs.setIsUrgent(request.getProductInfo().getIsUrgent());// productInfo.setIsUrgent("0");
		}
		if (TRANSLATE_TYPE_1.equals(request.getBaseInfo().getTranslateType())) {
			ordOdProdWithBLOBs.setProdDetalState("0");// 未处理
			// 用途ID
			ordOdProdWithBLOBs.setUseCode(request.getProductInfo().getUseCode());// productInfo.setUseCode("1111");
			// 领域ID
			ordOdProdWithBLOBs.setFieldCode(request.getProductInfo().getFieldCode()); // productInfo.setFieldCode("2222");
			// 是否排版
			ordOdProdWithBLOBs.setIsSetType(request.getProductInfo().getIsSetType());// productInfo.setIsSetType("0");
			// 是否加急
			ordOdProdWithBLOBs.setIsUrgent(request.getProductInfo().getIsUrgent());// productInfo.setIsUrgent("0");

		}
		if (TRANSLATE_TYPE_2.equals(request.getBaseInfo().getTranslateType())) {
			ordOdProdWithBLOBs.setProdDetalState("0");// 未处理
			// 会场数量
			ordOdProdWithBLOBs.setMeetingSum(request.getProductInfo().getMeetingSum());// productInfo.setMeetingSum(10l);
			// 译员性别
			ordOdProdWithBLOBs.setInterperGen(request.getProductInfo().getInterperGen());// productInfo.setInterperGen("0");
			// 会议地点
			ordOdProdWithBLOBs.setMeetingAddress(request.getProductInfo().getMeetingAddress());// productInfo.setMeetingAddress("北京市石景山区");
			// 译员数量
			ordOdProdWithBLOBs.setInterperSum(request.getProductInfo().getInterperSum());// productInfo.setInterperSum(10l);
		}
		// 语言对信息
		List<LanguagePairInfo> languafePairInfoList = request.getProductInfo().getLanguagePairInfoList();
		//
		if (!CollectionUtil.isEmpty(languafePairInfoList)) {
			//
			OrdOdProdExtend ordOdProdExtend = null;
			for (LanguagePairInfo languagePairInfo : languafePairInfoList) {
				Long prodDetalExtendId = SequenceUtil.createProdDetailExtendId();
				ordOdProdExtend = new OrdOdProdExtend();
				BeanUtils.copyVO(ordOdProdExtend, languagePairInfo);
				ordOdProdExtend.setProdDetalExtendId(prodDetalExtendId);// 主键
				ordOdProdExtend.setProdDetalId(prodDetailId);// 产品信息表id
				ordOdProdExtend.setOrderId(orderId);// 当前订单id
				ordOdProdExtend.setLangungePair(languagePairInfo.getLanguagePairId());
				ordOdProdExtend.setLangungePairName(languagePairInfo.getLanguagePairName());
				// 循环添加语言对信息
				this.ordOdProdExtendAtomSV.insertSelective(ordOdProdExtend);
			}

		}
		// 翻译级别信息
		List<TranslateLevelInfo> translateLevelInfoList = request.getProductInfo().getTranslateLevelInfoList();
		//
		if (!CollectionUtil.isEmpty(translateLevelInfoList)) {
			//
			OrdOdProdLevel ordOdProdLevel = null;
			//
			for (TranslateLevelInfo translateLevelInfo : translateLevelInfoList) {
				Long prodDetalLevelId = SequenceUtil.createProdDetailLevelId();
				ordOdProdLevel = new OrdOdProdLevel();
				BeanUtils.copyVO(ordOdProdLevel, translateLevelInfo);
				ordOdProdLevel.setProdDetalExtendId(prodDetalLevelId);// 主键
				ordOdProdLevel.setProdDetalId(prodDetailId);// 产品信息表id
				ordOdProdLevel.setOrderId(orderId);// 当前订单id
				// 循环添加翻译级别信息
				this.ordOdProdLevelAtomSV.insertSelective(ordOdProdLevel);
			}

		}

		// 产品文件信息
		List<FileInfo> fileInfoList = request.getProductInfo().getFileInfoList();
		//
		if (!CollectionUtil.isEmpty(fileInfoList)) {
			//
			OrdOdProdFile ordOdProdFile = null;
			//
			for (FileInfo fileInfo : fileInfoList) {
				Long prodFileId = SequenceUtil.createProdDetailFileId();
				ordOdProdFile = new OrdOdProdFile();
				BeanUtils.copyVO(ordOdProdFile, fileInfo);
				ordOdProdFile.setProdFileId(prodFileId.toString());
				ordOdProdFile.setProdDetalId(prodDetailId);
				// 循环添加翻译级别信息
				this.ordOdProdFileAtomSV.insertSelective(ordOdProdFile);
			}

		}
		// 添加产品信息
		this.ordOdProdAtomSV.insertSelective(ordOdProdWithBLOBs);
	}

	/**
	 * 订单提交-费用信息
	 */
	public void orderFeeInfoSubmit(OrderSubmissionRequest request, Long orderId) {
		// --------------费用信息---------------------
		OrdOdFeeTotal ordOdFeeTotal = new OrdOdFeeTotal();
		BeanUtils.copyVO(ordOdFeeTotal, request.getFeeInfo());
		ordOdFeeTotal.setOrderId(orderId);
		ordOdFeeTotal.setPayFlag("in");
		// 总优惠金额
		ordOdFeeTotal.setDiscountFee(0l);
		// 总减免费用
		ordOdFeeTotal.setOperDiscountFee(0l);
		// 总应收费用
		ordOdFeeTotal.setAdjustFee(0l);
		// 总实收费用
		ordOdFeeTotal.setPaidFee(0l);
		// 总待收费用
		ordOdFeeTotal.setPayFee(0l);
		// 下单费用列表 修改时间为下单时间
		ordOdFeeTotal.setUpdateTime(DateUtil.getSysDate());
		// 添加费用信息
		this.ordOdFeeTotalAtomSV.insertSelective(ordOdFeeTotal);
	}

	/**
	 * 订单提交-联系人信息
	 */
	public void orderContactInfoSubmit(OrderSubmissionRequest request, Long orderId) {
		// --------------联系人信息---------------------
		OrdOdLogistics ordOdLogistics = new OrdOdLogistics();
		Long contactId = SequenceUtil.createContactId();
		if (null != request.getContactInfo()) {
			BeanUtils.copyVO(ordOdLogistics, request.getContactInfo());
			ordOdLogistics.setContactId(contactId);
			ordOdLogistics.setOrderId(orderId);
			// 添加联系人信息
			this.ordOdLogisticsAtomSV.insertSelective(ordOdLogistics);
		}
	}

	@Transactional
	public void saveContact(OrdOdLogistics ordOdLogistics) {
		this.ordOdLogisticsAtomSV.insertSelective(ordOdLogistics);
	}

}
