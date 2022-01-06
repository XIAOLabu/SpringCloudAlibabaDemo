package com.cn.service.serviceImpl;

import com.cn.domain.Product;
import com.cn.mapper.ProductMapper;
import com.cn.service.ProductService;
import com.cn.utils.DateTimeUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author ChenZZ
 * @Date 2021/12/28 10:18
 * 商品服务层实现类
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    ProductMapper productMapper;

    //新增商品信息
    public int insertDynamic(Product product) {
        product.setCTime(DateTimeUtils.getCurrentTime());
        product.setUpTime(DateTimeUtils.getCurrentTime());
        return productMapper.insertDynamic(product);
    }

    //查询商品
    public Product selectById(Integer id) {
        return productMapper.selectById(id);
    }

    //更新商品
    public int updateDynamic(Product product) {
        product.setUpTime(DateTimeUtils.getCurrentTime());
        return productMapper.updateDynamic(product);
    }
}
