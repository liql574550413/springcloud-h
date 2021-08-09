package com.li.controller;

import com.li.entities.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author liql
 * @date 2021/8/7
 */
@RestController
public class ConsulController {
    //远程调用需要有个url  定义url   这个是单个提供者的  可以写死，多个提供者就不行了
    //    private static final String PROVIDER_URL="http://localhost:9001/";
    //集群的微服务地址要写成微服务的名称  同时开启 RestTemplate的负载均衡功能
    private static final String PROVIDER_URL="http://PROVIDER-SERVICE/";
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("consul")
    public String create(@RequestBody Provider provider){
        //若要携带参数 (这里的是 provider 对象) 远程接口需要添加 @RequestBody 注解来解析 (当成json解析)
       return restTemplate.postForObject(PROVIDER_URL+"provider",provider,String.class);
    }
}
