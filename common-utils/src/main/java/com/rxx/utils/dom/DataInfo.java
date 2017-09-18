package com.rxx.utils.dom;

/**
 * Created by zhang on 2017/9/12.
 * 数据信息
 */
public class DataInfo {

    /** 任务id */
    private String taskId;
    /** 任务状态 */
    private String taskStatus;
    /** 任务创建时间 */
    private String taskCreateTime;
     /** 任务审批时间 */
    private String taskApprovalTime;
    /** 事件创建时间 */
    private String eventCreateTime;
    /** 结果状态 */
    private String resultStatus;
    /** 结果创建时间 */
    private String resultCreateTime;
    /** 脚本内容 */
    private String scriptContent;
    /** 脚本内容脚本内容 */
    private String resultContent;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskCreateTime() {
        return taskCreateTime;
    }

    public void setTaskCreateTime(String taskCreateTime) {
        this.taskCreateTime = taskCreateTime;
    }

    public String getTaskApprovalTime() {
        return taskApprovalTime;
    }

    public void setTaskApprovalTime(String taskApprovalTime) {
        this.taskApprovalTime = taskApprovalTime;
    }

    public String getEventCreateTime() {
        return eventCreateTime;
    }

    public void setEventCreateTime(String eventCreateTime) {
        this.eventCreateTime = eventCreateTime;
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getResultCreateTime() {
        return resultCreateTime;
    }

    public void setResultCreateTime(String resultCreateTime) {
        this.resultCreateTime = resultCreateTime;
    }

    public String getScriptContent() {
        return scriptContent;
    }

    public void setScriptContent(String scriptContent) {
        this.scriptContent = scriptContent;
    }

    public String getResultContent() {
        return resultContent;
    }

    public void setResultContent(String resultContent) {
        this.resultContent = resultContent;
    }

    @Override
    public String toString() {
        return "DataInfo{" +
                "taskId='" + taskId + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                ", taskCreateTime='" + taskCreateTime + '\'' +
                ", taskApprovalTime='" + taskApprovalTime + '\'' +
                ", eventCreateTime='" + eventCreateTime + '\'' +
                ", resultStatus='" + resultStatus + '\'' +
                ", resultCreateTime='" + resultCreateTime + '\'' +
                ", scriptContent='" + scriptContent + '\'' +
                ", resultContent='" + resultContent + '\'' +
                '}';
    }
}
