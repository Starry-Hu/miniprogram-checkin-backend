package com.practice.miniprogram.checkin.daoExtend;

import com.practice.miniprogram.checkin.pojo.UserExtend;

import java.util.List;

public interface UserExtendMapper {
    // 获取某用户个人信息
    UserExtend searchById(String userId);
}
