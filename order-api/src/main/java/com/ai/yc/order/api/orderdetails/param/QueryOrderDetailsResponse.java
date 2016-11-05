package com.ai.yc.order.api.orderdetails.param;

import java.sql.Timestamp;
import java.util.List;

import com.ai.opt.base.vo.BaseResponse;

/**
 * @Description: 订单详情返回参数
 * @author hougang@asiainfo.com
 * @date 2016年11月4日 下午6:11:23 
 * @version V1.0
 */
public class QueryOrderDetailsResponse extends BaseResponse{

	private static final long serialVersionUID = 4023488269519438541L;
	
	/**
	 * 订单ID
	 */
	private String orderId;
	
    /**
     * 0:国内业务 1：国际业务
     */
    private String flag;

    /**
     * 订单来源
     * 0：PC-中文站
     *1：PC-英文站
     *2：百度
     *3：金山
     *4：找翻译
     *5：WAP-中文
     *6：WAP-英语
     *7：微信助手
     */
    private String chlId;

    /**
     * 订单类型
     * 1：个人订单
     * 2：企业订单
     */
    private String orderType;

    /**
     * 业务类型
     * 1：正常单
     * 2：退费单
     */
    private String busiType;

    /**
     * 订单级别
     */
    private String orderLevel;

    /**
     * 翻译类型
     */
    private String translateType;

    /**
     * 翻译主题
     */
    private String translateName;

    /**
     * 报价标识 0：系统自动报 1：人工报价
     */
    private String subFlag;

    /**
     * 用户类型   
     * 10：个人
     * 11：企业
     * 12：代理人
     */
    private String userType;

    /**
     * 用户ID
     */
    private String userId;
    
    /**
     * 用户名
     */
    private String username;
    
    /**
     * 用户昵称
     */
    private String usernick;

    /**
     * 企业ID
     */
    private String corporaId;

    /**
     * 账户ID
     */
    private Long accountId;


    /**
     * 下单时间
     */
    private Timestamp orderTime;
 

    /**
    * 订单状态(后厂)
    * 10：提交 
	*11：待支付
	*12：已支付
	*13：待报价
	*20：待领取
	*21：已领取
	*211：已分配
	*23：翻译中
	*24：已提交
	*25：修改中
	*40：待审核
	*41：已审核
	*42：审核失败（审核不通过）
	*50：待确认
	*51：已确认
	*52：待评价
	*53：已评价
	*90：完成
	*91：关闭（取消）
	*92：已退款
     */
    private String state;

    private Timestamp stateChgTime;

    /**
     * 客户端显示状态
     * 11：待支付
     *13：待报价
     *23：翻译中
     *50：待确认
     *52：待评价
     *90：完成
     *91：关闭（取消）
     *92：已退款
     */
    private String displayFlag;

    private Timestamp displayFlagChgTime;

    /**
     * 译员类型   0：普通译员 1：LSP译员
     */
    private String interperType;

    /**
     * LSP编号
     */
    private Long lspId;

    /**
     * 领取人ID(译员)
     */
    private String interperId;

    /**
     * 领取时间
     */
    private Timestamp lockTime;

    /**
     * 操作工号
     */
    private String operId;


    /**
     * 备注
     */
    private String remark;

    /**
     * 完成时间
     */
    private Timestamp finishTime;

    /**
     * 订单简要信息
     */
    private String orderDesc;

    /**
     * 原因描述（撤改单）
     */
    private String reasonDesc;

    /**
     * 联系人信息
     */
    private ContactsVo contacts;
    
    /**
     * 分配人员信息
     */
    private List<PersonInfoVo> personInfos;
    
    /**
     * 产品明细信息
     */
    private ProdVo prod;
    
    /**
     * 语言对列表
     */
    private List<ProdExtendVo> prodExtends;
    
    /**
     * 翻译级别列表
     */
    private List<ProdLevelVo> prodLevels;
    
    /**
     * 文件列表
     */
    private List<ProdFileVo> prodFiles;
    
