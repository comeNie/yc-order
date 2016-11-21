package com.ai.yc.order.search.bo;

import java.util.Date;
import java.util.List;

public class OrderInfo {
	private String orderid;
	private String flag;
	private String timezone;
	private String usertype;
	private String userid;
	private String username;
	private String chlid;
	private String ordertype;
	private String busitype;
	private String orderlevel;
	private String translatetype;
	private String translatename;
	private String corpoarid;
	private String state;
	private String displayflag;
	private String interpertype;
	private String lspid;
	private String lspname;
	private String interperid;
	private String updateflag;
	private Date ordertime;
	private Date statechgtime;
	private String paystyle;
	private Date paytime;
	private Date locktime;
	private Date finishtime;
	private Date starttime;
	private Date endtime;
	private String updateoperid;
	private String field;
	private String usecode;
	private String subflag;
	private long proddetailid;
	private String keywords;
	private long totalfee;
	private String currencyunit;
	private String operid;
	private String takeday;
	private String taketime;
	private Date endchgtime;
	private String interpername;
	/**
	 * 报价人
	 */
	private String updatename;
	/**
	 * 费用变更时间
	 */
	private Date updatetime;

	/**
	 * 語言對
	 */
	private List<OrdProdExtend> ordextendes;
	/**
	 * 翻譯級別
	 */
	private List<OrdProdLevel> ordprodleveles;
	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getChlid() {
		return chlid;
	}

	public void setChlid(String chlid) {
		this.chlid = chlid;
	}

	public String getOrdertype() {
		return ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public String getBusitype() {
		return busitype;
	}

	public void setBusitype(String busitype) {
		this.busitype = busitype;
	}

	public String getOrderlevel() {
		return orderlevel;
	}

	public void setOrderlevel(String orderlevel) {
		this.orderlevel = orderlevel;
	}

	public String getTranslatetype() {
		return translatetype;
	}

	public void setTranslatetype(String translatetype) {
		this.translatetype = translatetype;
	}

	public String getTranslatename() {
		return translatename;
	}

	public void setTranslatename(String translatename) {
		this.translatename = translatename;
	}

	public String getCorpoarid() {
		return corpoarid;
	}

	public void setCorpoarid(String corpoarid) {
		this.corpoarid = corpoarid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDisplayflag() {
		return displayflag;
	}

	public void setDisplayflag(String displayflag) {
		this.displayflag = displayflag;
	}

	public String getInterpertype() {
		return interpertype;
	}

	public void setInterpertype(String interpertype) {
		this.interpertype = interpertype;
	}

	public String getLspid() {
		return lspid;
	}

	public void setLspid(String lspid) {
		this.lspid = lspid;
	}

	public String getLspname() {
		return lspname;
	}

	public void setLspname(String lspname) {
		this.lspname = lspname;
	}

	public String getInterperid() {
		return interperid;
	}

	public void setInterperid(String interperid) {
		this.interperid = interperid;
	}

	public String getUpdateflag() {
		return updateflag;
	}

	public void setUpdateflag(String updateflag) {
		this.updateflag = updateflag;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public Date getStatechgtime() {
		return statechgtime;
	}

	public void setStatechgtime(Date statechgtime) {
		this.statechgtime = statechgtime;
	}

	public String getPaystyle() {
		return paystyle;
	}

	public void setPaystyle(String paystyle) {
		this.paystyle = paystyle;
	}

	public Date getPaytime() {
		return paytime;
	}

	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}

	public Date getLocktime() {
		return locktime;
	}

	public void setLocktime(Date locktime) {
		this.locktime = locktime;
	}

	public Date getFinishtime() {
		return finishtime;
	}

	public void setFinishtime(Date finishtime) {
		this.finishtime = finishtime;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getUpdateoperid() {
		return updateoperid;
	}

	public void setUpdateoperid(String updateoperid) {
		this.updateoperid = updateoperid;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getUsecode() {
		return usecode;
	}

	public void setUsecode(String usecode) {
		this.usecode = usecode;
	}

	public long getProddetailid() {
		return proddetailid;
	}

	public void setProddetailid(long proddetailid) {
		this.proddetailid = proddetailid;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public List<OrdProdExtend> getOrdextendes() {
		return ordextendes;
	}

	public void setOrdextendes(List<OrdProdExtend> ordextendes) {
		this.ordextendes = ordextendes;
	}

	public String getSubflag() {
		return subflag;
	}

	public void setSubflag(String subflag) {
		this.subflag = subflag;
	}

	public long getTotalfee() {
		return totalfee;
	}

	public void setTotalfee(long totalfee) {
		this.totalfee = totalfee;
	}

	public String getCurrencyunit() {
		return currencyunit;
	}

	public void setCurrencyunit(String currencyunit) {
		this.currencyunit = currencyunit;
	}

	public String getOperid() {
		return operid;
	}

	public void setOperid(String operid) {
		this.operid = operid;
	}

	public String getUpdatename() {
		return updatename;
	}

	public void setUpdatename(String updatename) {
		this.updatename = updatename;
	}

	public List<OrdProdLevel> getOrdprodleveles() {
		return ordprodleveles;
	}

	public void setOrdprodleveles(List<OrdProdLevel> ordprodleveles) {
		this.ordprodleveles = ordprodleveles;
	}

	public String getTakeday() {
		return takeday;
	}

	public void setTakeday(String takeday) {
		this.takeday = takeday;
	}

	public String getTaketime() {
		return taketime;
	}

	public void setTaketime(String taketime) {
		this.taketime = taketime;
	}

	public Date getEndchgtime() {
		return endchgtime;
	}

	public void setEndchgtime(Date endchgtime) {
		this.endchgtime = endchgtime;
	}

	public String getInterpername() {
		return interpername;
	}

	public void setInterpername(String interpername) {
		this.interpername = interpername;
	}

}
