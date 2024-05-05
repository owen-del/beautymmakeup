package com.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

// 历史订单
@Entity
@Table(name="prosorder")
public class Prosorder {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    private Long id;

    // 订单号
    @Column(name = "orderno")
    private String orderno;

    // 卖方用户名
    @Column(name = "shopuname")
    private String shopuname;

    // 用户名
    @Column(name = "uname")
    private String uname;

    // 商品id
    @Column(name = "gid")
    private Long gid;

    // 商品编号
    @Column(name = "gno")
    private String gno;


    // 商品名
    @Column(name = "fgname")
    private String fgname;

    // 成交价格
    @Column(name = "cprice")
    private String cprice;

    // 数量
    @Column(name = "snum")
    private String snum;

    // 应付金额
    @Column(name = "totalamt")
    private String totalamt;

    // 收货信息
    @Column(name = "selectre")
    private String selectre;

    // 付款方式
    @Column(name = "paytype")
    private String paytype;

    // 付款状态
    @Column(name = "payflag")
    private String payflag;

    // 订单状态
    @Column(name = "fshstatus")
    private String fshstatus;

    // 受理意见
    @Column(name = "fshremo")
    private String fshremo;

    // 评星
    @Column(name = "sshscore")
    private String sshscore;

    // 评价
    @Column(name = "sshremo")
    private String sshremo;

    // 数据入库时间
    @Column(name = "savetime")
    private String savetime;

    // 用户表主键
    @Column(name = "sysuserkey")
    private String sysuserkey;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getShopuname() {
        return shopuname;
    }

    public void setShopuname(String shopuname) {
        this.shopuname = shopuname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public String getGno() {
        return gno;
    }

    public void setGno(String gno) {
        this.gno = gno;
    }

    public String getFgname() {
        return fgname;
    }

    public void setFgname(String fgname) {
        this.fgname = fgname;
    }

    public String getCprice() {
        return cprice;
    }

    public void setCprice(String cprice) {
        this.cprice = cprice;
    }

    public String getSnum() {
        return snum;
    }

    public void setSnum(String snum) {
        this.snum = snum;
    }

    public String getTotalamt() {
        return totalamt;
    }

    public void setTotalamt(String totalamt) {
        this.totalamt = totalamt;
    }

    public String getSelectre() {
        return selectre;
    }

    public void setSelectre(String selectre) {
        this.selectre = selectre;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getPayflag() {
        return payflag;
    }

    public void setPayflag(String payflag) {
        this.payflag = payflag;
    }

    public String getFshstatus() {
        return fshstatus;
    }

    public void setFshstatus(String fshstatus) {
        this.fshstatus = fshstatus;
    }

    public String getFshremo() {
        return fshremo;
    }

    public void setFshremo(String fshremo) {
        this.fshremo = fshremo;
    }

    public String getSshscore() {
        return sshscore;
    }

    public void setSshscore(String sshscore) {
        this.sshscore = sshscore;
    }

    public String getSshremo() {
        return sshremo;
    }

    public void setSshremo(String sshremo) {
        this.sshremo = sshremo;
    }

    public String getSavetime() {
        return savetime;
    }

    public void setSavetime(String savetime) {
        this.savetime = savetime;
    }

    public String getSysuserkey() {
        return sysuserkey;
    }

    public void setSysuserkey(String sysuserkey) {
        this.sysuserkey = sysuserkey;
    }
}
