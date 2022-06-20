package com.qinbaoge.hngmanagementsystem;

import com.qinbaoge.hngmanagementsystem.Util.Interceptor1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class HngManagementSystemApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(HngManagementSystemApplication.class, args);
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        InterceptorRegistration ir=registry.addInterceptor(new Interceptor1());
        ir.addPathPatterns("/**");
        ir.excludePathPatterns("/login","/css/**","/font/**","/fonts/**","/images/**","/js/**","/lib/**","/layui.js","/favicon.ico","/validatelogin");
    }
}
