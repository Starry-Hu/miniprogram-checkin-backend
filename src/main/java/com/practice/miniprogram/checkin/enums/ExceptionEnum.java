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
    CUSTOMER_REGISTER_EXIST(101, "该账号已存在！"),
    CUSTOMER_REGISTER_FAIL(102, "账号注册失败！"),
    CUSTOMER_NOT_EXIST(103, "该账号不存在！"),
    CUSTOMER_PSW_ERROR(103, "账号或密码错误"),
    CUSTOMER_UPDATE_ERROR(104, "账户信息修改失败"),
    CUSTOMER_DELETE_ERROR(105, "账户删除失败"),

    // 任务相关
    TASK_DATE_FORMAT_ERROR(301, "日期格式不合要求"),
    TASK_ADD_FAIL(302, "打卡任务添加失败！"),
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
