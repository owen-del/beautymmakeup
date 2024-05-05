package com.service.impl;

import com.entity.Goods;
import com.entity.Proscar;
import com.entity.ReceiveInfo;
import com.entity.User;
import com.response.ResponseResult;
import com.service.ReceiveInfoService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service("com.service.impl.ReceiveInfoServiceImpl")
public class ReceiveInfoServiceImpl implements ReceiveInfoService {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ReceiveInfo> findMyByNameLike(Long uid, String name) {
        AtomicReference<List<ReceiveInfo>> listAtomicCategory = new AtomicReference<>();
        Session currentSession = sessionFactory.getCurrentSession();
        Optional.ofNullable(name).ifPresentOrElse(n -> {
            if (!"".equals(n)) {
                List<ReceiveInfo> list = currentSession.createQuery("FROM ReceiveInfo WHERE user.id = :uid AND name LIKE CONCAT('%',:name,'%') ", ReceiveInfo.class)
                        .setParameter("uid", uid)
                        .setParameter("name", name).list();
                listAtomicCategory.set(list);
            }else {
                List<ReceiveInfo> list = currentSession.createQuery("FROM ReceiveInfo WHERE user.id = :uid", ReceiveInfo.class).setParameter("uid", uid).list();
                listAtomicCategory.set(list);
            }
        }, ()->{
            List<ReceiveInfo> list = currentSession.createQuery("FROM ReceiveInfo WHERE user.id = :uid", ReceiveInfo.class).setParameter("uid", uid).list();
            listAtomicCategory.set(list);
        });

        return listAtomicCategory.get();
    }

    @Override
    public ReceiveInfo findById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        ReceiveInfo receiveInfo = currentSession.get(ReceiveInfo.class, id);
        return receiveInfo;
    }

    @Override
    public void deleteById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        ReceiveInfo receiveInfo = currentSession.get(ReceiveInfo.class, id);
        currentSession.delete(receiveInfo);
    }


    @Override
    public ResponseResult deleteBatch(Long[] ids) {
        Session currentSession = sessionFactory.getCurrentSession();
        for (Long id : ids) {
            ReceiveInfo receiveInfo = currentSession.get(ReceiveInfo.class, id);
            currentSession.delete(receiveInfo);
        }
        return ResponseResult.SUCCESS("批量删除成功");
    }


    @Override
    public void saveOrUpdate(ReceiveInfo receiveInfo) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(receiveInfo);
    }


    @Override
    public ResponseResult addCat(Long id, User loginUser) {
        Session currentSession = sessionFactory.getCurrentSession();
        Goods goods = currentSession.get(Goods.class, id);
        Proscar proscar = new Proscar();
        proscar.setIsDel(0);
        proscar.setNum(1);
        proscar.setUser(loginUser);
        proscar.setGoods(goods);
        proscar.setCreateTime(new Date());
        currentSession.save(proscar);
        return ResponseResult.SUCCESS("加入购物车成功");
    }
}
