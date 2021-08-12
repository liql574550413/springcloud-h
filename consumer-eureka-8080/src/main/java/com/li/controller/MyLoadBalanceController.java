package com.li.controller;

import com.li.config.MyLoadBalance;
import com.li.entities.Provider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author liql
 * @date 2021/8/11
 */
@Slf4j
@RestController
public class MyLoadBalanceController {
    @Autowired
    private MyLoadBalance myLoadBalance;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/myloadbalance")
    public String test(@RequestBody Provider provider){

        //获取特定服务的服务实例列表
        List<ServiceInstance> instances = discoveryClient.getInstances("PROVIDER-SERVICE");
        if (instances==null||instances.size()==0)
            return "无可用服务";
        //获取自定义策略的服务实例
        ServiceInstance intacnce = myLoadBalance.getIntacnce(instances);
        //获取实例的url
        URI uri = intacnce.getUri();
        log.info("获得的url：{}",uri);
       return restTemplate.postForObject(uri+"/provider", provider, String.class);
    }

    @PostMapping("/myloadbalance2")
    public String testRobin(@RequestBody Provider provider){

        //获取特定服务的服务实例列表
        List<ServiceInstance> instances = discoveryClient.getInstances("PROVIDER-SERVICE");
        if (instances==null||instances.size()==0)
            return "无可用服务";
        //获取自定义策略的服务实例
        ServiceInstance intacnce = myLoadBalance.getRobin(instances);
        //获取实例的url
        URI uri = intacnce.getUri();
        log.info("获得的url：{}",uri);
        return restTemplate.postForObject(uri+"/provider", provider, String.class);
    }

}
