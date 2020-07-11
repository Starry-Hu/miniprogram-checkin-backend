package com.practice.miniprogram.checkin.controller;

import com.practice.miniprogram.checkin.bean.User;
import com.practice.miniprogram.checkin.enums.ResultEnum;
import com.practice.miniprogram.checkin.pojo.UserExtend;
import com.practice.miniprogram.checkin.service.UserService;
import com.practice.miniprogram.checkin.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project checkin
 * @ClassName UserController
 * @Author StarryHu
 * @Description 用户接口层
 * @Date 2020/7/11 12:13
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    /*** 
    * @Description: 用户注册 
    * @Param: [userId, userName, password, birthday, gender] 
    * @return: com.practice.miniprogram.checkin.util.BaseResponse 
    * @Author: StarryHu
    * @Date: 2020/7/11 
    */ 
    @PostMapping("/register")
    BaseResponse register(String userId, String userName, String password, String birthday, Integer gender) throws Exception {
        // 检查内容是否填写完全
        if (userId == null || userName == null || password == null || birthday == null || gender == null || userId.trim().equals("") 
                || userName.trim().equals("") || password.trim().equals("") || birthday.trim().equals("") || (gender!=0 && gender!=1 && gender!=2)) {
            return ajaxFail(ResultEnum.USER_INFO_NOT_FULL);
        }
        userService.register(userId, userName, password, birthday, gender);
        return ajaxSucc(null, ResultEnum.USER_REGISTER_SUCCESS);
    }

    /***
    * @Description: 用户登录
    * @Param: [userId, password]
    * @return: com.practice.miniprogram.checkin.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2020/7/11
    */
    @PostMapping("/login")
    BaseResponse login(String userId, String password) throws Exception {
        // 检查内容是否填写完全
        if (userId == null || password == null || userId.trim().equals("") || password.trim().equals("") ) {
            return ajaxFail(ResultEnum.USER_INFO_NOT_FULL);
        }
        User user = userService.login(userId, password);
        return ajaxSucc(user, ResultEnum.USER_LOGIN_SUCCESS);
    }

    /*** 
    * @Description: 查找某用户的个人信息(带有年龄、不带密码)
    * @Param: [userId] 
    * @return: com.practice.miniprogram.checkin.util.BaseResponse 
    * @Author: StarryHu
    * @Date: 2020/7/11 
    */ 
    @GetMapping("/search")
    BaseResponse searchById(String userId) throws Exception {
        // 检查内容是否填写完全
        if (userId == null || userId.trim().equals("")) {
            return ajaxFail(ResultEnum.USER_INFO_NOT_FULL);
        }
        UserExtend userExtend = userService.searchById(userId);
        return ajaxSucc(userExtend, ResultEnum.USER_SEARCH_SUCCESS);
    }

    /**
    * @Description: 修改个人信息
    * @Param: [userId, userName, password, birthday, gender]
    * @return: com.practice.miniprogram.checkin.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2020/7/11
    */
    @PostMapping("/update")
    BaseResponse update(String userId, String userName, String password, String birthday, Integer gender) throws Exception {
        // 检查内容是否填写完全
        if (userId == null || userName == null || password == null || birthday == null || gender == null || userId.trim().equals("")
                || userName.trim().equals("") || password.trim().equals("") || birthday.trim().equals("") || (gender!=0 && gender!=1 && gender!=2)) {
            return ajaxFail(ResultEnum.USER_INFO_NOT_FULL);
        }
        userService.update(userId, userName, password, birthday, gender);
        return ajaxSucc(null, ResultEnum.USER_UPDATE_SUCCESS);
    }

    /***
    * @Description: 注销用户
    * @Param: [userId]
    * @return: com.practice.miniprogram.checkin.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2020/7/11
    */
    @GetMapping("/delete")
    BaseResponse delete(String userId) throws Exception {
        // 检查内容是否填写完全
        if (userId == null || userId.trim().equals("")) {
            return ajaxFail(ResultEnum.USER_INFO_NOT_FULL);
        }
        userService.delete(userId);
        return ajaxSucc(null, ResultEnum.USER_DELETE_SUCCESS);
    }
}
