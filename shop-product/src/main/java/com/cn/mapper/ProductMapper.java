package com.cn.mapper;

import com.cn.domain.Product;

/**
 * @Author ChenZZ
 * @Date 2021/12/28 10:16
 * 商品持久层接口
 */
public interface ProductMapper {

    /**
     * 新增商品信息
     *
     * @param product
     * @return
     */
    int insertDynamic(Product product);

    /**
     * 查询商品信息
     * @param id
     * @return
     */
    Product selectById(Integer id);

    /**
     * 更新商品信息
     * @param product
     * @return
     */
    int updateDynamic(Product product);
}
