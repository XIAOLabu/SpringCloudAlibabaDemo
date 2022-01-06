package com.cn.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ChenZZ
 * @Date 2021/12/13 10:53
 */
@RestController
public class SentinelHelloWorld {

    @RequestMapping("helloWorld")
    @ResponseBody
    @SentinelResource(value = "helloWorld1", blockHandler = "blockHandlerForHelloWorld1")
    public String helloWorld() {
        return "Sentinel 没有操作" + System.currentTimeMillis();
    }

    @SentinelResource(value = "helloWorld2", blockHandler = "blockHandlerForHelloWorld2")
    @RequestMapping("helloWorld2")
    public String helloWorld2() {
        return "Sentinel 大爷你好！by 注解方式@SentinelResource" + System.currentTimeMillis();
    }

    /**
     * 原方法调用被限流/降级/系统保护的时候调用
     *
     * @param ex
     * @return
     */
    public String blockHandlerForHelloWorld2(BlockException ex) {
        ex.printStackTrace();
        return "helloWorld2——系统繁忙，请稍后！";
    }

    /**
     * 原方法调用被限流/降级/系统保护的时候调用
     *
     * @param ex
     * @return
     */
    public String blockHandlerForHelloWorld1(BlockException ex) {
        ex.printStackTrace();
        return "helloWorld1——系统繁忙，请稍后！";
    }

}
