package com.practice.miniprogram.checkin.pojo;

import com.practice.miniprogram.checkin.bean.Task;

/**
 * @Project checkin
 * @ClassName TaskExtend
 * @Author StarryHu
 * @Description 打卡类的扩展
 * @Date 2020/7/10 23:08
 */
public class TaskExtend extends Task {
    // 打卡任务的状态：0等待开始、1进行中、2已结束
    int startCondition;
    // 今天对应的该任务情况：是否已打卡：0否1是
    int isTodayCheck;
}
