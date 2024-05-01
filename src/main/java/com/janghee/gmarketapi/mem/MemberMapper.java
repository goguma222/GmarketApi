package com.janghee.gmarketapi.mem;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
@MapperScan("com.janghee.gmarketapi")
public interface MemberMapper {

    public List<Map<String, Object>> getLoginInfo();
}
