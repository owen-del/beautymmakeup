package com.service.impl;

import com.entity.User;
import com.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
