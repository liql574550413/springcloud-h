package com.li.controller;

import com.li.entities.Provider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liql
 * @date 2021/8/7
 */
@RestController
@Slf4j
public class ProviderController {

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/provider")
    public String create(@RequestBody Provider provider){

        return "生产成功，产品id="+provider.getId()+"  ;产品product="+provider.getProduct()+" ;生产的端口是 port="+serverPort;
    }
}
