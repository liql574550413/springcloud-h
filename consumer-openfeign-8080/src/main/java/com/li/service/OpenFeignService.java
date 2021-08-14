package com.li.service;

import com.li.entities.Provider;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author liql
 * @date 2021/8/12
 */
@Component
@FeignClient("PROVIDER-SERVICE")
public interface OpenFeignService {
    @PostMapping("/provider")
     String create(@RequestBody Provider provider);

    @PostMapping("/provider/timeout")
     String timeout(@RequestBody Provider provider);
}
