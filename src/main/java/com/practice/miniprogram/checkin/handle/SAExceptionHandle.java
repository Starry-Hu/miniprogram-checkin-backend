package com.practice.miniprogram.checkin.handle;

import com.practice.miniprogram.checkin.enums.ResultEnum;
import com.practice.miniprogram.checkin.exception.SAException;
import com.practice.miniprogram.checkin.util.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/***
 * @Description: checkin的异常处理类
 * @Author: StarryHu
 * @Date: 2020/7/8
 */

@RestController
@ControllerAdvice
public class SAExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(SAExceptionHandle.class);

    @ExceptionHandler(Exception.class)
    public BaseResponse SAExceptionHandler(Exception e) {
        logger.error("拦截异常");
        e.printStackTrace();
        if (e instanceof SAException) {
            // 系统自定义的异常
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setCode(((SAException) e).getCode());
            // 继承的是exception父类 所以是getMessage
            baseResponse.setMsg(((SAException) e).getMessage());
            // baseResponse.setMsg(((SAException) e).getMsg());
            return baseResponse;
        } else {
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setCode(ResultEnum.UNKNOW_ERROR.getCode());
            baseResponse.setMsg(e.getMessage());
            // 其他异常
            return baseResponse;
        }
    }
}
