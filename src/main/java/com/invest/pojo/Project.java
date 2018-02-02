package com.invest.pojo;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Project {
    private Integer id;

    @NotNull(message = "项目创建人的id不能为空")
    private Integer userId;

    private String name;

    private String description;

    private String domain;

    private String address;

    private String round;

    private Integer financeMount;

    private String businessPlan;

    private Date createTime;

    private Date updateTime;

    private Byte statu;

    public Project(Integer id, Integer userId, String name, String description, String domain, String address, String round, Integer financeMount, String businessPlan, Date createTime, Date updateTime, Byte statu) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.domain = domain;
        this.address = address;
        this.round = round;
        this.financeMount = financeMount;
        this.businessPlan = businessPlan;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.statu = statu;
    }

    public Project() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain == null ? null : domain.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round == null ? null : round.trim();
    }

    public Integer getFinanceMount() {
        return financeMount;
    }

    public void setFinanceMount(Integer financeMount) {
        this.financeMount = financeMount;
    }

    public String getBusinessPlan() {
        return businessPlan;
    }

    public void setBusinessPlan(String businessPlan) {
        this.businessPlan = businessPlan == null ? null : businessPlan.trim();
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

    public Byte getStatu() {
        return statu;
    }

    public void setStatu(Byte statu) {
        this.statu = statu;
    }
}