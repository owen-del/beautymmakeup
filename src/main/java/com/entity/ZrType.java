package com.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

/**
 * 新闻信息类别
 */
@Entity
@Table(name="zrtype")
public class ZrType {

    // 主键
    @Id
    @Column(name = "id")
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    private Long id;

    // 类别名称
    @Column(name = "name")
    private String name;

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
}
