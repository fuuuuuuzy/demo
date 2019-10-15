package com.example.demo.service;

import com.example.demo.dao.RelateMapper;
import com.example.demo.entity.Relate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelateService {
    @Autowired
    RelateMapper mapper;

    public Relate selectRelate(int id, String rType, String rToType){
        return mapper.selectRelate(id,rType,rToType);
    }

    public int insertRelate(Relate relate){
        return mapper.insertRelate(relate);
    }

    public int deleteRelate(int id){
        return mapper.deleteRelate(id);
    }
}
