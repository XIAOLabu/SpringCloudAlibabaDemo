package com.cn.service;

import com.cn.domain.Order;

import java.util.List;

/**
 * @Author ChenZZ
 * @Date 2021/12/28 10:36
 */
public interface OrderService {

    /**
     * 新增订单
     * @param order
     * @return
     */
    Order insertDynamic(Order order);

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
    List<Order> findPageWithResult(Order Order);
}
