package com.practice.miniprogram.checkin.exception;

import com.practice.miniprogram.checkin.enums.ExceptionEnum;

/***
 * @Description: checkin系统自定义异常
 * @Author: StarryHu
 * @Date: 2020/7/8
 */
public class SAException extends RuntimeException {

    private Integer code;
    private String msg;

    public SAException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
