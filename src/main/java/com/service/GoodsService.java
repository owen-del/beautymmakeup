package com.service;

import com.entity.Goods;
import com.entity.User;
import com.response.ResponseResult;

import java.util.List;

/**
 * 商品服务
 */
public interface GoodsService {

    List<Goods> findByNameLike(User user, String name);

    void deleteById(Long id);

    void lockOrUpGoods(Long id);

    ResponseResult deleteBatch(Long [] ids);

    Goods findById(Long id);

    void saveOrUpdate(Goods goods);

}
