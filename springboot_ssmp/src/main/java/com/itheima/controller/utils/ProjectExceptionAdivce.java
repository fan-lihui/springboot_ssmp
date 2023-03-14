package com.itheima.controller.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: fan-lihui
 * @Create: 2023/3/14 - 9:36
 */
//作为springMVC的异常处理器
//@ControllerAdvice
@RestControllerAdvice //自定义异常处理
public class ProjectExceptionAdivce {

    //拦截所有的异常信息
    @ExceptionHandler
    public R doException(Exception ex){
        //记录日志
        //通知运维
        //通知开发
        ex.printStackTrace();
        return new R("服务器异常,请稍后重试");
    }

}
