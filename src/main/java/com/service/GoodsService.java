package com.service;

import com.entity.Goods;
import com.response.ResponseResult;

import java.util.List;

/**
 * 商品服务
 */
public interface GoodsService {

    List<Goods> findByNameLike(String name);

    void deleteById(Long id);

    ResponseResult deleteBatch(Long [] ids);

    Goods findById(Long id);

}
