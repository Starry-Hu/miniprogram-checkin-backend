package com.practice.miniprogram.checkin.service;

import com.practice.miniprogram.checkin.bean.Task;
import com.practice.miniprogram.checkin.bean.TaskRecord;
import com.practice.miniprogram.checkin.pojo.TaskExtend;

import java.util.List;

public interface TaskService {
    // 某用户创建打卡任务
    String add(String userId, String taskTitle, String taskContent, String startTime, String endTime) throws Exception;

    // 删除打卡任务
    int delete(String taskId) throws Exception;

    // 修改打卡任务
    int update(String taskTitle, String taskContent, String startTime, String endTime) throws Exception;

    // 获取某用户的全部打卡任务(并带有今天的打卡状态)
    List<TaskExtend> getAllTasks(String userId) throws Exception;

    // 查看某任务的全部打卡记录
    List<TaskRecord> getAllRecordsByTask(String taskId) throws Exception;
}
