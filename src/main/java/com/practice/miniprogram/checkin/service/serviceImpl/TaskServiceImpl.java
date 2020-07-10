package com.practice.miniprogram.checkin.service.serviceImpl;

import com.practice.miniprogram.checkin.bean.Task;
import com.practice.miniprogram.checkin.bean.TaskRecord;
import com.practice.miniprogram.checkin.dao.TaskMapper;
import com.practice.miniprogram.checkin.dao.TaskRecordMapper;
import com.practice.miniprogram.checkin.enums.ExceptionEnum;
import com.practice.miniprogram.checkin.exception.SAException;
import com.practice.miniprogram.checkin.pojo.TaskExtend;
import com.practice.miniprogram.checkin.service.TaskService;
import com.practice.miniprogram.checkin.util.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Project checkin
 * @ClassName TaskServiceImpl
 * @Author StarryHu
 * @Description 打卡任务的业务逻辑实现层
 * @Date 2020/7/10 22:57
 */
@Service("taskService")
@Transactional
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    private TaskRecordMapper taskRecordMapper;

    /***
     * @Description: 创建打卡任务
     * @Param: [userId, taskTitle, taskContent, startTime, endTime]
     * @return: com.practice.miniprogram.checkin.bean.Task
     * @Author: StarryHu
     * @Date: 2020/7/10
     */
    public String add(String userId, String taskTitle, String taskContent, String startTime, String endTime) throws Exception {
        // 检查日期是否符合格式
        String pattern = "/^(?:19|20)[0-9][0-9]-(?:(?:0[1-9])|(?:1[0-2]))-(?:(?:[0-2] \n" +
                "   [1-9])|(?:[1-3][0-1]))/";
        Pattern r = Pattern.compile(pattern);
        Matcher m1 = r.matcher(startTime);
        Matcher m2 = r.matcher(endTime);
        if (!m1.matches() || !m2.matches()) {
            throw new SAException(ExceptionEnum.TASK_DATE_FORMAT_ERROR);
        }
        // 生成任务对象
        Task task = new Task();
        task.setTaskId(IDGenerator.generator());
        task.setUserId(userId);
        task.setTitle(taskTitle);
        task.setContent(taskContent);
        task.setStartTime(startTime);
        task.setEndTime(endTime);
        task.setIsDel(false);

        int n = taskMapper.insert(task);
        if (n > 0) return task.getTaskId();
        throw new SAException(ExceptionEnum.TASK_ADD_FAIL);
    }

    @Override
    public int delete(String taskId) throws Exception {
        return 0;
    }

    @Override
    public int update(String taskTitle, String taskContent, String startTime, String endTime) throws Exception {
        return 0;
    }

    @Override
    public List<TaskExtend> getAllTasks(String userId) throws Exception {
        return null;
    }

    @Override
    public List<TaskRecord> getAllRecordsByTask(String taskId) throws Exception {
        return null;
    }
}
