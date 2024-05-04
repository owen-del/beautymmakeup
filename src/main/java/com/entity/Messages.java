package com.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

/**
 * 留言
 */
@Entity
@Table(name="messages")
public class Messages {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    private Long id;

    // 用户信息
    @ManyToOne
    @JoinColumn(name="uid",updatable=false)
    private User user;


    // 内容
    @Column(name = "cont")
    private String cont;

    // 回复信息
    @Column(name = "recont")
    private String recont;

    // 入库时间
    @Column(name = "createTime")
    private Date createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public String getRecont() {
        return recont;
    }

    public void setRecont(String recont) {
        this.recont = recont;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
