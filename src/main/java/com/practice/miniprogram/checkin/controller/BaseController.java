package com.practice.miniprogram.checkin.controller;

import com.practice.miniprogram.checkin.enums.ResultEnum;
import com.practice.miniprogram.checkin.util.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName BaseController
 * @Author starryhu
 * @Description 基础Controller, 所有的Controller都需要继承该Controller
 * @Date 2020/7/11 12:12
 */
public class BaseController {
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    public BaseResponse ajaxSucc(Object data, ResultEnum resultEnum) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(resultEnum.getCode());
        baseResponse.setMsg(resultEnum.getMsg());
        baseResponse.setData(data);
        return baseResponse;
    }

    public BaseResponse ajaxFail(ResultEnum resultEnum) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(resultEnum.getCode());
        baseResponse.setMsg(resultEnum.getMsg());
        return baseResponse;
    }
}
