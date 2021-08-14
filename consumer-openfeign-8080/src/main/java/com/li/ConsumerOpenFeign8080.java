package com.li;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @author liql
 * @date 2021/8/12
 */
@SpringBootApplication
@EnableFeignClients
//@RibbonClient(value = "PROVIDER-SERVICE",configuration = RibbonConfig.class)
public class ConsumerOpenFeign8080 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOpenFeign8080.class,args);
    }
}
