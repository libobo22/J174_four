package com.project.interceptor;

import com.project.dto.UserPermissionDTO;
import com.project.entity.UserEntity;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class PermissionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("执行拦截器preHandle");
        String requestPath=request.getServletPath();
        System.out.println(requestPath);
        if (requestPath.equals("/user/login")){
            return true;
        }
        UserEntity currentUser= (UserEntity) request.getSession().getAttribute("currentUser");
        if (currentUser==null){
            response.getWriter().print("NoLogin");
            return  false;
        }
        if (requestPath.equals("/user/findPermission")){
            return true;
        }
        List<UserPermissionDTO> list= (List<UserPermissionDTO>) request.getSession().getAttribute("userPermissionList");
        for (UserPermissionDTO permission:
             list) {
            if (permission.getPerURL().equals(requestPath)){
                return  true;
            }
        }
        response.getWriter().print("NoPower");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("执行拦截器postHandle方法");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("执行拦截器afterCompletion方法");
    }
}
