package com.li;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author liql
 * @date 2021/8/7
 */
@SpringBootApplication
@EnableEurekaClient //eureka 的 client使用的启动注解
public class ProviderEureka9002 {
    public static void main(String[] args){
        SpringApplication.run(ProviderEureka9002.class, args);
    }

}
