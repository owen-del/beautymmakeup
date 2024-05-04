package com.service;

import com.entity.MixInfo;

import java.util.List;

public interface MixInfoService {

    /**
     * 滚动图片
     * @param title
     * @return
     */
    List<MixInfo> findRollingImgLikeTitle(String title);


    MixInfo findById(Long id);

    void saveOrUpdate(MixInfo mixInfo);

}
