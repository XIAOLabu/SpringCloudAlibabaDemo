package com.cn.config.feign;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author ChenZZ
 * @Date 2021/12/27 11:28
 */
@FeignClient(value = "stock-service")
public interface StockService {

    @GetMapping(value = "/stock/deduct/{productId}/{stockCount}")
    String deductStock(@PathVariable("productId") Long productId, @PathVariable("stockCount") Integer stockCount);
}
