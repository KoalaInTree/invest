package com.invest.pojo;

import java.util.Date;

public class ProjectInvestor {
    private Integer id;

    private Integer projectId;

    private Integer investorId;

    private String investorPreference;

    private Date createTime;

    private Date updateTime;

    public ProjectInvestor(Integer id, Integer projectId, Integer investorId, String investorPreference, Date createTime, Date updateTime) {
        this.id = id;
        this.projectId = projectId;
        this.investorId = investorId;
        this.investorPreference = investorPreference;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ProjectInvestor() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Integer investorId) {
        this.investorId = investorId;
    }

    public String getInvestorPreference() {
        return investorPreference;
    }

    public void setInvestorPreference(String investorPreference) {
        this.investorPreference = investorPreference == null ? null : investorPreference.trim();
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
}