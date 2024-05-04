package com.service;

import com.entity.Prosorder;

import java.util.List;

/**
 * 历史订单
 */
public interface ProsorderService {

    List<Prosorder> findLikeByOrderno(String orderno);


    Prosorder findById(Long id);

}
