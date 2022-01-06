package com.cn.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author ChenZZ
 * @Date 2021/12/14 16:06
 */
@Configuration
public class ConsumerConfigure {

    @Bean
    @LoadBalanced //ribbon的负载均衡注解
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
