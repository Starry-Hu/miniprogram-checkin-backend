package com.practice.miniprogram.checkin.service;

import com.practice.miniprogram.checkin.bean.Task;
import com.practice.miniprogram.checkin.bean.TaskRecord;
import com.practice.miniprogram.checkin.pojo.TaskExtend;

import java.util.List;

public interface TaskService {
    // 某用户创建打卡任务
    String add(String userId, String title, String content, String startTime, String endTime) throws Exception;

    // 删除打卡任务
    int delete(String taskId) throws Exception;

    // 修改打卡任务
    int update(String taskId, String title, String content, String startTime, String endTime) throws Exception;

    // 获取某用户的全部打卡任务(并带有该任务状态与今天的打卡状态)
    List<TaskExtend> getAllTasksByUser(String userId) throws Exception;

    // 查看某任务的全部打卡记录
    List<TaskRecord> getAllRecordsByTask(String taskId) throws Exception;

    // 对某任务进行打卡（可以是今日打卡，也可以是补打卡）
    int checkOneTask(String taskId, String checkDate, String checkLocation, String checkWeather) throws Exception;
}
