package com.cn.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.cn.domain.User;
import com.cn.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author ChenZZ
 * @Date 2021/12/27 17:19
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @Resource
    UserService userService;

    @GetMapping("{id}")
    @SentinelResource(value = "getUser", blockHandler = "blockHandlerUser")
    @ResponseBody
    public User hello(@PathVariable("id") Integer id){
        log.info("接收到{}号用户信息查询的请求~", id);
        User user = userService.selectById(id);
        log.info("查询到{}ID账号信息为{}", id, JSON.toJSONString(user));
        if (user == null){
            return null;
        }else{
            return user;
        }

    }

    /**
     * 原方法调用被限流/降级/系统保护的时候调用
     * @param ex
     * @return
     */
    @ResponseBody
    public static User blockHandlerUser(Integer id, BlockException ex){
        ex.printStackTrace();
        log.error("系统繁忙，请稍后再进行查询！");
        return null;
    }
}
