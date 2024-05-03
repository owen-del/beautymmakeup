package com.service;

import com.entity.User;

/**
 * 用户服务
 */
public interface UserService {

    User findUserByAccountAndPassword(String account, String password);

}
