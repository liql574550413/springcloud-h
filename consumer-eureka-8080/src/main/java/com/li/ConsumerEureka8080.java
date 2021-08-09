package com.li;

import com.ribbon.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "PROVIDER-SERVICE",configuration = RibbonConfig.class)
public class ConsumerEureka8080 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerEureka8080.class, args);
    }

}
