package com.cn.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author ChenZZ
 * @Date 2021/12/23 20:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 商品类型
     */
    private String pType;

    /**
     * 商品名称
     */
    private String pName;

    /**
     * 商品价格
     */
    private String pPrice;

    /**
     * 库存量
     */
    private Integer stock;

    /**
     * 创建时间
     */
    private String cTime;

    /**
     * 更新时间
     */
    private String upTime;

    /**
     * 备用字段
     */
    private Integer spare;
}

