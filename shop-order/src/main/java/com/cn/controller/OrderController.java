package com.cn.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.cn.domain.Order;
import com.cn.domain.Product;
import com.cn.domain.User;
import com.cn.service.OrderService;
import com.cn.service.ProductService;
import com.cn.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @Author ChenZZ
 * @Date 2021/12/28 10:37
 */
@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private ProductService productService;

    @Resource
    private UserService userService;

    /**
     * 创建订单
     *
     * @param pId
     * @param pNumber
     * @return
     */
    @RequestMapping("{pId}/{pNumber}")
    public Order createOrder(@PathVariable("pId") Integer pId, @PathVariable("pNumber") Integer pNumber) {
        Order order = new Order();
        log.info("接收到{}号商品的下单请求,购买数量为{},接下来调用商品微服务查询此商品信息", pId, pNumber);
        //查询商品信息
        Product product = productService.findById(pId);
        log.info("查询到{}号商品信息为{}", pId, JSON.toJSONString(product));
        if (product.getId() == -100) {
            order.setPName(product.getPName());
            return order;
        }
        //随机生成购买账户ID
        Random r = new Random();
        int userId = r.nextInt(5) + 1;
        User user = userService.getByID(userId);
        log.info("查询到{}ID账号信息为{}", userId, JSON.toJSONString(user));
        if (user.getId() == -100) {
            order.setPName(null);
            order.setUserName(user.getUserName());
            return order;
        }
        //------下单----------
        //用户标识
        order.setUserId(userId);
        //用户账号名称
        order.setUserName(user.getUserName());
        //商品ID
        order.setPId(pId);
        //商品名称
        order.setPName(product.getPName());
        //商品数量
        order.setPNumber(pNumber);
        //商品单价
        order.setPPrice(product.getPPrice());
        Order orderNew = orderService.insertDynamic(order);
        if (orderNew != null) {
            log.info("创建订单成功,订单信息为{}", JSON.toJSONString(orderNew));
            return orderNew;
        } else {
            return null;
        }
    }

    @GetMapping("test/{msg}")
    @SentinelResource(value = "helloWorld2", blockHandler = "blockHandlerForHelloWorld2")
    @ResponseBody
    public String hello(@PathVariable("msg") String msg) {
        System.out.println("run ~ order" + msg);
        return msg;
    }

    /**
     * 原方法调用被限流/降级/系统保护的时候调用
     *
     * @param ex
     * @return
     */
    public String blockHandlerForHelloWorld2(String msg, BlockException ex) throws Exception {
        ex.printStackTrace();
        System.out.println(ex);
        return "test";
    }


    /**
     * 三种方式调用微服务接口
     */
//     Product product = restTemplate.getForObject("http://shop-product/product/" + pId, Product.class);

//    List<ServiceInstance> instances = discoveryClient.getInstances("shop-product");
//    int index = new Random().nextInt(instances.size());
//    ServiceInstance serviceInstance = instances.get(index);
//    Product product = restTemplate.getForObject("http://"+ serviceInstance.getHost()+":"+ serviceInstance.getPort()+"/product/" + pId, Product.class);

//    Product product = restTemplate.getForObject("http://localhost:7037/product/" + pId, Product.class);

}
