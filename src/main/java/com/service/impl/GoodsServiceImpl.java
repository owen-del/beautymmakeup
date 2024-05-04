package com.service.impl;

import com.entity.Goods;
import com.entity.User;
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
    public List<Goods> findByNameLike(User loginUser, String name) {
        AtomicReference<List<Goods>> listAtomicCategory = new AtomicReference<>();
        Session currentSession = sessionFactory.getCurrentSession();
        if ("管理员".equals(loginUser.getType())) {
            Optional.ofNullable(name).ifPresentOrElse(n -> {
                if (!"".equals(n)) {
                    List<Goods> list = currentSession.createQuery("FROM Goods WHERE name LIKE CONCAT('%',:name,'%') ", Goods.class).setParameter("name", name).list();
                    listAtomicCategory.set(list);
                } else {
                    List<Goods> list = currentSession.createQuery("FROM Goods", Goods.class).list();
                    listAtomicCategory.set(list);
                }
            }, () -> {
                List<Goods> list = currentSession.createQuery("FROM Goods", Goods.class).list();
                listAtomicCategory.set(list);
            });
        }else {
            Optional.ofNullable(name).ifPresentOrElse(n -> {
                if (!"".equals(n)) {
                    List<Goods> list = currentSession.createQuery("FROM Goods WHERE user.id = :uid AND  name LIKE CONCAT('%',:name,'%') ", Goods.class)
                            .setParameter("uid", loginUser.getId())
                            .setParameter("name", name).list();
                    listAtomicCategory.set(list);
                } else {
                    List<Goods> list = currentSession.createQuery("FROM Goods WHERE user.id = :uid ", Goods.class).setParameter("uid", loginUser.getId()).list();
                    listAtomicCategory.set(list);
                }
            }, () -> {
                List<Goods> list = currentSession.createQuery("FROM Goods WHERE user.id = :uid ", Goods.class).setParameter("uid", loginUser.getId()).list();
                listAtomicCategory.set(list);
            });
        }

        return listAtomicCategory.get();
    }

    @Override
    public void deleteById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Goods goods = currentSession.get(Goods.class, id);
        currentSession.delete(goods);
    }

    @Override
    public void lockOrUpGoods(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Goods goods = currentSession.get(Goods.class, id);
        goods.setStatus("上架".equals(goods.getStatus()) ? "下架" : "上架");
        currentSession.update(goods);
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

    @Override
    public void saveOrUpdate(Goods goods) {
        Session currentSession = sessionFactory.getCurrentSession();
        if (goods.getId() != null) {
            currentSession.merge(goods);
        }else {
            currentSession.save(goods);
        }
    }
}
