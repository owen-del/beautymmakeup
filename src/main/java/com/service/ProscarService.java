package com.service;

import com.entity.Proscar;
import com.entity.User;
import com.response.ResponseResult;

import java.util.List;

/**
 * 购物车
 */
public interface ProscarService {

    /**
     * 查询自己的购物车信息
     * @param user
     * @return
     */
    List<Proscar> findMyProscar(User user);

    void deleteById(Long id);

    ResponseResult numeric(Proscar proscar);

    /**
     * 购买
     * @param id id
     * @param addressId 地址
     * @param paytype 支付方式
     * @return
     */
    ResponseResult diamond(Long id,Long addressId,String paytype);

}
