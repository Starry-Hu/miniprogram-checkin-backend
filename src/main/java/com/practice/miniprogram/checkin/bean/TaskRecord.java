package com.practice.miniprogram.checkin.bean;

public class TaskRecord {
    private String taskRecordId;

    private String taskId;

    private String checkDate;

    private String checkLocation;

    private String checkWeather;

    public String getTaskRecordId() {
        return taskRecordId;
    }

    public void setTaskRecordId(String taskRecordId) {
        this.taskRecordId = taskRecordId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckLocation() {
        return checkLocation;
    }

    public void setCheckLocation(String checkLocation) {
        this.checkLocation = checkLocation;
    }

    public String getCheckWeather() {
        return checkWeather;
    }

    public void setCheckWeather(String checkWeather) {
        this.checkWeather = checkWeather;
    }
}