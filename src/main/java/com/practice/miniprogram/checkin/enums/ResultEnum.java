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
    ORDER_INFO_NOT_FULL(689, "信息填写不完全"),
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
