package com.example.demo;

import com.example.demo.common.utils.CommonInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.demo.**.dao"})
public class DemoApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        String[] excludes = new String[]{};  //.excludePathPatterns()可以排除拦截
        registry.addInterceptor(new CommonInterceptor()).addPathPatterns("/**");
    }


}

