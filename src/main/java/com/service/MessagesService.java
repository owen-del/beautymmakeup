package com.service;

import com.entity.Messages;
import com.response.ResponseResult;

import java.util.List;

/**
 * 留言
 */
public interface MessagesService {

    List<Messages> findByContLike(String cont);

    List<Messages> findAll();
    void deleteById(Long id);

    ResponseResult deleteBatch(Long [] ids);

    ResponseResult reply(Messages messages);

    /**
     * 添加留言板信息
     * @param messages
     */
    void save(Messages messages);

}
