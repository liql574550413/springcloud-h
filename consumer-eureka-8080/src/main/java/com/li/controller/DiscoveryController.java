package com.li.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liql
 * @date 2021/8/7
 */
@RestController
@Slf4j
public class DiscoveryController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/discovery")
    public Object discovery(){
        List<ServiceInstance> instances = discoveryClient.getInstances("PROVIDER-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId());
            log.info(instance.getServiceId());
            log.info(String.valueOf(instance.getUri()));
            System.out.println("端口号："+instance.getPort());
        }

        return this.discoveryClient;
    }
}
