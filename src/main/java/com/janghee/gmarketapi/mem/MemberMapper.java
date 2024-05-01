package com.janghee.gmarketapi.mem;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
@MapperScan("com.janghee.gmarketapi")
public interface MemberMapper {
}
