package com.cn.mapper;

import com.cn.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @Author ChenZZ
 * @Date 2021/12/27 17:20
 */
public interface UserMapper {
    /**
     * 新增用户
     *
     * @param User
     * @return
     */
    Integer insertSelective(User User);

    /**
     * 查询单个用户
     *
     * @param id
     * @return
     */
    User selectById(Integer id);

    /**
     * 查询用户列表
     *
     * @param map
     * @return
     */
    List<User> selectList(Map<String, Integer> map);

}
