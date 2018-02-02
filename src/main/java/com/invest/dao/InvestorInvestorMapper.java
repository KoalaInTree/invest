package com.invest.dao;

import com.invest.pojo.InvestorInvestor;

public interface InvestorInvestorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InvestorInvestor record);

    int insertSelective(InvestorInvestor record);

    InvestorInvestor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InvestorInvestor record);

    int updateByPrimaryKey(InvestorInvestor record);
}