package com.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

/**
 * 站内咨询
 */
@Entity
@Table(name="zresources")
public class ZreSources {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    private Long id;

    // 标题
    @Column(name = "title")
    private String title;

    // 图片
    @Column(name = "filename")
    private String filename;

    // 详细内容
    @Column(name = "content")
    private String content;

    // 入库时间
    @Column(name = "createTime")
    private Date createTime;

    // 用户信息
    @ManyToOne
    @JoinColumn(name="uid",updatable=false)
    private User user;

    // 类别
    @ManyToOne
    @JoinColumn(name="ztypeid",updatable=true)
    private ZrType zrType;

    // 点击量
    @Column(name = "clicknums")
    private Long clicknums;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ZrType getZrType() {
        return zrType;
    }

    public void setZrType(ZrType zrType) {
        this.zrType = zrType;
    }

    public Long getClicknums() {
        return clicknums;
    }

    public void setClicknums(Long clicknums) {
        this.clicknums = clicknums;
    }
}
