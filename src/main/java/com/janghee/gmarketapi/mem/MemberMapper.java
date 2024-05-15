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
    // 맴버 정보 가져오기
    public Map<String, Object> getLoginInfo(Map<String, Object>loginInfo);
}
