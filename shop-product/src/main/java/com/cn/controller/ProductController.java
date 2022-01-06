package com.cn.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.cn.domain.Product;
import com.cn.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author ChenZZ
 * @Date 2021/12/28 10:17
 */
@RestController
@RequestMapping("product")
@Slf4j
public class ProductController {

    @Resource
    ProductService productService;


    @GetMapping("test/{msg}")
    @SentinelResource(value = "getByProductTest", blockHandler = "getProductBlock")
    public String hello(@PathVariable("msg") String msg) {
        System.out.println("run~ product ~" + msg);
        Product product = productService.selectById(Integer.parseInt(msg));
        if (product == null) {
            return "该ID查询不到商品" + msg;
        } else {
            return msg + "ID商品信息为：" + product;
        }
    }


    @ResponseBody
    @GetMapping("{pId}")
    @SentinelResource(value = "getByProduct", blockHandler = "getProductBlockInteger")
    public Product getProduct(@PathVariable("pId") Integer id) {
        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", id);
        Product product = productService.selectById(id);
        log.info("查询到{}号商品信息为{}", id, JSON.toJSONString(product));
        return product;
    }

    public String getProductBlock(String pId, BlockException ex) {
        System.out.println("查询失败的商品ID为：" + pId);
        String message = "当前系统繁忙，请稍后重试~";
        System.out.println(message);
        return message;
    }

    public Product getProductBlockInteger(Integer pId, BlockException ex) {
        System.out.println("查询失败的商品ID为：" + pId);
        String message = "当前系统繁忙，请稍后重试~";
        System.out.println(message);
        return null;
    }
}
