package com.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

// 商品表
@Entity
@Table(name="goods")
public class Goods {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    private Long id;

    // 商品编号
    @Column(name = "no")
    private String no;

    // 商品名称
    @Column(name = "name")
    private String name;

    // 单价
    @Column(name = "price")
    private String price;

    // 上架状态
    @Column(name = "status")
    private String status;

    // 介绍
    @Column(name = "remo")
    private String remo;

    // 图片
    @Column(name = "filename")
    private String filename;


    @ManyToOne
    @JoinColumn(name="categoryId",updatable=false)
    private Category category;


    @ManyToOne
    @JoinColumn(name="userId",updatable=false)
    private User user;

    @Column(name = "clicknums")
    private Long clicknums;

    // 评分
    @Column(name = "stars")
    private String stars;

    // 创建时间
    @Column(name = "createTime")
    private Date createTime;

    // 点赞量
    @Column(name = "praisenums")
    private Long praisenums;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemo() {
        return remo;
    }

    public void setRemo(String remo) {
        this.remo = remo;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getClicknums() {
        return clicknums;
    }

    public void setClicknums(Long clicknums) {
        this.clicknums = clicknums;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getPraisenums() {
        return praisenums;
    }

    public void setPraisenums(Long praisenums) {
        this.praisenums = praisenums;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
