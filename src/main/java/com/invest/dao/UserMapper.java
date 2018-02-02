package com.invest.dao;

import com.invest.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User selectByPhone(String phone);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}