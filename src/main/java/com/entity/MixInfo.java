package com.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

/**
 * 网站综合信息
 */
@Entity
@Table(name="mixinfo")
public class MixInfo {


    @Id
    @Column(name = "id")
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    private Long id;

    // 标题
    @Column(name = "title")
    private String title;

    // 副标题
    @Column(name = "cotitle")
    private String cotitle;

    // 内容
    @Column(name = "content")
    private String content;

    // 类别
    @Column(name = "infoType")
    private String infoType;

    // 图片
    @Column(name = "filename")
    private String filename;

    // 简述
    @Column(name = "remo")
    private String remo;


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

    public String getCotitle() {
        return cotitle;
    }

    public void setCotitle(String cotitle) {
        this.cotitle = cotitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getRemo() {
        return remo;
    }

    public void setRemo(String remo) {
        this.remo = remo;
    }
}
