package com.service.impl;

import com.entity.Category;
import com.entity.MixInfo;
import com.service.MixInfoService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service("com.service.impl.MixInfoServiceImpl")
public class MixInfoServiceImpl implements MixInfoService {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<MixInfo> findRollingImgLikeTitle(String title) {
        AtomicReference<List<MixInfo>> listAtomicCategory = new AtomicReference<>();
        Session currentSession = sessionFactory.getCurrentSession();
        Optional.ofNullable(title).ifPresentOrElse(t -> {
            if (!"".equals(t)) {
                List<MixInfo> list = currentSession.createQuery("FROM MixInfo WHERE infoType = '滚动图片' AND title LIKE CONCAT('%',:title,'%') ", MixInfo.class).setParameter("title", t).list();
                listAtomicCategory.set(list);
            }else {
                List<MixInfo> list = currentSession.createQuery("FROM MixInfo WHERE infoType = '滚动图片' ", MixInfo.class).list();
                listAtomicCategory.set(list);
            }
        }, ()->{
            List<MixInfo> list = currentSession.createQuery("FROM MixInfo WHERE infoType = '滚动图片' ", MixInfo.class).list();
            listAtomicCategory.set(list);
        });

        return listAtomicCategory.get();
    }


    @Override
    public MixInfo findById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        MixInfo mixInfo = currentSession.get(MixInfo.class, id);
        return mixInfo;
    }

    @Override
    public void saveOrUpdate(MixInfo mixInfo) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(mixInfo);
    }
}
