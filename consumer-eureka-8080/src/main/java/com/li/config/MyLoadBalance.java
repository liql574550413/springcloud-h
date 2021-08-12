package com.li.config;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author liql
 * @date 2021/8/11
 */
public interface MyLoadBalance {

    ServiceInstance getIntacnce(List<ServiceInstance> serviceInstances);

    ServiceInstance getRobin(List<ServiceInstance> serviceInstances);
}
