package com.cn.service;

import com.cn.domain.User;
import com.cn.service.fallback.ProductServiceFallback;
import com.cn.service.fallback.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author ChenZZ
 * @Date 2021/12/29 15:13
 * 用户微服务调用
 */
@FeignClient(value = "shop-user", fallback = UserServiceFallback.class) //用于指定调用nacos下的哪个微服务
public interface UserService {

    /**
     * 指定调用微服务的方法
     *
     * @param id
     * @return
     */
    @RequestMapping("/user/{id}")
    User getByID(@PathVariable("id") Integer id);

}
