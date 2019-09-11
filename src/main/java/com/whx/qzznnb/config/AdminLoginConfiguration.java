package com.whx.qzznnb.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName AdminLoginConfiguration
 * @Description TODO
 * @Date 2019/8/27 21:02
 * @Version 1.0.0
 **/
//@Configuration  取消拦截
public class AdminLoginConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
         AdminLoginInterceptor adminLoginInterceptor =new AdminLoginInterceptor();
        InterceptorRegistration interceptorRegistry = registry.addInterceptor(adminLoginInterceptor);
        // 扫描路径
      //  interceptorRegistry.addPathPatterns("/**");
        // 排除路径
        interceptorRegistry.excludePathPatterns("/**");//排除所有路径
        interceptorRegistry.excludePathPatterns("/user/login");
        interceptorRegistry.excludePathPatterns("/user/create");
        interceptorRegistry.excludePathPatterns("/hello");

        //  排除请求资源
        interceptorRegistry.excludePathPatterns("/css/*.css");
        interceptorRegistry.excludePathPatterns("/js/*.js");
        interceptorRegistry.excludePathPatterns("/register.html");
        interceptorRegistry.excludePathPatterns("/login.html");
    }
}
