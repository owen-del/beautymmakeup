package com.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

// 商品表
@Entity
@Table(name="category")
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

    // 大类id
    @Column(name = "categoryId")
    private Long categoryId;

    // 用户id
    @Column(name = "userId")
    private Long userId;

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

}
