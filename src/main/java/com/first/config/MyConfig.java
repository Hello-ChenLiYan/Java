package com.first.config;

import com.first.interceptor.LoginHandlerInterceptor;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author 小胖
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {

    //所有的WebMvcConfigurer组件都会一起起作用
    /**
     * 将组件注册在容器
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("index");

            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").
                        excludePathPatterns("/login","/","/admin/login","/css/**","/images/**","/js/**","/api/**","/font-awesome-4.7.0/**","/jq-module/**","/jquery-3.4.1/**","/layui-v2.5.5/**");
            }

            @Override
            //需要告知系统，这是要被当成静态文件的！
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                // 设置文件上传的文件不拦截
               // registry.addResourceHandler("/upload/**").addResourceLocations("file:"+ TaleUtils.getUplodFilePath()+"upload/");
                //第一个方法设置访问路径前缀，第二个方法设置资源路径
                registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
            }
        };
    }
}