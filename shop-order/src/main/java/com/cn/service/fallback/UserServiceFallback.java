package com.cn.service.fallback;

import com.cn.domain.Product;
import com.cn.domain.User;
import com.cn.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author ChenZZ
 * @Date 2022/1/4 14:32
 */
@Service
@Slf4j
public class UserServiceFallback implements UserService {

    @Override
    public User getByID(Integer id) {
        log.error("查询{}号用户出现异常,远程调用用户微服务出现异常进入容错逻辑", id);
        //错误逻辑
        User user = new User();
        user.setId(-100);
        user.setUserName("调用用户微服务接口失败~");
        return user;
    }
}
