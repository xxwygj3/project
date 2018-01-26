package com.sbtest.projectjdbc.dto;

import com.sbtest.projectjdbc.common.BaseEntity;
import com.sbtest.projectjdbc.exception.ErrorInfo;

public class RespData extends BaseEntity{
    private ErrorInfo errorInfo;

    public ErrorInfo getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }
}
