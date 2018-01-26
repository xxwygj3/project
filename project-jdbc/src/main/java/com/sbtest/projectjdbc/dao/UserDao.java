package com.sbtest.projectjdbc.dao;

import com.sbtest.projectjdbc.common.BaseDao;
import com.sbtest.projectjdbc.entity.User;
import com.sbtest.projectjdbc.query.UserQuery;

public interface UserDao extends BaseDao<User>{
    // 客户登录查询 ,查询用户名密码匹配正确并且状态为有效的用户
    User loginByNameAndPwd(UserQuery userQuery);
}
