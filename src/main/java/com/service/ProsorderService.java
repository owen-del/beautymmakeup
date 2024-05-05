package com.service;

import com.entity.Prosorder;
import com.entity.User;
import com.response.ResponseResult;

import java.util.List;

/**
 * 历史订单
 */
public interface ProsorderService {

    List<Prosorder> findLikeByOrderno(String orderno);

    List<Prosorder> findLikeByOrderno(User user, List<String> fshstatus, String orderno);

    Prosorder findById(Long id);

    ResponseResult waitAcceptancehandle(Prosorder prosorder);

}
