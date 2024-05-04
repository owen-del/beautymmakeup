package com.service.impl;

import com.entity.User;
import com.response.ResponseResult;
import com.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service("com.service.impl.UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findUserByAccountAndPassword(String account, String password) {
        // 通过账号和密码查询用户信息
        // *请不要使用openSession，因为openSession会每次创建新的session且不会自动关闭，会消耗系统资源*
        Session currentSession = sessionFactory.getCurrentSession();
        User user = currentSession
                .createQuery("from User where account = :account and password = :password", User.class).
                setParameter("account", account)
                .setParameter("password", password).uniqueResult();
        return user;
    }

    @Override
    public ResponseResult save(User user) {
        user.setStatus("正常");
        user.setCreateTime(new Date());
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(user);
        return ResponseResult.SUCCESS("注册成功");
    }

    @Override
    public List<User> findLikeName(String name) {
        AtomicReference<List<User>> listAtomicCategory = new AtomicReference<>();
        Session currentSession = sessionFactory.getCurrentSession();
        Optional.ofNullable(name).ifPresentOrElse(n -> {
            if (!"".equals(n)) {
                List<User> list = currentSession.createQuery("FROM User WHERE name LIKE CONCAT('%',:name,'%') ", User.class).setParameter("name", name).list();
                listAtomicCategory.set(list);
            }else {
                List<User> list = currentSession.createQuery("FROM User", User.class).list();
                listAtomicCategory.set(list);
            }
        }, ()->{
            List<User> list = currentSession.createQuery("FROM User", User.class).list();
            listAtomicCategory.set(list);
        });
        return listAtomicCategory.get();
    }

    @Override
    public void deleteById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        User user = currentSession.get(User.class, id);
        currentSession.delete(user);
    }

    @Override
    public ResponseResult deleteBatch(Long[] ids) {
        Session currentSession = sessionFactory.getCurrentSession();
        for (Long id : ids) {
            User user = currentSession.get(User.class, id);
            currentSession.delete(user);
        }
        return ResponseResult.SUCCESS("批量删除成功。");
    }


    @Override
    public void lockOrOpen(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        User user = currentSession.get(User.class, id);
        user.setStatus("正常".equals(user.getStatus()) ? "锁定" : "正常");
        currentSession.update(user);
    }

    /**
     * 批量解锁或锁定用户
     * @param ids
     * @param status 1：锁定；0：解锁
     * @return
     */
    @Override
    public ResponseResult lockOrOpenBatch(Long[] ids, Integer status) {
        String s = status == 0 ? "正常" : "锁定";
        Session currentSession = sessionFactory.getCurrentSession();
        for (Long id : ids) {
            User user = currentSession.get(User.class, id);
            user.setStatus(s);
            currentSession.update(user);
        }
        return ResponseResult.SUCCESS(String.format("批量%s成功", s));
    }

    @Override
    public User findById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        User user = currentSession.get(User.class, id);
        return user;
    }

    @Override
    public void saveOrUpdate(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        // 修改时不修改入库时间和状态
        if (user.getId() != null) {
            User oldUser = currentSession.get(User.class, user.getId());
            user.setCreateTime(oldUser.getCreateTime());
            user.setStatus(oldUser.getStatus());
            currentSession.merge(user);
        }else {
            user.setStatus("正常");
            user.setCreateTime(new Date());
            currentSession.saveOrUpdate(user);
        }
    }
}
