package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;


@Component
@Aspect
public class LogAop {


    @Autowired
    private HttpServletRequest request;

    /**
     * 访问时间
     */
    private Date visitTime;
    /**
     * 访问的类
     */
    private Class clazz;
    /**
     * 访问的方法
     */
    private Method method;


    /**
     * 前置通知 获取开始时间，执行类，访问方法
     */
    @Before("execution(* com.example.demo.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {

        visitTime = new Date();
        clazz = jp.getTarget().getClass();
        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        if (null == args || args.length == 0) {
            /**只能获取无参的方法*/
            method = clazz.getMethod(methodName);
        } else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName, classArgs);
        }
    }

    /**
     * 后置通知
     */
    @After("execution(* com.example.demo.*.*(..))")
    public void doAfter(JoinPoint jp) {

        /**获取访问的时长*/
        long time = System.currentTimeMillis() - visitTime.getTime();
        String url = "";
        if (clazz != null && method != null && clazz != LogAop.class) {
            /**获取访问路径*/
            RequestMapping calssAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            String[] classValue = calssAnnotation.value();
            RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
            if (methodAnnotation != null) {
                String[] methodValue = methodAnnotation.value();
                url = classValue[0] + methodValue[0];
            }
        }

        String ip = request.getRemoteAddr();
        /**获取操作者 获取当前登录用户信息*/
        SecurityContext context = SecurityContextHolder.getContext();
        User user = (User) context.getAuthentication().getPrincipal();
        String username = user.getUsername();

        /**获取user的另一种方式
         User user = (User) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
         */
    }
}
