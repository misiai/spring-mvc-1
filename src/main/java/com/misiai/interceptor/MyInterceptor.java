package com.misiai.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    /**
     * 一般用前置拦截
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        // 登录状态的判断
        if (request.getSession().getAttribute("user") == null) {
            return true;//放行
        }
        response.sendRedirect("/user/login"); // 中断的处理，一般是跳转到某个页面，如登录页面
        return false;// 中断请求，也即Handler不再执行（Handler指：controller中的方法）
    }

    /**
     * 在Handler之后执行
     * */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");

    }

    /**
     * 页面渲染完成之后，资源回收之类之用
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");

    }
}
