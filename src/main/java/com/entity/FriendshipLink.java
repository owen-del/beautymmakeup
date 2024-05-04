package com.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

/**
 * 友情链接
 */
@Entity
@Table(name="friendshipLink")
public class FriendshipLink {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    private Long id;

    // 链接名称
    @Column(name = "name")
    private String name;

    // 链接地址
    @Column(name = "url")
    private String url;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
