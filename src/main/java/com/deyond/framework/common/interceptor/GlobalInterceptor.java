package com.deyond.framework.common.interceptor;

import com.deyond.framework.common.utils.HeaderParameterUtil;
import com.deyond.framework.common.utils.SnowflakeIdWorker;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;

/**
 * 全局日志过滤器
 * @author zhiyong.lin
 * @version 2017/9/21 14:41
 */
@Aspect
@Component
public class GlobalInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(GlobalInterceptor.class);

    /** 线程开始时间变量 */
    private static final ThreadLocal<Long> START_TIME_THREADLOCAL = new NamedThreadLocal<Long>("ThreadLocal StartTime");
    private static final ThreadLocal<Long> REQUEST_ID_THREADLOCAL = new NamedThreadLocal<Long>("ThreadLocal RequestId");

    /**
     * 前置设置开始时间
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1、开始时间
        long beginTime = System.currentTimeMillis();
        START_TIME_THREADLOCAL.set(beginTime); // 线程绑定变量（该数据只有当前请求的线程可见）
        REQUEST_ID_THREADLOCAL.set(SnowflakeIdWorker.getInstance(0, 0).nextId());
        logger.info(">>>>>请求ID:{}  开始计时: {}  URI: {}",REQUEST_ID_THREADLOCAL.get(), new SimpleDateFormat("hh:mm:ss.SSS").format(beginTime), request.getRequestURI());
        logger.info(">>>>>调用[{}]，入参：form={}, head={}", request.getServletPath(), HeaderParameterUtil.getParametersMap(request),HeaderParameterUtil.getHeaders(request));
        return true;
    }

    /**
     * 处理中
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 后置判断方法执行时间
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

    /**
     * 定义切面
     */
    @Pointcut("execution(* com.deyond.framework.module.*.controller.*.*(..))")
    private void cutpoint() {
        // 只切入action层
    }

    /**
     * 环绕切面，输出日志
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("cutpoint()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        // 执行action方法
        Object o = pjp.proceed();
        // 日志输出，只对json方法输出日志
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        long endTime = System.currentTimeMillis();
        long beginTime = START_TIME_THREADLOCAL.get();
        long time = endTime - beginTime;
        String url = request.getServletPath();
        String out = o==null?null:o.toString();
        logger.info("<<<<<请求ID:{}，调用[{}]，出参[{}]，耗时[{}ms]",REQUEST_ID_THREADLOCAL.get(),url, out, time);
        return o;
    }

}
