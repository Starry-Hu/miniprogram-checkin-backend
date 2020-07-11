package com.practice.miniprogram.checkin.enums;

/*** 
 * @Description: 请求接口的返回的枚举信息
 * @Param:
 * @return:
 * @Author: StarryHu
 * @Date: 2020/7/8
 */
public enum ResultEnum {
    UNKNOW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    FAIL(1, "失败"),

    // 用户相关
    USER_INFO_NOT_FULL(211, "用户信息填写不完全"),
    USER_REGISTER_SUCCESS(201, "注册成功"),
    USER_DELETE_SUCCESS(202, "注销成功"),
    USER_UPDATE_SUCCESS(203, "修改成功"),
    USER_SEARCH_SUCCESS(204, "查找成功"),
    USER_LOGIN_SUCCESS(205, "登录成功"),

    // 打卡任务相关
    TASK_INFO_NOT_FULL(311, "打卡任务信息填写不完全"),
    TASK_ADD_SUCCESS(301, "添加成功"),
    TASK_DELETE_SUCCESS(202, "删除成功"),
    TASK_UPDATE_SUCCESS(203, "修改成功"),
    TASK_SEARCH_SUCCESS(204, "查找成功"),
    TASK_RECORD_SEARCH_SUCCESS(205, "打卡记录查找成功"),
    TASK_CHECK_SUCCESS(206, "打卡成功"),
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
