package com.service;

import com.entity.User;
import com.response.ResponseResult;

/**
 * 用户服务
 */
public interface UserService {

    User findUserByAccountAndPassword(String account, String password);

    /**
     * 注册新用户
     * @param user
     * @return
     */
    ResponseResult save(User user);

}
