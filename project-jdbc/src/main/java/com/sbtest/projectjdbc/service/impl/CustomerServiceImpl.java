package com.sbtest.projectjdbc.service.impl;

import com.sbtest.projectjdbc.common.CryptoUtil;
import com.sbtest.projectjdbc.consts.MessageCode;
import com.sbtest.projectjdbc.common.MessageSourceAccessor;
import com.sbtest.projectjdbc.dao.UserDao;
import com.sbtest.projectjdbc.common.SbtestException;
import com.sbtest.projectjdbc.entity.User;
import com.sbtest.projectjdbc.query.UserQuery;
import com.sbtest.projectjdbc.service.CustomerService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);
    @Autowired
    private MessageSourceAccessor msa;
    @Autowired
    private UserDao userDao;
    @Override
    public User getCustomer(UserQuery userQuery) throws Exception {
        String LOG_TITLE="CustomerServiceImpl.getCustomer";
        LOGGER.info(LOG_TITLE+"开始执行登录");
        if(StringUtils.isEmpty(userQuery.getUsrName())){
            throw new SbtestException(MessageCode.SB001,msa.getMessage(MessageCode.SB001,"用户名"));
        }
        if(StringUtils.isEmpty(userQuery.getUsrPwd())){
            throw new SbtestException(MessageCode.SB001,msa.getMessage(MessageCode.SB001,"密码"));
        }
        // 加密规则为（用户名MD5+密码）MD5
        String md5Psw = CryptoUtil.md5Sign(CryptoUtil.md5Sign(userQuery.getUsrName()) + userQuery.getUsrPwd());
        userQuery.setUsrPwd(md5Psw);
        User user = userDao.loginByNameAndPwd(userQuery);
        if(user == null){
            throw new SbtestException(MessageCode.SB002,msa.getMessage(MessageCode.SB002));
        }
        LOGGER.info(LOG_TITLE+"执行登录结束");
        return user;
    }
}
