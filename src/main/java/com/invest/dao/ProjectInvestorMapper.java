package com.invest.dao;

import com.invest.pojo.ProjectInvestor;

public interface ProjectInvestorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectInvestor record);

    int insertSelective(ProjectInvestor record);

    ProjectInvestor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectInvestor record);

    int updateByPrimaryKey(ProjectInvestor record);
}