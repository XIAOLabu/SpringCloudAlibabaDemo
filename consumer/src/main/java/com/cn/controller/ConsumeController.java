package com.cn.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author ChenZZ
 * @Date 2021/12/14 16:00
 */
@RestController
@RequestMapping("consume")
public class ConsumeController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("demo")
    public String demo(){
        return "demo";
    }

    @GetMapping("hello/{message}")
    @SentinelResource(value = "consume", blockHandler = "blockHandlerCommon")
    public String hello(@PathVariable String message) {
        //ServiceInstance serviceInstance = loadBalancerClient.choose("provider");
        //String path = String.format("http://%s:%s/provider/%s", serviceInstance.getHost(), serviceInstance.getPort(), "hello");
        String path = "http://provider/provider/"+message;
        String result = restTemplate.getForObject(path, String.class);
        System.out.println(String.format("%s from", result));
        return String.format("%s from", result);
    }

    @GetMapping("user/{Uid}")
    public String demo(@PathVariable Integer Uid){
        System.out.println("Uid=========>"+Uid);
        return "ok";
    }

    /**
     * 原方法调用被限流/降级/系统保护的时候调用
     * @param ex
     * @return
     */
    public String blockHandlerCommon(BlockException ex){
        ex.printStackTrace();
        return "系统繁忙，请稍后！";
    }

}
