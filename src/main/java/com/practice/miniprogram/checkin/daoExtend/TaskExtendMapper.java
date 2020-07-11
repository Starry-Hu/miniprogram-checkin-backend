package com.practice.miniprogram.checkin.daoExtend;

import com.practice.miniprogram.checkin.pojo.TaskExtend;

import java.util.List;

public interface TaskExtendMapper {
    // 获取某用户的全部打卡任务
    List<TaskExtend> getAllTasksByUser(String userId);
}
