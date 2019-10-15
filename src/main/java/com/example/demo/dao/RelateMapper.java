package com.example.demo.dao;

import com.example.demo.entity.Relate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RelateMapper {
    Relate selectRelate(@Param("rFromTuserId") int id, @Param("rType") String rType, @Param("rToType") String rToType);
    int insertRelate(Relate relate);
    int deleteRelate(@Param("r_id") int id);
}
