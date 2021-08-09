package com.li.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author liql
 * @date 2021/8/7
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced //开启负载均衡，就可以根据eureka上的服务名称进行调用了 不用再做与eureka的相关配置
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
