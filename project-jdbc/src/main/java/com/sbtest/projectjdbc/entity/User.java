package com.sbtest.projectjdbc.entity;

import com.sbtest.projectjdbc.common.BaseEntity;

public class User extends BaseEntity{
    /** 操作员ID 自增长 **/
    private Integer usrId;
    /** 登录名 **/
    private String usrName;
    /** 登录密码 登录密码MD5 **/
    private String usrPwd;
    /** 客户编号 关联客户编号 **/
    private String cusCode;
    /** 最后一次登录时间 **/
    private String lastLoginTime;
    /** 最后一次登录IP **/
    private String lastLoginIp;
    /** 是否已锁定 0 否、1 是 **/
    private String isLocked;
    /** 登录失败次数 **/
    private Integer failedCount;
    /** 登录后是否需要修改密码 0 否、1 是 **/
    private Integer changePwd;
    /** 状态 0 无效、1有效 **/
    private String status;

    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getUsrPwd() {
        return usrPwd;
    }

    public void setUsrPwd(String usrPwd) {
        this.usrPwd = usrPwd;
    }

    public String getCusCode() {
        return cusCode;
    }

    public void setCusCode(String cusCode) {
        this.cusCode = cusCode;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(String isLocked) {
        this.isLocked = isLocked;
    }

    public Integer getFailedCount() {
        return failedCount;
    }

    public void setFailedCount(Integer failedCount) {
        this.failedCount = failedCount;
    }

    public Integer getChangePwd() {
        return changePwd;
    }

    public void setChangePwd(Integer changePwd) {
        this.changePwd = changePwd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
