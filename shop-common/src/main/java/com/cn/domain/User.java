package com.cn.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @Author ChenZZ
 * @Date 2021/12/23 18:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String paWord;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 创建时间
     */
    private String cTime;

    /**
     * 更新时间
     */
    private String upTime;

    /**
     * 级别
     */
    private Integer levelUser;

    /**
     * 备用字段
     */
    private String spare;

    /**
     * 是否展示；1展示；0删除
     */
    private Integer display;
}
