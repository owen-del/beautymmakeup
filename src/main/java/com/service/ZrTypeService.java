package com.service;

import com.entity.ZrType;
import com.response.ResponseResult;

import java.util.List;

public interface ZrTypeService {

    List<ZrType> findLikeName(String name);

    ZrType findById(Long id);

    void saveOrUpdate(ZrType zrType);

    void deleteById(Long id);

    ResponseResult deleteBatch(Long[] ids);

}
