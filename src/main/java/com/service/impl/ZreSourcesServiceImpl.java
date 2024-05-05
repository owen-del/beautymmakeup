package com.service.impl;

import com.entity.User;
import com.entity.ZrType;
import com.entity.ZreSources;
import com.response.ResponseResult;
import com.service.ZreSourceServices;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service("com.service.impl.ZreSourcesServiceImpl")
public class ZreSourcesServiceImpl implements ZreSourceServices {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ZreSources> findLikeTitle(String title) {
        AtomicReference<List<ZreSources>> listAtomicCategory = new AtomicReference<>();
        Session currentSession = sessionFactory.getCurrentSession();
        Optional.ofNullable(title).ifPresentOrElse(t -> {
            if (!"".equals(t)) {
                List<ZreSources> list = currentSession.createQuery("FROM ZreSources WHERE title LIKE CONCAT('%',:title,'%') ", ZreSources.class).setParameter("title", t).list();
                listAtomicCategory.set(list);
            } else {
                List<ZreSources> list = currentSession.createQuery("FROM ZreSources", ZreSources.class).list();
                listAtomicCategory.set(list);
            }
        }, () -> {
            List<ZreSources> list = currentSession.createQuery("FROM ZreSources", ZreSources.class).list();
            listAtomicCategory.set(list);
        });
        return listAtomicCategory.get();
    }

    @Override
    public List<ZreSources> findAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        List<ZreSources> list = currentSession.createQuery("FROM ZreSources ", ZreSources.class).list();
        return list;
    }

    @Override
    public void deleteById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        ZreSources zreSources = currentSession.get(ZreSources.class, id);
        currentSession.delete(zreSources);
    }

    @Override
    public ResponseResult deleteBatch(Long[] ids) {
        Session currentSession = sessionFactory.getCurrentSession();
        for (Long id : ids) {
            ZreSources zreSources = currentSession.get(ZreSources.class, id);
            currentSession.delete(zreSources);
        }
        return ResponseResult.SUCCESS("批量删除成功。");
    }

    @Override
    public ZreSources findById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        ZreSources zreSources = currentSession.get(ZreSources.class, id);
        return zreSources;
    }

    @Override
    public void saveOrUpdate(ZreSources zreSources, Long ztypeid) {
        Session session = sessionFactory.getCurrentSession();
        ZrType zrType = session.get(ZrType.class, ztypeid);
        zreSources.setZrType(zrType);
        zreSources.setCreateTime(new Date());

        session.saveOrUpdate(zreSources);
    }
}
