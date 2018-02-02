package com.invest.pojo;

import java.util.Date;

public class News {
    private Integer id;

    private String title;

    private String keyword;

    private String author;

    private String domain;

    private String content;

    private Date createTime;

    private Date updateTime;

    private Boolean statu;

    public News(Integer id, String title, String keyword, String author, String domain, String content, Date createTime, Date updateTime, Boolean statu) {
        this.id = id;
        this.title = title;
        this.keyword = keyword;
        this.author = author;
        this.domain = domain;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.statu = statu;
    }

    public News() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain == null ? null : domain.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getStatu() {
        return statu;
    }

    public void setStatu(Boolean statu) {
        this.statu = statu;
    }
}