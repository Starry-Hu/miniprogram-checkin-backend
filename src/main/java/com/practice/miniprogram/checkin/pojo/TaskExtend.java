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
    private int startCondition;
    // 今天对应的该任务情况：是否已打卡：0否1是
    private  int isTodayCheck;

    public int getStartCondition() {
        return startCondition;
    }

    public void setStartCondition(int startCondition) {
        this.startCondition = startCondition;
    }

    public int getIsTodayCheck() {
        return isTodayCheck;
    }

    public void setIsTodayCheck(int isTodayCheck) {
        this.isTodayCheck = isTodayCheck;
    }
}
