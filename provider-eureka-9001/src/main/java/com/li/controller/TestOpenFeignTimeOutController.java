package com.li.controller;

import com.li.entities.Provider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.rmi.CORBA.Util;
import java.util.concurrent.TimeUnit;

/**
 * @author liql
 * @date 2021/8/12
 */
@RestController
public class TestOpenFeignTimeOutController {

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/provider/timeout")
    public String timeout(@RequestBody Provider provider){

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "生产成功，产品id="+provider.getId()+"  ;产品product="+provider.getProduct()+" ;生产的端口是 port="+serverPort;
    }
}
