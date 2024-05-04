package com.service.impl;

import com.entity.Category;
import com.entity.ZrType;
import com.response.ResponseResult;
import com.service.ZrTypeService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 信息类别管理
 */
@Service("com.service.impl.ZrTypeServiceImpl")
public class ZrTypeServiceImpl implements ZrTypeService {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ZrType> findLikeName(String name) {
        AtomicReference<List<ZrType>> listAtomicCategory = new AtomicReference<>();
        Session currentSession = sessionFactory.getCurrentSession();
        Optional.ofNullable(name).ifPresentOrElse(n -> {
            if (!"".equals(n)) {
                List<ZrType> list = currentSession.createQuery("FROM ZrType WHERE name LIKE CONCAT('%',:name,'%') ", ZrType.class).setParameter("name", name).list();
                listAtomicCategory.set(list);
            }else {
                List<ZrType> list = currentSession.createQuery("FROM ZrType", ZrType.class).list();
                listAtomicCategory.set(list);
            }
        }, ()->{
            List<ZrType> list = currentSession.createQuery("FROM ZrType", ZrType.class).list();
            listAtomicCategory.set(list);
        });

        return listAtomicCategory.get();
    }

    @Override
    public ZrType findById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        ZrType zrType = currentSession.get(ZrType.class, id);
        return zrType;
    }

    @Override
    public void saveOrUpdate(ZrType zrType) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(zrType);
    }

    @Override
    public void deleteById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        ZrType zrType = currentSession.get(ZrType.class, id);
        currentSession.delete(zrType);
    }

    @Override
    public ResponseResult deleteBatch(Long[] ids) {
        Session currentSession = sessionFactory.getCurrentSession();
        for (Long id : ids) {
            ZrType zrType = currentSession.get(ZrType.class, id);
            currentSession.delete(zrType);
        }
        return ResponseResult.SUCCESS("批量删除成功");
    }
}
