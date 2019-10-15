package com.example.demo.dao;

import com.example.demo.entity.TUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TUserMapper {
    TUser selectTUserByName(String name);
    int insertTUser(TUser user);
    int deleteTUserById(int id);
    int updateSummaryById(int id, String summary);
    TUser selectTUserById(int id);
}
