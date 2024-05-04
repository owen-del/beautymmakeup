package com.service;

import com.entity.FriendshipLink;
import com.response.ResponseResult;

import java.util.List;

/**
 * 友情链接
 */
public interface FriendshipLinkService {

    List<FriendshipLink> findByNameLike(String name);

    FriendshipLink findById(Long id);

    void deleteById(Long id);

    ResponseResult deleteBatch(Long [] ids);

    void saveOrUpdate(FriendshipLink friendshipLink);

}
