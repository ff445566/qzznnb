package com.whx.qzznnb.config;

import com.whx.qzznnb.common.WebToken;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**   用户登录拦截器
 * @ClassName AdminLoginInterceptor
 * @Description TODO
 * @Date 2019/8/27 16:16
 * @Version 1.0.0
 **/
public class AdminLoginInterceptor implements HandlerInterceptor {
    //    在请求处理之前调用,只有返回true才会执行请求
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

       try{
            Cookie[] cookie =   httpServletRequest.getCookies();
               System.out.println("长度  " );
               if(cookie != null) {
                   System.out.println("长度  " +cookie.length);
                   for (int i = 0; i < cookie.length; i++) {
                       if (cookie[i].getName().equals("token")) {
                           if (WebToken.parserJavaWebToken(cookie[i].getValue()) != null) {
                               return true;
                           }
                       }
                   }
               } //

                //  不存在则跳转到登录页
                httpServletResponse.sendRedirect( "http://127.0.0.1:8080/login.html");
                return false;

        } catch (Exception e){
            //  不存在则跳转到登录页
            e.printStackTrace();
           System.out.println("拦截器 异常");
            httpServletResponse.sendRedirect( "http://127.0.0.1:8080/login.html");
              return false;
        }


    }

    //    试图渲染之后执行
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    //    在请求处理之后,视图渲染之前执行
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
