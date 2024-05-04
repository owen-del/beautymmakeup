package com.service.impl;

import com.entity.Category;
import com.entity.Messages;
import com.response.ResponseResult;
import com.service.MessagesService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service("com.service.impl.MessagesServiceImpl")
public class MessagesServiceImpl implements MessagesService {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Messages> findByContLike(String cont) {

        AtomicReference<List<Messages>> listAtomicCategory = new AtomicReference<>();
        Session currentSession = sessionFactory.getCurrentSession();
        Optional.ofNullable(cont).ifPresentOrElse(c -> {
            if (!"".equals(c)) {
                List<Messages> list = currentSession.createQuery("FROM Messages WHERE cont LIKE CONCAT('%',:cont,'%') ", Messages.class).setParameter("cont", c).list();
                listAtomicCategory.set(list);
            }else {
                List<Messages> list = currentSession.createQuery("FROM Messages", Messages.class).list();
                listAtomicCategory.set(list);
            }
        }, ()->{
            List<Messages> list = currentSession.createQuery("FROM Messages", Messages.class).list();
            listAtomicCategory.set(list);
        });

        return listAtomicCategory.get();
    }

    @Override
    public void deleteById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Messages messages = currentSession.get(Messages.class, id);
        currentSession.delete(messages);
    }

    @Override
    public ResponseResult deleteBatch(Long[] ids) {
        Session currentSession = sessionFactory.getCurrentSession();
        for (Long id : ids) {
            Messages messages = currentSession.get(Messages.class, id);
            currentSession.delete(messages);
        }

        return ResponseResult.SUCCESS("批量删除成功。");
    }

    @Override
    public ResponseResult reply(Messages messages) {
        Session currentSession = sessionFactory.getCurrentSession();
        Messages m = currentSession.get(Messages.class, messages.getId());
        m.setRecont(messages.getRecont());
        currentSession.update(m);
        return ResponseResult.SUCCESS("回复成功");
    }
}
