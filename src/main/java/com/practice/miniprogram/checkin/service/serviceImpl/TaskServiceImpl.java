package com.practice.miniprogram.checkin.service.serviceImpl;

import com.practice.miniprogram.checkin.bean.Task;
import com.practice.miniprogram.checkin.bean.TaskExample;
import com.practice.miniprogram.checkin.bean.TaskRecord;
import com.practice.miniprogram.checkin.bean.TaskRecordExample;
import com.practice.miniprogram.checkin.dao.TaskMapper;
import com.practice.miniprogram.checkin.dao.TaskRecordMapper;
import com.practice.miniprogram.checkin.daoExtend.TaskExtendMapper;
import com.practice.miniprogram.checkin.enums.ExceptionEnum;
import com.practice.miniprogram.checkin.exception.SAException;
import com.practice.miniprogram.checkin.pojo.TaskExtend;
import com.practice.miniprogram.checkin.service.TaskService;
import com.practice.miniprogram.checkin.util.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    private TaskExtendMapper taskExtendMapper;
    @Autowired
    private TaskRecordMapper taskRecordMapper;

    /***
     * @Description: 创建打卡任务
     * @Param: [userId, taskTitle, taskContent, startTime, endTime]
     * @return: com.practice.miniprogram.checkin.bean.Task
     * @Author: StarryHu
     * @Date: 2020/7/10
     */
    public String add(String userId, String title, String content, String startTime, String endTime) throws Exception {
        // 检查日期是否符合格式
        String pattern = "/^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))" +
                "|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)$/";
        Pattern r = Pattern.compile(pattern);
        Matcher m1 = r.matcher(startTime);
        Matcher m2 = r.matcher(endTime);
        if (!m1.matches() || !m2.matches()) {
            throw new SAException(ExceptionEnum.DATE_FORMAT_ERROR);
        }
        // 生成任务对象
        Task task = new Task();
        task.setTaskId(IDGenerator.generator());
        task.setUserId(userId);
        task.setTitle(title);
        task.setContent(content);
        task.setStartTime(startTime);
        task.setEndTime(endTime);
        task.setIsDel(0);

        int n = taskMapper.insert(task);
        if (n > 0) return task.getTaskId();
        throw new SAException(ExceptionEnum.TASK_ADD_FAIL);
    }

    /**
    * @Description: 删除某打卡任务（逻辑删除）
    * @Param: [taskId]
    * @return: int
    * @Author: StarryHu
    * @Date: 2020/7/11
    */
    public int delete(String taskId) throws Exception {
        // 查找该任务是否存在
        TaskExample taskExample = new TaskExample();
        taskExample.createCriteria().andTaskIdEqualTo(taskId).andIsDelEqualTo(0);
        List<Task> data = taskMapper.selectByExample(taskExample);
        if (data.isEmpty()){
            throw new SAException(ExceptionEnum.TASK_NOT_EXSTI);
        }
        Task task = data.get(0);
        // 进行逻辑删除
        task.setIsDel(1);
        int n = taskMapper.updateByPrimaryKey(task);
        if (n > 0) return n;
        throw new SAException(ExceptionEnum.TASK_DELETE_FAIL);
    }

    /***
    * @Description: 更新某打卡任务（将多余的打卡记录删掉）
    * @Param: [taskTitle, taskContent, startTime, endTime]
    * @return: int
    * @Author: StarryHu
    * @Date: 2020/7/11
    */
    public int update(String taskId, String title, String content, String startTime, String endTime) throws Exception {
        // 查找该任务是否存在
        TaskExample taskExample = new TaskExample();
        taskExample.createCriteria().andTaskIdEqualTo(taskId).andIsDelEqualTo(0);
        List<Task> data = taskMapper.selectByExample(taskExample);
        if (data.isEmpty()){
            throw new SAException(ExceptionEnum.TASK_NOT_EXSTI);
        }
        Task task = data.get(0);
        // 进行内容修改
        task.setTitle(title);
        task.setContent(content);
        task.setEndTime(endTime);
        // 如果开始时间进行了延后，则将之前的内容都删掉
        if(!startTime.equals(task.getStartTime())){
            // 查找某任务在新设定开始时间之前的全部记录，进行删除
            TaskRecordExample taskRecordExample = new TaskRecordExample();
            taskRecordExample.createCriteria().andTaskIdEqualTo(taskId).andCheckDateLessThan(startTime);
            taskRecordMapper.deleteByExample(taskRecordExample);
        }
        // 提交该任务的修改
        int n = taskMapper.updateByPrimaryKeySelective(task);
        if (n > 0)return n;
        throw new SAException(ExceptionEnum.TASK_UPDATE_FAIL);
    }

    /***
    * @Description: 获取某用户的全部打卡任务(并带有今天的打卡状态)
    * @Param: [userId]
    * @return: java.util.List<com.practice.miniprogram.checkin.pojo.TaskExtend>
    * @Author: StarryHu
    * @Date: 2020/7/11
    */
    public List<TaskExtend> getAllTasksByUser(String userId) throws Exception {
        List<TaskExtend> data = taskExtendMapper.getAllTasksByUser(userId);
        if (data.isEmpty()){
            throw new SAException(ExceptionEnum.TASK_EMPTY);
        }
        // 今天的字符串时间
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date today=new Date();
        String todayStr=sdf.format(today);
        // 对每个任务遍历，设置它的状态，并判断今天是否已打卡
        for(TaskExtend taskExtend : data){
            // 开始时间在today之后的为未开始
            if (taskExtend.getStartTime().compareTo(todayStr) > 0){
                taskExtend.setStartCondition(0);
            }
            // 结束时间在today之前的维已结束
            else if(taskExtend.getEndTime().compareTo(todayStr) < 0){
                taskExtend.setStartCondition(2);
            }
            // 其他的是进行中，需判断今天是否已打卡
            else{
                taskExtend.setStartCondition(1);
                TaskRecordExample example = new TaskRecordExample();
                example.createCriteria().andTaskIdEqualTo(taskExtend.getTaskId()).andCheckDateEqualTo(todayStr);
                List<TaskRecord> taskRecord = taskRecordMapper.selectByExample(example);
                if (taskRecord.isEmpty()){
                    taskExtend.setIsTodayCheck(0);
                }else{
                    taskExtend.setIsTodayCheck(1);
                }
            }
        }
        return data;
    }

    /***
    * @Description: 查看某任务的全部打卡记录
    * @Param: [taskId]
    * @return: java.util.List<com.practice.miniprogram.checkin.bean.TaskRecord>
    * @Author: StarryHu
    * @Date: 2020/7/11
    */
    public List<TaskRecord> getAllRecordsByTask(String taskId) throws Exception {
        TaskRecordExample example = new TaskRecordExample();
        example.createCriteria().andTaskIdEqualTo(taskId);
        List<TaskRecord> data = taskRecordMapper.selectByExample(example);
        if (data.isEmpty()){
            throw new SAException(ExceptionEnum.TASK_RECORD_EMPTY);
        }
        return data;
    }
    /*** 
    * @Description: 对某任务进行打卡（今日打卡或补签）
    * @Param: [taskId, checkDate, checkLocation, checkWeather] 
    * @return: int 
    * @Author: StarryHu
    * @Date: 2020/7/11 
    */ 
    public int checkOneTask(String taskId, String checkDate, String checkLocation, String checkWeather) throws Exception{
        // 查找该任务是否存在
        TaskExample taskExample = new TaskExample();
        taskExample.createCriteria().andTaskIdEqualTo(taskId).andIsDelEqualTo(0);
        List<Task> data = taskMapper.selectByExample(taskExample);
        if (data.isEmpty()){
            throw new SAException(ExceptionEnum.TASK_NOT_EXSTI);
        }
        // 对打卡时间进行格式验证
        // 检查日期是否符合格式
        String pattern = "/^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))" +
                "|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)$/";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(checkDate);
        if(!m.matches()){
            throw new SAException(ExceptionEnum.DATE_FORMAT_ERROR);
        }
        // 生成打卡记录对象，进行打卡
        TaskRecord taskRecord = new TaskRecord();
        taskRecord.setTaskId(taskId);
        taskRecord.setCheckDate(checkDate);
        taskRecord.setCheckLocation(checkLocation);
        taskRecord.setCheckWeather(checkWeather);
        int n = taskRecordMapper.insert(taskRecord);
        if (n > 0) return n;
        throw new SAException(ExceptionEnum.TASK_CHECK_FAIL);
    }

}
