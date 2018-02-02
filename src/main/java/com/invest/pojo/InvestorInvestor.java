package com.invest.pojo;

import java.util.Date;

public class InvestorInvestor {
    private Integer id;

    private Integer investorId;

    private Integer otherInvestorId;

    private String operation;

    private Date createTime;

    private Date updateTime;

    public InvestorInvestor(Integer id, Integer investorId, Integer otherInvestorId, String operation, Date createTime, Date updateTime) {
        this.id = id;
        this.investorId = investorId;
        this.otherInvestorId = otherInvestorId;
        this.operation = operation;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public InvestorInvestor() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Integer investorId) {
        this.investorId = investorId;
    }

    public Integer getOtherInvestorId() {
        return otherInvestorId;
    }

    public void setOtherInvestorId(Integer otherInvestorId) {
        this.otherInvestorId = otherInvestorId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
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