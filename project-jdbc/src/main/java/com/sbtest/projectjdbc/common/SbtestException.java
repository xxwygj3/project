package com.sbtest.projectjdbc.common;

import com.sbtest.projectjdbc.exception.ErrorInfo;

public class SbtestException extends Exception {
    protected ErrorInfo errorInfo;

    public SbtestException(ErrorInfo errorInfo){
        super(errorInfo.getErrorCode() + "," + errorInfo.getErrorMessage());
        this.errorInfo = errorInfo;
    }

    public SbtestException(String errorCode,String errorMessage){
        super(errorCode + "," + errorMessage);
        this.errorInfo = new ErrorInfo();
        this.errorInfo.setErrorCode(errorCode);
        this.errorInfo.setErrorMessage(errorMessage);
    }

    public ErrorInfo getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }
}
