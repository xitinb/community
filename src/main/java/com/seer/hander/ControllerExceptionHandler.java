package com.seer.hander;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description： 拦截异常处理器
 * @Author :SeerLiang
 * @Date :2021/3/31 16:53
 * @Version :1.0
 */

@ControllerAdvice
public class ControllerExceptionHandler {

    //获取slf4j日志对象
    private final Logger logger=LoggerFactory.getLogger(this.getClass());

    //标识异常的级别，处理异常,这里处理全局异常
    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)可以增加状态码
    public ModelAndView exceptionHandler(HttpServletRequest request,Exception e) throws Exception {
        //把异常的  url和异常写入日志
        logger.error("Request URL : {},Exception : {}",request.getRequestURL(),e);

        //当标识了状态码的时候就不拦截，抛出后有自定义异常处理
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class)!=null){
            throw e;
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("url",request.getRequestURL());
        mv.addObject("exception",e);
        mv.setViewName("error/error");
        return mv;
    }


}
