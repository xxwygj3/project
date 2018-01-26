package com.sbtest.projectjdbc.controller;

import com.sbtest.projectjdbc.consts.MessageCode;
import com.sbtest.projectjdbc.common.MessageSourceAccessor;
import com.sbtest.projectjdbc.dto.RespData;
import com.sbtest.projectjdbc.entity.Customer;
import com.sbtest.projectjdbc.entity.User;
import com.sbtest.projectjdbc.exception.ErrorInfo;
import com.sbtest.projectjdbc.common.SbtestException;
import com.sbtest.projectjdbc.query.UserQuery;
import com.sbtest.projectjdbc.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "customer")
public class CustomerController {
    private final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private MessageSourceAccessor msa;
    @Autowired
    private CustomerService customerService;

    @GetMapping(value="hello")
    public String sayHello(){
        return "sayHello";
    }

    @PostMapping(value="login")
    public RespData login(@RequestBody UserQuery userQuery){
        String LOG_TITLE="CustomerController.login";
        LOGGER.info(LOG_TITLE+"登录 请求参数:"+userQuery.toJsonString());
        RespData respData = new RespData();
        try {
            User user = this.customerService.getCustomer(userQuery);
            respData.setErrorInfo(new ErrorInfo(MessageCode.SB000,msa.getMessage(MessageCode.SB000)));
        }catch (SbtestException se) {
            LOGGER.error(LOG_TITLE + " SbtestException:", se);
            respData.setErrorInfo(new ErrorInfo(se.getErrorInfo().getErrorCode(),se.getErrorInfo().getErrorMessage()));
        }catch (Exception e) {
            LOGGER.error(LOG_TITLE + " Exception:", e);
            respData.setErrorInfo(new ErrorInfo(MessageCode.SB999,msa.getMessage(MessageCode.SB999)));
        }
        LOGGER.info(LOG_TITLE+"登录 响应参数:"+respData.toJsonString());
        return respData;
    }
}
