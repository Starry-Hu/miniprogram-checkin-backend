package com.practice.miniprogram.checkin.dao;

import com.practice.miniprogram.checkin.bean.TaskRecord;
import com.practice.miniprogram.checkin.bean.TaskRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskRecordMapper {
    long countByExample(TaskRecordExample example);

    int deleteByExample(TaskRecordExample example);

    int deleteByPrimaryKey(String taskRecordId);

    int insert(TaskRecord record);

    int insertSelective(TaskRecord record);

    List<TaskRecord> selectByExample(TaskRecordExample example);

    TaskRecord selectByPrimaryKey(String taskRecordId);

    int updateByExampleSelective(@Param("record") TaskRecord record, @Param("example") TaskRecordExample example);

    int updateByExample(@Param("record") TaskRecord record, @Param("example") TaskRecordExample example);

    int updateByPrimaryKeySelective(TaskRecord record);

    int updateByPrimaryKey(TaskRecord record);
}