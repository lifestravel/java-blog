package com.xl.xlblog.aspecct;

import com.xl.xlblog.pojo.RequestLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/7/30
 * @Time 10:57
 * 日志记录:
 *          请求URL，访问者的IP 调用的方法 ,请求参数， 返回的内容
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    final
    HttpServletRequest request;
    final
    RequestLog requestLog;
    @Autowired
    public LogAspect(HttpServletRequest request, RequestLog requestLog) {
        this.request = request;
        this.requestLog = requestLog;
    }

    /***
     * 切面
     */
    @Pointcut("execution(* com.xl.xlblog.controller..*.*(..))")
    public void log(){}

    /**
     * 前置通知
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        String ip = request.getRemoteAddr();
        String url = request.getRequestURL().toString();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        if (args!=null && args.length>0){
            for (int i = 0; i < args.length; i++) {
                if(args[i]!=null) {
                    args[i] = args[i].getClass().getSimpleName() + ":" + args[i];
                }
            }
        }
        requestLog.setIp(ip);
        requestLog.setClassMethod(classMethod);
        requestLog.setUrl(url);
        requestLog.setArgs(args);
    }


    /**
     * 正返回通知
     * @param result
     */
    @AfterReturning(returning = "result",pointcut = "log()" )
    public void doAfterReturn(Object result){
        if (result!=null){
            requestLog.setResult(result.getClass().getName());
        }
        log.info("------requestLog :{}-----------",requestLog);
    }


}
