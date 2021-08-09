package com.li;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //eurake作为注册中心时使用的启动注解   如果是作为实例 则使用@EnableEurekaClient
public class Eureka8001Application {

    public static void main(String[] args) {
        SpringApplication.run(Eureka8001Application.class, args);
    }

}
