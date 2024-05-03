package com.service.impl;

import com.entity.User;
import com.response.ResponseResult;
import com.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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


}
