package com.cn.service;

import com.cn.domain.Product;

/**
 * @Author ChenZZ
 * @Date 2021/12/28 10:17
 * 商品服务层接口
 */
public interface ProductService {
    /**
     * 新增商品信息
     *
     * @param product
     * @return
     */
    int insertDynamic(Product product);

    /**
     * 查询商品信息
     *
     * @param id
     * @return
     */
    Product selectById(Integer id);

    /**
     * 更新商品信息
     *
     * @param product
     * @return
     */
    int updateDynamic(Product product);
}
