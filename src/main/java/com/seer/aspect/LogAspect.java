package com.seer.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


/**
 * @Description：日志处理
 * @Author :SeerLiang
 * @Date :2021/4/6 15:59
 * @Version :1.0
 */
@Aspect
@Component
public class LogAspect {
    private final Logger logger =LoggerFactory.getLogger(this.getClass());

    //拦截控制器
    @Pointcut("execution(* com.seer.controller.*.*(..))")
    public void log(){}

    //方法前
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("-------------dobefore---------");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();//请求的url
        String ip = request.getRemoteAddr();  //请求的ip
        //获得请求的类和方法
        String classMethod=joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
        logger.info("Request :{}",requestLog);

    }

    //方法后
    @After("log()")
    public void doAfter(){
        System.out.println("-------------doafter---------");
    }

    //方法方法后返回
    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturn(Object result){
        logger.info("Result : {}",result);
    }

    //用来记录请求参数的类
    private class RequestLog{
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;

        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "RequestLog{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
