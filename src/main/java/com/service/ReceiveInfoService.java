package com.service;

import com.entity.ReceiveInfo;
import com.entity.User;
import com.response.ResponseResult;

import java.util.List;

public interface ReceiveInfoService {

    List<ReceiveInfo> findMyByNameLike(Long uid,String name);

    ReceiveInfo findById(Long id);

    void deleteById(Long id);

    ResponseResult deleteBatch(Long[] ids);

    void saveOrUpdate(ReceiveInfo receiveInfo);

    /**
     * 加入购物车
     * @param id 商品id
     * @param loginUser 用户id
     * @return
     */
    ResponseResult addCat(Long id, User loginUser);

}
