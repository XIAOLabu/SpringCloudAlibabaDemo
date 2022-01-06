package com.cn.service.serviceImpl;

import com.cn.domain.User;
import com.cn.mapper.UserMapper;
import com.cn.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author ChenZZ
 * @Date 2021/12/27 17:21
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public Integer insertSelective(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> selectList(Map<String, Integer> map) {
        return userMapper.selectList(map);
    }
}
