package com.practice.miniprogram.checkin.controller;

import com.practice.miniprogram.checkin.bean.TaskRecord;
import com.practice.miniprogram.checkin.enums.ResultEnum;
import com.practice.miniprogram.checkin.pojo.TaskExtend;
import com.practice.miniprogram.checkin.service.TaskService;
import com.practice.miniprogram.checkin.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Project checkin
 * @ClassName TaskController
 * @Author StarryHu
 * @Description 打卡任务接口
 * @Date 2020/7/11 12:55
 */
@RestController
@RequestMapping("task")
public class TaskController extends BaseController{
    @Autowired
    private TaskService taskService;
    
    /*** 
    * @Description: 某用户添加打卡信息 
    * @Param: [userId, title, content, startTime, endTime] 
    * @return: com.practice.miniprogram.checkin.util.BaseResponse 
    * @Author: StarryHu
    * @Date: 2020/7/11 
    */ 
    @PostMapping("/add")
    BaseResponse add(String userId, String title, String content, String startTime, String endTime) throws Exception {
        // 检查内容是否填写完全
        if (userId == null || title == null || content == null || startTime == null || endTime == null || userId.trim().equals("")
                || title.trim().equals("") || content.trim().equals("") || startTime.trim().equals("") || endTime.trim().equals("")) {
            return ajaxFail(ResultEnum.TASK_INFO_NOT_FULL);
        }
        String taskId = taskService.add(userId, title, content, startTime, endTime);
        return ajaxSucc(taskId, ResultEnum.TASK_ADD_SUCCESS);
    }

    /*** 
    * @Description: 删除某打卡任务 
    * @Param: [taskId] 
    * @return: com.practice.miniprogram.checkin.util.BaseResponse 
    * @Author: StarryHu
    * @Date: 2020/7/11 
    */ 
    @GetMapping("/delete")
    BaseResponse delete(String taskId) throws Exception {
        // 检查内容是否填写完全
        if (taskId == null || taskId.trim().equals("")) {
            return ajaxFail(ResultEnum.TASK_INFO_NOT_FULL);
        }
        taskService.delete(taskId);
        return ajaxSucc(null, ResultEnum.TASK_DELETE_SUCCESS);
    }

    /*** 
    * @Description: 修改某打卡任务 
    * @Param: [taskId, title, content, startTime, endTime] 
    * @return: com.practice.miniprogram.checkin.util.BaseResponse 
    * @Author: StarryHu
    * @Date: 2020/7/11 
    */ 
    @PostMapping("/update")
    BaseResponse update(String taskId, String title, String content, String startTime, String endTime) throws Exception {
        // 检查内容是否填写完全
        if (taskId == null || title == null || content == null || startTime == null || endTime == null || taskId.trim().equals("")
                || title.trim().equals("") || content.trim().equals("") || startTime.trim().equals("") || endTime.trim().equals("")) {
            return ajaxFail(ResultEnum.TASK_INFO_NOT_FULL);
        }
        taskService.update(taskId, title, content, startTime, endTime);
        return ajaxSucc(taskId, ResultEnum.TASK_UPDATE_SUCCESS);
    }

    /*** 
    * @Description: 获取某用户的全部打卡任务(并带有该任务状态与今天的打卡状态) 
    * @Param: [userId] 
    * @return: com.practice.miniprogram.checkin.util.BaseResponse 
    * @Author: StarryHu
    * @Date: 2020/7/11 
    */ 
    @GetMapping("/getAllTasksByUser")
    BaseResponse getAllTasksByUser(String userId) throws Exception {
        // 检查内容是否填写完全
        if (userId == null || userId.trim().equals("")) {
            return ajaxFail(ResultEnum.TASK_INFO_NOT_FULL);
        }
        List<TaskExtend> data = taskService.getAllTasksByUser(userId);
        return ajaxSucc(data, ResultEnum.TASK_SEARCH_SUCCESS);
    }

    /*** 
    * @Description: 查看某任务的全部打卡记录 
    * @Param: [taskId] 
    * @return: com.practice.miniprogram.checkin.util.BaseResponse 
    * @Author: StarryHu
    * @Date: 2020/7/11 
    */ 
    @GetMapping("/getAllRecordsByTask")
    BaseResponse getAllRecordsByTask(String taskId) throws Exception {
        // 检查内容是否填写完全
        if (taskId == null || taskId.trim().equals("")) {
            return ajaxFail(ResultEnum.TASK_INFO_NOT_FULL);
        }
        List<TaskRecord> data = taskService.getAllRecordsByTask(taskId);
        return ajaxSucc(data, ResultEnum.TASK_RECORD_SEARCH_SUCCESS);
    }

    /*** 
    * @Description: 对某任务进行打卡
    * @Param: [taskId, checkDate, checkLocation, checkWeather] 
    * @return: com.practice.miniprogram.checkin.util.BaseResponse 
    * @Author: StarryHu
    * @Date: 2020/7/11 
    */ 
    @PostMapping("/checkOneTask")
    BaseResponse checkOneTask(String taskId, String checkDate, String checkLocation, String checkWeather) throws Exception {
        // 检查内容是否填写完全
        if (taskId == null || checkDate == null || checkLocation == null || checkWeather == null || taskId.trim().equals("")
                || checkDate.trim().equals("") || checkLocation.trim().equals("") || checkWeather.trim().equals("") ) {
            return ajaxFail(ResultEnum.TASK_INFO_NOT_FULL);
        }
        taskService.checkOneTask(taskId, checkDate, checkLocation, checkWeather);
        return ajaxSucc(null, ResultEnum.TASK_CHECK_SUCCESS);
    }
}
