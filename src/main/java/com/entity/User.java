package com.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

// 用户实体类
@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    private Long id;

    // 账号
    @Column(name = "account")
    private String account;

    // 密码
    @Column(name = "password")
    private String password;

    // 用户类型
    @Column(name = "type")
    private String type;

    // 用户名
    @Column(name = "name")
    private String name;

    // 头像
    @Column(name = "avatar")
    private String avatar;

    // 性别
    @Column(name = "sex")
    private String sex;

    // 电话
    @Column(name = "tel")
    private String tel;

    // 地址
    @Column(name = "address")
    private String address;

    // 介绍
    @Column(name = "remo")
    private String remo;

    // 状态
    @Column(name = "status")
    private String status;

    // 入库时间
    @Column(name = "create_time")
    private Date createTime;

    // 密保问题
    @Column(name = "passques")
    private String passques;

    // 密保答案
    @Column(name = "passans")
    private String passans;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemo() {
        return remo;
    }

    public void setRemo(String remo) {
        this.remo = remo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPassques() {
        return passques;
    }

    public void setPassques(String passques) {
        this.passques = passques;
    }

    public String getPassans() {
        return passans;
    }

    public void setPassans(String passans) {
        this.passans = passans;
    }
}
