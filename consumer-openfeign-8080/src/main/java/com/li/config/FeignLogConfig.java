package com.li.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liql
 * @date 2021/8/13
 */
@Configuration
public class FeignLogConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return  Logger.Level.FULL;
    }
}
