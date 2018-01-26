package com.sbtest.projectjdbc.query;

import com.sbtest.projectjdbc.common.BaseQuery;

public class UserQuery extends BaseQuery {
    /** 登录名 **/
    private String usrName;
    /** 登录密码 登录密码MD5 **/
    private String usrPwd;

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
}
