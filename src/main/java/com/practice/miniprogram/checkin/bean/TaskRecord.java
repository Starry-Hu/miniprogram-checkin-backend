package com.practice.miniprogram.checkin.bean;

public class TaskRecord {
    private String taskRecordId;

    private String taskId;

    private Integer checkYear;

    private Integer checkMonth;

    private Integer checkDay;

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

    public Integer getCheckYear() {
        return checkYear;
    }

    public void setCheckYear(Integer checkYear) {
        this.checkYear = checkYear;
    }

    public Integer getCheckMonth() {
        return checkMonth;
    }

    public void setCheckMonth(Integer checkMonth) {
        this.checkMonth = checkMonth;
    }

    public Integer getCheckDay() {
        return checkDay;
    }

    public void setCheckDay(Integer checkDay) {
        this.checkDay = checkDay;
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