package cn.interceptor;

import cn.po.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截除登陆界面的一切请求
 */

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        if(uri.indexOf("/login.action") >= 0){
            return true;
        }else if( uri.indexOf("/gologin.action") >= 0)
        {
            return true;
        }

        User user = (User) request.getSession().getAttribute("USER_SESSION");
        if (user != null){
            return true;
        }
        request.setAttribute("msg", "您还没登陆请先登陆");
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        return false;
    }
}
