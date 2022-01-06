package com.cn.service.serviceImpl;

import com.cn.domain.Order;
import com.cn.mapper.OrderMapper;
import com.cn.service.OrderService;
import com.cn.utils.DateTimeUtils;
import com.cn.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author ChenZZ
 * @Date 2021/12/28 10:37
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    //新增订单
    public Order insertDynamic(Order order) {
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
        order.setOrderId(DateTimeUtils.getDateByStringNew() + idWorker.nextId());
        order.setPayOrderId(DateTimeUtils.getCurrentTimeNew() + DateTimeUtils.getSystemTime());
        order.setCTime(DateTimeUtils.getCurrentTime());
        order.setUpTime(DateTimeUtils.getCurrentTime());
        int row = orderMapper.insertDynamic(order);
        if (row > 0) {
            return order;
        } else {
            return null;
        }
    }

    //查询订单详情
    public Order selectByOrderId(String orderId) {
        return orderMapper.selectByOrderId(orderId);
    }

    //查询订单列表
    public List<Order> findPageWithResult(Order order) {
        order.setStart(0);
        order.setPageSize(10);
        return orderMapper.findPageWithResult(order);
    }
}
