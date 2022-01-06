package com.cn.service.fallback;

import com.cn.domain.Product;
import com.cn.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author ChenZZ
 * @Date 2021/12/30 15:51
 * 这是一个容错类。需要实现Fegin所在的接口，并实现接口中的所有方法
 * 一旦Fegin远程调用失败，机会进入当前类中的同方法，执行容错逻辑
 */
@Service
@Slf4j
public class ProductServiceFallback implements ProductService {
    @Override
    public Product findById(Integer pId) {
        log.error("查询{}号商品出现异常,远程调用商品微服务出现异常进入容错逻辑", pId);
        //错误逻辑
        Product product = new Product();
        product.setId(-100);
        product.setPName("远程调用商品微服务出现异常，进入容错逻辑");
        return product;
    }
}
