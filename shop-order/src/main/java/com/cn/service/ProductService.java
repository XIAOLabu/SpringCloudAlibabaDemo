package com.cn.service;

import com.cn.domain.Product;
import com.cn.service.fallback.ProductServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author ChenZZ
 * @Date 2021/12/29 14:48
 * 商品微服务调用
 * fallback 用于指定当前fegin接口的容错类
 * value用于指定调用nacos下的哪个微服务
 */
@FeignClient(value = "shop-product", fallback = ProductServiceFallback.class)
public interface ProductService {

    /**
     * 指定请求的URL部分
     *
     * @param pId
     * @return
     */
    @RequestMapping("/product/{pId}")
    Product findById(@PathVariable("pId") Integer pId);

}
