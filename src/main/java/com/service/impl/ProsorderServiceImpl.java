package com.service.impl;

import com.entity.Category;
import com.entity.Prosorder;
import com.entity.User;
import com.service.ProsorderService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;


@Service("com.service.impl.ProsorderServiceImpl")
public class ProsorderServiceImpl implements ProsorderService {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Prosorder> findLikeByOrderno(String orderno) {
        AtomicReference<List<Prosorder>> listAtomicCategory = new AtomicReference<>();
        Session currentSession = sessionFactory.getCurrentSession();
        Optional.ofNullable(orderno).ifPresentOrElse(o -> {
            if (!"".equals(o)) {
                List<Prosorder> list = currentSession.createQuery("FROM Prosorder WHERE orderno LIKE CONCAT('%',:orderno,'%') ", Prosorder.class).setParameter("orderno", o).list();
                listAtomicCategory.set(list);
            }else {
                List<Prosorder> list = currentSession.createQuery("FROM Prosorder", Prosorder.class).list();
                listAtomicCategory.set(list);
            }
        }, ()->{
            List<Prosorder> list = currentSession.createQuery("FROM Prosorder", Prosorder.class).list();
            listAtomicCategory.set(list);
        });

        return listAtomicCategory.get();
    }

    @Override
    public List<Prosorder> findLikeByOrderno(User user, String orderno) {
        if ("管理员".equals(user.getType())) {
            List<Prosorder> likeByOrderno = findLikeByOrderno(orderno);
            return likeByOrderno.stream().filter(p -> "已签收".equals(p.getFshstatus())).collect(Collectors.toList());
        }else {
            AtomicReference<List<Prosorder>> listAtomicCategory = new AtomicReference<>();
            Session currentSession = sessionFactory.getCurrentSession();
            Optional.ofNullable(orderno).ifPresentOrElse(o -> {
                if (!"".equals(o)) {
                    List<Prosorder> list = currentSession.createQuery("FROM Prosorder WHERE fshstatus = '已签收' AND sysuserkey = :uid AND orderno LIKE CONCAT('%',:orderno,'%') ", Prosorder.class)
                            .setParameter("uid", user.getId())
                            .setParameter("orderno", o).list();
                    listAtomicCategory.set(list);
                }else {
                    List<Prosorder> list = currentSession.createQuery("FROM Prosorder WHERE fshstatus = '已签收' AND sysuserkey = :uid ", Prosorder.class).setParameter("uid", user.getId()).list();
                    listAtomicCategory.set(list);
                }
            }, ()->{
                List<Prosorder> list = currentSession.createQuery("FROM Prosorder WHERE fshstatus = '已签收' AND sysuserkey = :uid ", Prosorder.class).setParameter("uid", user.getId()).list();
                listAtomicCategory.set(list);
            });

            return listAtomicCategory.get();
        }
    }

    @Override
    public Prosorder findById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Prosorder prosorder = currentSession.get(Prosorder.class, id);
        return prosorder;
    }
}
