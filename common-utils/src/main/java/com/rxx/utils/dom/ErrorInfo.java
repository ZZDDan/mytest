package com.rxx.utils.dom;

/**
 * Created by zhang on 2017/9/12.
 * 错误信息
 */
public class ErrorInfo{
    private String errorCode;
    private String errorDesc;

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    @Override
    public String toString() {
        return "ErrorInfo{" +
                "errorCode='" + errorCode + '\'' +
                ", errorDesc='" + errorDesc + '\'' +
                '}';
    }
}
