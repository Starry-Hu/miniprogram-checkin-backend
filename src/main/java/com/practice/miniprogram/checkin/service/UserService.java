package com.practice.miniprogram.checkin.service;

import com.practice.miniprogram.checkin.bean.User;

public interface UserService {
    // 注册用户
    int register(String userId, String userName, String password, String birthday, int gender) throws Exception;

    // 登录用户
    User login(String userId, String password) throws Exception;

    // 查找用户，获取基本信息
    User searchById(String userId) throws Exception;

    // 修改个人信息
    int update(String userId, String userName, String password, String birthday, int gender) throws Exception;

    // 注销用户
    int delete(String userId) throws Exception;
}
