package com.practice.miniprogram.checkin.pojo;

import com.practice.miniprogram.checkin.bean.User;

/**
 * @Project checkin
 * @ClassName UserExtend
 * @Author StarryHu
 * @Description 用户的扩展类
 * @Date 2020/7/11 12:37
 */
public class UserExtend extends User {
    // 年龄
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
