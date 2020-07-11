package com.practice.miniprogram.checkin.enums;

/***
 * @Description: 出现异常的枚举信息
 * @Param:
 * @return:
 * @Author: StarryHu
 * @Date: 2019/7/1
 */
public enum ExceptionEnum {
    // 用户相关
    USER_REGISTER_EXIST(101, "该账号已存在！"),
    USER_REGISTER_FAIL(102, "账号注册失败！"),
    USER_NOT_EXIST(103, "该账号不存在！"),
    USER_PSW_ERROR(103, "账号或密码错误！"),
    USER_UPDATE_ERROR(104, "账户信息修改失败！"),
    USER_DELETE_ERROR(105, "账户删除失败！"),

    // 任务相关
    TASK_ADD_FAIL(302, "打卡任务添加失败！"),
    TASK_NOT_EXSTI(303, "该打卡任务不存在！"),
    TASK_DELETE_FAIL(304, "打卡任务删除失败！"),
    TASK_UPDATE_FAIL(305, "打卡任务更新失败！"),
    TASK_EMPTY(306, "没有打卡任务！"),
    TASK_RECORD_EMPTY(307, "该任务未有打卡记录"),
    TASK_CHECK_FAIL(308, "打卡失败！"),

    // 通用
    DATE_FORMAT_ERROR(501, "日期格式不合要求！"),
    ;
    private Integer code;

    private String msg;

    ExceptionEnum(Integer code, String msg) {
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
