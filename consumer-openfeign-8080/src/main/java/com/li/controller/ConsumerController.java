package com.li.controller;

import com.li.entities.Provider;
import com.li.service.OpenFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liql
 * @date 2021/8/12
 */
@RestController
public class ConsumerController {

    @Autowired
    private OpenFeignService openFeignService;

    @PostMapping("consumer")
    public String create(@RequestBody Provider provider){
        //若要携带参数 (这里的是 provider 对象) 远程接口需要添加 @RequestBody 注解来解析 (当成json解析)
        return openFeignService.create(provider);
    }

    @PostMapping("consumer/timeout")
    public String timeOut(@RequestBody Provider provider){
        //若要携带参数 (这里的是 provider 对象) 远程接口需要添加 @RequestBody 注解来解析 (当成json解析)
        return openFeignService.timeout(provider);
    }
}
