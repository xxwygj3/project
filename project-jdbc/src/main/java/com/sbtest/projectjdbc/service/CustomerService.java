package com.sbtest.projectjdbc.service;

import com.sbtest.projectjdbc.entity.User;
import com.sbtest.projectjdbc.query.UserQuery;

public interface CustomerService {
    public User getCustomer(UserQuery userQuery) throws Exception;
}
