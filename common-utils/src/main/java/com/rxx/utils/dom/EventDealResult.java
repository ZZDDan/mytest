package com.rxx.utils.dom;

/**
 * Created by zhang on 2017/9/12.
 */
public class EventDealResult {

    private ErrorInfo errorInfo = new ErrorInfo();
    private DataInfo dataInfo = new DataInfo();

    public ErrorInfo getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }

    public DataInfo getDataInfo() {
        return dataInfo;
    }

    public void setDataInfo(DataInfo dataInfo) {
        this.dataInfo = dataInfo;
    }

    @Override
    public String toString() {
        return "EventDealResult{" +
                "errorInfo=" + errorInfo +
                ", dataInfo=" + dataInfo +
                '}';
    }
}
