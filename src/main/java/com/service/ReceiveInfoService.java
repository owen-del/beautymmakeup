package com.service;

import com.entity.ReceiveInfo;
import com.response.ResponseResult;

import java.util.List;

public interface ReceiveInfoService {

    List<ReceiveInfo> findMyByNameLike(Long uid,String name);

    ReceiveInfo findById(Long id);

    void deleteById(Long id);

    ResponseResult deleteBatch(Long[] ids);

    void saveOrUpdate(ReceiveInfo receiveInfo);

}
