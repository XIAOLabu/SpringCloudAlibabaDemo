package com.cn.mapper;

import com.cn.domain.Order;

import java.util.List;

/**
 * @Author ChenZZ
 * @Date 2021/12/28 10:37
 */
public interface OrderMapper {

    /**
     * 新增订单
     * @param order
     * @return
     */
    int insertDynamic(Order order);

    /**
     * 查询订单
     * @param orderId
     * @return
     */
    Order selectByOrderId(String orderId);

    /**
     * 查询订单列表
     * @param Order
     * @return
     */
    List<Order> findPageWithResult(Order order);

}
