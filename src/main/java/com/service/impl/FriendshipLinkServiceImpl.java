package com.service.impl;

import com.entity.FriendshipLink;
import com.response.ResponseResult;
import com.service.FriendshipLinkService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service("com.service.impl.FriendshipLinkServiceImpl")
public class FriendshipLinkServiceImpl implements FriendshipLinkService {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<FriendshipLink> findByNameLike(String name) {
        AtomicReference<List<FriendshipLink>> listAtomicCategory = new AtomicReference<>();
        Session currentSession = sessionFactory.getCurrentSession();
        Optional.ofNullable(name).ifPresentOrElse(n -> {
            if (!"".equals(n)) {
                List<FriendshipLink> list = currentSession.createQuery("FROM FriendshipLink WHERE name LIKE CONCAT('%',:name,'%') ", FriendshipLink.class).setParameter("name", name).list();
                listAtomicCategory.set(list);
            }else {
                List<FriendshipLink> list = currentSession.createQuery("FROM FriendshipLink", FriendshipLink.class).list();
                listAtomicCategory.set(list);
            }
        }, ()->{
            List<FriendshipLink> list = currentSession.createQuery("FROM FriendshipLink", FriendshipLink.class).list();
            listAtomicCategory.set(list);
        });

        return listAtomicCategory.get();
    }

    @Override
    public FriendshipLink findById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        FriendshipLink friendshipLink = currentSession.get(FriendshipLink.class, id);
        return friendshipLink;
    }

    @Override
    public void deleteById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        FriendshipLink friendshipLink = currentSession.get(FriendshipLink.class, id);
        currentSession.delete(friendshipLink);
    }

    @Override
    public ResponseResult deleteBatch(Long[] ids) {
        Session currentSession = sessionFactory.getCurrentSession();
        for (Long id : ids) {
            FriendshipLink friendshipLink = currentSession.get(FriendshipLink.class, id);
            currentSession.delete(friendshipLink);
        }
        return ResponseResult.SUCCESS("批量删除成功。");
    }

    @Override
    public void saveOrUpdate(FriendshipLink friendshipLink) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(friendshipLink);
    }
}
