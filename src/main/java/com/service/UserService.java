package com.service;

import com.entity.User;
import com.response.ResponseResult;

import java.util.List;

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

    List<User> findLikeName(String name);

    void deleteById(Long id);

    ResponseResult deleteBatch(Long [] ids);

    void lockOrOpen(Long id);

    /**
     * 批量锁定和解锁用户
     * @param ids
     * @param status 1：锁定；0：解锁
     * @return
     */
    ResponseResult lockOrOpenBatch(Long[] ids, Integer status);


    User findById(Long id);

    void saveOrUpdate(User user);

    /**
     * 重置密码
     * @param id
     * @param password
     * @param rePassword
     * @return
     */
    ResponseResult resetPassword(Long id, String password, String rePassword);

}
