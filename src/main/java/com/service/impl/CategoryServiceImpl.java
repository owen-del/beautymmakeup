package com.service.impl;

import com.entity.Category;
import com.response.ResponseResult;
import com.service.CategoryService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service("com.service.impl.CategoryServiceImpl")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Category> findLikeName(String name) {

        AtomicReference<List<Category>> listAtomicCategory = new AtomicReference<>();
        Session currentSession = sessionFactory.getCurrentSession();
        Optional.ofNullable(name).ifPresentOrElse(n -> {
            if (!"".equals(n)) {
                List<Category> list = currentSession.createQuery("FROM Category WHERE name LIKE CONCAT('%',:name,'%') ", Category.class).setParameter("name", name).list();
                listAtomicCategory.set(list);
            }else {
                List<Category> list = currentSession.createQuery("FROM Category", Category.class).list();
                listAtomicCategory.set(list);
            }
        }, ()->{
            List<Category> list = currentSession.createQuery("FROM Category", Category.class).list();
            listAtomicCategory.set(list);
        });

        return listAtomicCategory.get();
    }

    @Override
    public void deleteById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Category category = currentSession.get(Category.class, id);
        currentSession.delete(category);
    }

    @Override
    public ResponseResult deleteBatch(Long[] ids) {
        Session currentSession = sessionFactory.getCurrentSession();
        for (Long id : ids) {
            Category category = currentSession.get(Category.class, id);
            currentSession.delete(category);
        }
        return ResponseResult.SUCCESS("批量删除成功");
    }

    @Override
    public Category findById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Category category = currentSession.get(Category.class, id);
        return category;
    }

    @Override
    public void saveOrUpdate(Category category) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(category);
    }
}
