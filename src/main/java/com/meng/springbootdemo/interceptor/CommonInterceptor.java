package com.meng.springbootdemo.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CommonInterceptor extends HandlerInterceptorAdapter {
    Logger logger = LogManager.getLogger(CommonInterceptor.class);

    //preHandle在业务处理器处理请求之前被调用，
    //postHandle在业务处理器处理请求执行完成后,生成视图之前执行
    //afterCompletion在DispatcherServlet完全处理完请求后被调用
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        logger.info("请求ip："+request.getRemoteAddr());
        logger.info("请求的方法："+request.getMethod());
        ModelMap modelMap = modelAndView.getModelMap();
        modelMap.addAttribute("title","dalaoyang");
    }

}
