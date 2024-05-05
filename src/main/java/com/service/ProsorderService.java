package com.service;

import com.entity.Prosorder;
import com.entity.User;

import java.util.List;

/**
 * 历史订单
 */
public interface ProsorderService {

    List<Prosorder> findLikeByOrderno(String orderno);

    List<Prosorder> findLikeByOrderno(User user, String orderno);


    Prosorder findById(Long id);

}
