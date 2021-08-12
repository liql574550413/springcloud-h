package com.li.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liql
 * @date 2021/8/11
 */
@Component
@Slf4j
public class MyLoadBalanceImpl implements MyLoadBalance {


    /**
     *
     * @param serviceInstances  某个服务的服务实例列表 本次的为 PROVIDER-SERVICE 服务实例列表
     * @return
     */
    //自定义随机策略
    @Override
    public ServiceInstance getIntacnce(List<ServiceInstance> serviceInstances) {
        Random random = new Random();
        //生成随机的  服务实例下标
        int index = random.nextInt(serviceInstances.size());
        log.info("获得的微服务的对应下标为：{}",index);
        //返回服务实例给调用者
        return serviceInstances.get(index);
    }

    //用来记录访问次数，每访问一次，就加 1
    private final AtomicInteger atomicInteger= new AtomicInteger(0);
    @Override
    public ServiceInstance getRobin(List<ServiceInstance> serviceInstances){
        int current;
        int next;
        do {
            current=atomicInteger.get();
//            log.info("已经调用了 {} 次",current);
            //三元运算 解决访问次数超过 int类型最大值问题
            next =current>Integer.MAX_VALUE ? 0 : current+1;
        }while (!this.atomicInteger.compareAndSet(current, next));

        log.info("已经调用了{} 次,  本次调用的下标为 {}",current,next % serviceInstances.size());
        //返回调用的实例  注意取余
        return  serviceInstances.get(next % serviceInstances.size());
    }
}
