package com.cn.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

/**
 * @Author ChenZZ
 * @Date 2021/12/23 20:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order extends Common implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 业务订单号
     */
    private String orderId;

    /**
     * 交易订单号
     */
    private String payOrderId;

    /**
     * 用户标识
     */
    private Integer userId;

    /**
     * 用户账户名称
     */
    private String userName;

    /**
     * 产品名称
     */
    private String pName;

    /**
     * 产品价格
     */
    private String pPrice;

    /**
     * 产品数量
     */
    private Integer pNumber;

    /**
     * 产品id
     */
    private Integer pId;

    /**
     * 创建时间
     */
    private String cTime;

    /**
     * 更新时间
     */
    private String upTime;

    /**
     * 取消时间
     */
    private String outTime;

    /**
     * 备用字段
     */
    private String spare;
}
