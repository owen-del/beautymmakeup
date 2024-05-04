package com.service.impl;

import com.entity.Goods;
import com.response.ResponseResult;
import com.service.GoodsService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;


@Service("com.service.impl.GoodsServiceImpl")
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Goods> findByNameLike(String name) {
        AtomicReference<List<Goods>> listAtomicCategory = new AtomicReference<>();
        Session currentSession = sessionFactory.getCurrentSession();
        Optional.ofNullable(name).ifPresentOrElse(n -> {
            if (!"".equals(n)) {
                List<Goods> list = currentSession.createQuery("FROM Goods WHERE name LIKE CONCAT('%',:name,'%') ", Goods.class).setParameter("name", name).list();
                listAtomicCategory.set(list);
            }else {
                List<Goods> list = currentSession.createQuery("FROM Goods", Goods.class).list();
                listAtomicCategory.set(list);
            }
        }, ()->{
            List<Goods> list = currentSession.createQuery("FROM Goods", Goods.class).list();
            listAtomicCategory.set(list);
        });

        return listAtomicCategory.get();
    }

    @Override
    public void deleteById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Goods goods = currentSession.get(Goods.class, id);
        currentSession.delete(goods);
    }

    @Override
    public ResponseResult deleteBatch(Long[] ids) {
        Session currentSession = sessionFactory.getCurrentSession();
        for (Long id : ids) {
            Goods goods = currentSession.get(Goods.class, id);
            currentSession.delete(goods);
        }
        return ResponseResult.SUCCESS("批量删除成功。");
    }

    @Override
    public Goods findById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Goods goods = currentSession.get(Goods.class, id);
        return goods;
    }
}
