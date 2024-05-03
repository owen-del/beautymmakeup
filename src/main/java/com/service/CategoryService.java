package com.service;

import com.entity.Category;
import com.response.ResponseResult;

import java.util.List;

/**
 * 类别服务
 */
public interface CategoryService {

    List<Category> findLikeName(String name);

    /**
     * 通过id删除数据
     * @param id
     */
    void deleteById(Long id);

    ResponseResult deleteBatch(Long[] ids);

    Category findById(Long id);

    void saveOrUpdate(Category category);

}
