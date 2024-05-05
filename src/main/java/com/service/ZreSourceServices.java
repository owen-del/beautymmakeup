package com.service;

import com.entity.ZreSources;
import com.response.ResponseResult;

import java.util.List;

/**
 * 站内咨询模块
 */
public interface ZreSourceServices {

    List<ZreSources> findLikeTitle(String title);


    List<ZreSources> findAll();

    void deleteById(Long id);

    ResponseResult deleteBatch(Long [] ids);

    ZreSources findById(Long id);


    void saveOrUpdate(ZreSources zreSources, Long ztypeid);

}
