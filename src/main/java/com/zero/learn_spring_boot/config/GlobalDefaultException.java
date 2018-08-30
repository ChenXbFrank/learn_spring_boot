package com.zero.learn_spring_boot.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 *  1.在自定义的类上添加@ControllerAdvice
 *  2.在方法上面添加@ExceptionHandler
 *  3.如果返回的是view   方法的返回值就是ModeAndView
 *  4.如果返回的是String或者json数据，那么需要在方法上添加@ResponseBody
 * Created by 81046 on 2018-08-29
 */
@ControllerAdvice
public class GlobalDefaultException {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String defaultException(HttpServletRequest request,Exception e){
        return e.getMessage();
    }
}
