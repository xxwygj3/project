package com.sbtest.projectjdbc.entity;

import com.sbtest.projectjdbc.common.BaseEntity;

public class Customer extends BaseEntity {
    /** 客户ID **/
    private Integer cusId;
    /** 客户编号 **/
    private String cusCode;
    /** 开通二级交易编号 **/
    private String accCode;
    /** 网关流水号 **/
    private String bsspTrdNum;
    /** 三方开户账号 **/
    private String tpAccCode;
    /** 资金管理平台开户日期 **/
    private String tpAccDate;
    /** 存管电子银行账号 **/
    private String bankAccCode;
    /** 客户类型 0 个人、1 商户 **/
    private Integer cusType;
    /** 所属公司 **/
    private String company;
    /** 组织机构号 **/
    private String orgCode;
    /** 营业执照编号 **/
    private String bizLicenseNum;
    /** 客户业务类型 0 投资人&借款人、1 投资人、2 借款人 **/
    private Integer cusBiz;
    /** 客户等级 与客户等级表关联 **/
    private String cusGrade;
    /** 证件类型 **/
    private Integer idType;
    /** 证件号码 **/
    private String idNum;
    /** 客户姓名 **/
    private String realName;
    /** 显示手机150****1212 **/
    private String cusMobile;
    /** 电子邮箱 **/
    private String cusEmail;
    /** 地址 **/
    private String cusAddr;
    /** 注册时间 **/
    private String regDate;
    /** 用户注册具体时间 **/
    private String regTime;
    /** 0 预开户、1有效、9 开户失败 **/
    private String status;
    /** 备注 **/
    private String remark;
    /** 推荐码 **/
    private String rcmCode;
    /** 推荐人客户编号 **/
    private String rcmCusCode;
    /** 推荐人手机号码 **/
    private String rcmMobile;
    /** 开户操作方 **/
    private Integer operBy;
    /** 渠道来源**/
    private Integer srcNo;
    /** 尊享标识 1、尊享用户**/
    private Integer isVip;
    /** 用户注册渠道码 **/
    private String chlComment;
    /** 设备号 **/
    private String deviceNum;

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getCusCode() {
        return cusCode;
    }

    public void setCusCode(String cusCode) {
        this.cusCode = cusCode;
    }

    public String getAccCode() {
        return accCode;
    }

    public void setAccCode(String accCode) {
        this.accCode = accCode;
    }

    public String getBsspTrdNum() {
        return bsspTrdNum;
    }

    public void setBsspTrdNum(String bsspTrdNum) {
        this.bsspTrdNum = bsspTrdNum;
    }

    public String getTpAccCode() {
        return tpAccCode;
    }

    public void setTpAccCode(String tpAccCode) {
        this.tpAccCode = tpAccCode;
    }

    public String getTpAccDate() {
        return tpAccDate;
    }

    public void setTpAccDate(String tpAccDate) {
        this.tpAccDate = tpAccDate;
    }

    public String getBankAccCode() {
        return bankAccCode;
    }

    public void setBankAccCode(String bankAccCode) {
        this.bankAccCode = bankAccCode;
    }

    public Integer getCusType() {
        return cusType;
    }

    public void setCusType(Integer cusType) {
        this.cusType = cusType;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getBizLicenseNum() {
        return bizLicenseNum;
    }

    public void setBizLicenseNum(String bizLicenseNum) {
        this.bizLicenseNum = bizLicenseNum;
    }

    public Integer getCusBiz() {
        return cusBiz;
    }

    public void setCusBiz(Integer cusBiz) {
        this.cusBiz = cusBiz;
    }

    public String getCusGrade() {
        return cusGrade;
    }

    public void setCusGrade(String cusGrade) {
        this.cusGrade = cusGrade;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCusMobile() {
        return cusMobile;
    }

    public void setCusMobile(String cusMobile) {
        this.cusMobile = cusMobile;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public String getCusAddr() {
        return cusAddr;
    }

    public void setCusAddr(String cusAddr) {
        this.cusAddr = cusAddr;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRcmCode() {
        return rcmCode;
    }

    public void setRcmCode(String rcmCode) {
        this.rcmCode = rcmCode;
    }

    public String getRcmCusCode() {
        return rcmCusCode;
    }

    public void setRcmCusCode(String rcmCusCode) {
        this.rcmCusCode = rcmCusCode;
    }

    public String getRcmMobile() {
        return rcmMobile;
    }

    public void setRcmMobile(String rcmMobile) {
        this.rcmMobile = rcmMobile;
    }

    public Integer getOperBy() {
        return operBy;
    }

    public void setOperBy(Integer operBy) {
        this.operBy = operBy;
    }

    public Integer getSrcNo() {
        return srcNo;
    }

    public void setSrcNo(Integer srcNo) {
        this.srcNo = srcNo;
    }

    public Integer getIsVip() {
        return isVip;
    }

    public void setIsVip(Integer isVip) {
        this.isVip = isVip;
    }

    public String getChlComment() {
        return chlComment;
    }

    public void setChlComment(String chlComment) {
        this.chlComment = chlComment;
    }

    public String getDeviceNum() {
        return deviceNum;
    }

    public void setDeviceNum(String deviceNum) {
        this.deviceNum = deviceNum;
    }
}
