package com.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

// 商品类别表
@Entity
@Table(name="category")
public class Category {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    private Long id;

    // 归属分类ID
    @Column(name = "tglparentid")
    private String tglparentid;

    // 类别名称
    @Column(name = "datashowname")
    private String datashowname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTglparentid() {
        return tglparentid;
    }

    public void setTglparentid(String tglparentid) {
        this.tglparentid = tglparentid;
    }

    public String getDatashowname() {
        return datashowname;
    }

    public void setDatashowname(String datashowname) {
        this.datashowname = datashowname;
    }
}