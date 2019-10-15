package com.example.demo.service;

import com.example.demo.dao.TUserMapper;
import com.example.demo.entity.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TUserService {
    @Autowired
    TUserMapper mapper;

    public TUser selectTUserByName(String name){
        return mapper.selectTUserByName(name);
    }

    public int insertTUser(TUser user){
        return mapper.insertTUser(user);
    }
    public int deleteTUserById(int id){
        return mapper.deleteTUserById(id);
    }
    public int updateSummaryById(int id, String summary){
        return mapper.updateSummaryById(id,summary);
    }

    public TUser selectTUserById(int id) {
        return mapper.selectTUserById(id);
    }
}
