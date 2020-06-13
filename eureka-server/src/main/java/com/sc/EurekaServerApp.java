package com.sc;

@EnableEurekaServer //表示Eureka注册中心
@SpringBootApplication
public class EurekaServerApp {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApp.class,args);
    }

}
