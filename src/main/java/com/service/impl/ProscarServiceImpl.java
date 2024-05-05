package com.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.entity.Proscar;
import com.entity.Prosorder;
import com.entity.ReceiveInfo;
import com.entity.User;
import com.response.ResponseResult;
import com.service.ProscarService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("com.service.impl.ProscarServiceImpl")
public class ProscarServiceImpl implements ProscarService {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Proscar> findMyProscar(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        List<Proscar> proscars = currentSession.createQuery("FROM Proscar WHERE isDel = 0 AND user.id = :userId", Proscar.class)
                .setParameter("userId", user.getId()).list();
        return proscars;
    }

    @Override
    public void deleteById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Proscar proscar = currentSession.get(Proscar.class, id);
        proscar.setIsDel(1);
        // 采用逻辑删除
        currentSession.update(proscar);
    }

    @Override
    public ResponseResult numeric(Proscar proscar) {
        Session currentSession = sessionFactory.getCurrentSession();
        Proscar old = currentSession.get(Proscar.class, proscar.getId());
        old.setNum(proscar.getNum());
        currentSession.update(old);
        return ResponseResult.SUCCESS("修改完成");
    }

    /**
     * 购买
     * @param id id
     * @param addressId 地址
     * @param paytype 支付方式
     * @return
     */
    @Override
    public ResponseResult diamond(Long id, Long addressId, String paytype) {
        // 1.删除购物车
        Session currentSession = sessionFactory.getCurrentSession();
        Proscar proscar = currentSession.get(Proscar.class, id);

        ReceiveInfo receiveInfo = currentSession.get(ReceiveInfo.class, addressId);
        proscar.setIsDel(1);
        currentSession.update(proscar);
        // 2.组装订单
        Prosorder prosorder = new Prosorder();
        // 订单号
        prosorder.setOrderno(IdUtil.simpleUUID());
        // 卖方用户名
        prosorder.setShopuname(proscar.getGoods().getName());
        // 用户名
        prosorder.setUname(proscar.getUser().getName());
        // 商品id
        prosorder.setGid(proscar.getGoods().getId());
        // 商品编号
        prosorder.setGno(proscar.getGoods().getNo());
        // 商品名
        prosorder.setFgname(proscar.getGoods().getName());
        // 成交价格
        prosorder.setCprice(String.valueOf(Integer.valueOf(proscar.getGoods().getPrice()) * proscar.getNum()));
        // 数量
        prosorder.setSnum(String.valueOf(proscar.getNum()));
        // 应付金额
        prosorder.setTotalamt(String.valueOf(Integer.valueOf(proscar.getGoods().getPrice()) * proscar.getNum()));
        // 收货信息
        prosorder.setSelectre(receiveInfo.getName() + "   " + receiveInfo.getTel() + "   " + receiveInfo.getAddress());
        // 付款方式
        prosorder.setPaytype(paytype);
        // 付款状态
        prosorder.setPayflag("已付款");
        // 订单状态
        prosorder.setFshstatus("待受理");
        // 受理意见
        prosorder.setFshremo("");
        // 评星
        prosorder.setSshscore("");
        // 评价
        prosorder.setSshremo("");
        // 数据入库时间
        prosorder.setSavetime(DateUtil.now());
        // 用户
        prosorder.setSysuserkey(String.valueOf(proscar.getUser().getId()));
        // 3. 将订单存入库中
        currentSession.save(prosorder);
        return ResponseResult.SUCCESS("完成");
    }
}
