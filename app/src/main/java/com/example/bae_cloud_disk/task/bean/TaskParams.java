package com.example.bae_cloud_disk.task.bean;

public class TaskParams {
    private String skuName;
    private String skuCode;
    private String taskStatus;

    public String getSkuName() {
        return skuName;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public TaskParams(String skuName, String skuCode, String taskStatus) {
        this.skuName = skuName;
        this.skuCode = skuCode;
        this.taskStatus = taskStatus;
    }
}