    /**
     * 订单费用信息
     */
    private OrderFeeVo orderFee;
    
    /**
     * 订单状态轨迹
     */
    private List<OrderStateChgVo> orderStateChgs;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getChlId() {
		return chlId;
	}

	public void setChlId(String chlId) {
		this.chlId = chlId;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	public String getOrderLevel() {
		return orderLevel;
	}

	public void setOrderLevel(String orderLevel) {
		this.orderLevel = orderLevel;
	}

	public String getTranslateType() {
		return translateType;
	}

	public void setTranslateType(String translateType) {
		this.translateType = translateType;
	}

	public String getTranslateName() {
		return translateName;
	}

	public void setTranslateName(String translateName) {
		this.translateName = translateName;
	}

	public String getSubFlag() {
		return subFlag;
	}

	public void setSubFlag(String subFlag) {
		this.subFlag = subFlag;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsernick() {
		return usernick;
	}

	public void setUsernick(String usernick) {
		this.usernick = usernick;
	}

	public String getCorporaId() {
		return corporaId;
	}

	public void setCorporaId(String corporaId) {
		this.corporaId = corporaId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Timestamp getStateChgTime() {
		return stateChgTime;
	}

	public void setStateChgTime(Timestamp stateChgTime) {
		this.stateChgTime = stateChgTime;
	}

	public String getDisplayFlag() {
		return displayFlag;
	}

	public void setDisplayFlag(String displayFlag) {
		this.displayFlag = displayFlag;
	}

	public Timestamp getDisplayFlagChgTime() {
		return displayFlagChgTime;
	}

	public void setDisplayFlagChgTime(Timestamp displayFlagChgTime) {
		this.displayFlagChgTime = displayFlagChgTime;
	}

	public String getInterperType() {
		return interperType;
	}

	public void setInterperType(String interperType) {
		this.interperType = interperType;
	}

	public Long getLspId() {
		return lspId;
	}

	public void setLspId(Long lspId) {
		this.lspId = lspId;
	}

	public String getInterperId() {
		return interperId;
	}

	public void setInterperId(String interperId) {
		this.interperId = interperId;
	}

	public Timestamp getLockTime() {
		return lockTime;
	}

	public void setLockTime(Timestamp lockTime) {
		this.lockTime = lockTime;
	}

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Timestamp finishTime) {
		this.finishTime = finishTime;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public String getReasonDesc() {
		return reasonDesc;
	}

	public void setReasonDesc(String reasonDesc) {
		this.reasonDesc = reasonDesc;
	}

    

	public ContactsVo getContacts() {
		return contacts;
	}

	public void setContacts(ContactsVo contacts) {
		this.contacts = contacts;
	}

	public List<PersonInfoVo> getPersonInfos() {
		return personInfos;
	}

	public void setPersonInfos(List<PersonInfoVo> personInfos) {
		this.personInfos = personInfos;
	}

	public ProdVo getProd() {
		return prod;
	}

	public void setProd(ProdVo prod) {
		this.prod = prod;
	}

	public List<ProdExtendVo> getProdExtends() {
		return prodExtends;
	}

	public void setProdExtends(List<ProdExtendVo> prodExtends) {
		this.prodExtends = prodExtends;
	}

	public List<ProdLevelVo> getProdLevels() {
		return prodLevels;
	}

	public void setProdLevels(List<ProdLevelVo> prodLevels) {
		this.prodLevels = prodLevels;
	}

	public List<ProdFileVo> getProdFiles() {
		return prodFiles;
	}

	public void setProdFiles(List<ProdFileVo> prodFiles) {
		this.prodFiles = prodFiles;
	}

	public OrderFeeVo getOrderFee() {
		return orderFee;
	}

	public void setOrderFee(OrderFeeVo orderFee) {
		this.orderFee = orderFee;
	}

	public List<OrderStateChgVo> getOrderStateChgs() {
		return orderStateChgs;
	}

	public void setOrderStateChgs(List<OrderStateChgVo> orderStateChgs) {
		this.orderStateChgs = orderStateChgs;
	}
    
    
}
