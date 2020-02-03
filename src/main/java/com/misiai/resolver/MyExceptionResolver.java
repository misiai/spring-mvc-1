package com.misiai.resolver;

import com.misiai.exception.LoginException;
import com.misiai.exception.PermissionException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * 定义一个异常处理器
 */
public class MyExceptionResolver implements HandlerExceptionResolver {
    /**
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @return 返回一个处理异常的视图
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();

        // 判断不同异常
        if (ex instanceof LoginException) {
            // 登录异常
            modelAndView.setViewName("redirect:/user/login");
        } else if (ex instanceof PermissionException) {
            // 权限异常
            modelAndView.setViewName("redirect:/user/permission");
        } else {
            // 其他未考虑到的异常
            modelAndView.setViewName("redirect:/xx/xx3");
        }
        return modelAndView;
    }
}
