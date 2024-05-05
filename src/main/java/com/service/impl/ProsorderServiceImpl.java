package com.service.impl;

import com.entity.Category;
import com.entity.Prosorder;
import com.entity.User;
import com.response.ResponseResult;
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
    public List<Prosorder> findLikeByOrderno(User user, List<String> fshstatus, String orderno) {
        if ("管理员".equals(user.getType())) {
            List<Prosorder> likeByOrderno = findLikeByOrderno(orderno);
            return likeByOrderno.stream().filter(p -> fshstatus.contains(p.getFshstatus())).collect(Collectors.toList());
        }else {
            AtomicReference<List<Prosorder>> listAtomicCategory = new AtomicReference<>();
            Session currentSession = sessionFactory.getCurrentSession();
            Optional.ofNullable(orderno).ifPresentOrElse(o -> {
                if (!"".equals(o)) {
                    List<Prosorder> list = currentSession.createQuery("FROM Prosorder WHERE sysuserkey = :uid AND orderno LIKE CONCAT('%',:orderno,'%') ", Prosorder.class)
                            .setParameter("uid", user.getId())
                            .setParameter("orderno", o).list();
                    listAtomicCategory.set(list);
                }else {
                    List<Prosorder> list = currentSession.createQuery("FROM Prosorder WHERE sysuserkey = :uid ", Prosorder.class)
                            .setParameter("uid", user.getId()).list();
                    listAtomicCategory.set(list);
                }
            }, ()->{
                List<Prosorder> list = currentSession.createQuery("FROM Prosorder WHERE fshstatus = :fshstatus AND sysuserkey = :uid ", Prosorder.class)
                        .setParameter("uid", user.getId()).list();
                listAtomicCategory.set(list);
            });

            return listAtomicCategory.get().stream().filter(p -> fshstatus.contains(p.getFshstatus())).collect(Collectors.toList());
        }
    }

    @Override
    public Prosorder findById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Prosorder prosorder = currentSession.get(Prosorder.class, id);
        return prosorder;
    }

    @Override
    public ResponseResult waitAcceptancehandle(Prosorder prosorder) {
        Prosorder old = findById(prosorder.getId());
        old.setFgname(prosorder.getFgname());
        old.setFshremo(prosorder.getFshremo());
        old.setFshstatus(prosorder.getFshstatus());
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(old);
        return ResponseResult.SUCCESS("处理完成。");
    }

    @Override
    public ResponseResult sellSign(Prosorder prosorder) {
        Prosorder old = findById(prosorder.getId());
        old.setSshscore(prosorder.getSshscore());
        old.setSshremo(prosorder.getSshremo());
        old.setFshstatus("已签收");
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(old);
        return ResponseResult.SUCCESS("签收完成");
    }

    @Override
    public void sellCancel(Long id) {
        Prosorder old = findById(id);
        old.setFshstatus("已取消");
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(old);
    }
}
