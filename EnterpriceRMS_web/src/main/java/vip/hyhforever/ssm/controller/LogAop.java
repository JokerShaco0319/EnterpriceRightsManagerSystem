package vip.hyhforever.ssm.controller;
/*
 * 作者：JokerShaco
 * 创建时间：2022/8/3 , 17:34
 * 功能描述：
 * */

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
import org.springframework.web.servlet.ModelAndView;
import vip.hyhforever.ssm.domain.SysLog;
import vip.hyhforever.ssm.service.ISysLogService;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysLogService sysLogService;

    private Date visitTime; //开始时间
    private Class clazz;    //访问的类
    private Method method;  //执行的方法

    //前置通知： 获取开始时间，执行的类和执行的方法
    @Before("execution(* vip.hyhforever.ssm.controller.*.*(..))")   //拦截Controller下的所有类的所有方法
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        visitTime = new Date();                             //获取当前的时间
        clazz = jp.getTarget().getClass();                  //获取具体要访问的类
        String methodName = jp.getSignature().getName();    //获取访问的方法名字
        Object[] args = jp.getArgs();//获取访问方法的参数

        //获取具体执行的方法的method对象
        if (args == null || args.length == 0){
            method = clazz.getMethod(methodName);   //只能获取无参的方法
        }else{
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            clazz.getMethod(methodName, classArgs);
        }
    }

    @After("execution(* vip.hyhforever.ssm.controller.*.*(..))")//后置通知
    public void doAfter(JoinPoint jp) throws Exception {
        Long time = new Date().getTime() - visitTime.getTime(); //获取访问时长
        String url = "";

        //获取当前访问的URL
        if (clazz!=null && method!=null && clazz!=LogAop.class){
            //1.获取类上的@RequestMapping
            RequestMapping clazzAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (clazzAnnotation != null){
                //获取类上的RequestMapping的Value值
                String classValue = (clazzAnnotation.value())[0];
                //获取方法上的RequestMapping的Value值
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null){
                    String methodValue = (methodAnnotation.value())[0];
                    url = classValue + methodValue;         //拼接URl的值
                }
            }
        }

        //获取访问的ip地址
        String ipAddr = request.getRemoteAddr();

        //获取当前操作用户
        SecurityContext context = SecurityContextHolder.getContext();
        User user = (User)context.getAuthentication().getPrincipal();
        String username = user.getUsername();

        //封装日志信息到日志类
        SysLog sysLog = new SysLog();
        sysLog.setUsername(username);       //当前用户
        sysLog.setIp(ipAddr);               //访问地址
        sysLog.setExecutionTime(time);      //执行时长
        sysLog.setMethod("[类名]："+ clazz.getName() +"[方法名：]"+ method.getName()); //访问的方法
        Logger.getGlobal().info("[类名]："+ clazz.getName() +"[方法名：]"+ method.getName());
        sysLog.setUrl(url);                 //url地址
        sysLog.setVisitTime(visitTime);     //访问时间

        //调用Service 完成日志存储操作
        sysLogService.save(sysLog);
    }

}
