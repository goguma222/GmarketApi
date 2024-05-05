package com.janghee.gmarketapi.mem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class MemberService {

    @Autowired
    MemberMapper memberMapper;

    /**
     * 자바에서 함수 만드는 규칙
     * 접근자 리턴값 함수명() {내용}
     *
     */

    /**
     *
     * @param info - 로그인타입 및 로그인 아이디 / 패스워드
     * @return - 코드 및 메시지
     */

    public Map<String, Object>getLoginInfo(Map<String, Object>info) {
        Map<String, Object> result = new HashMap<>();

        // 2-1) Map 만들기
        Map<String, Object>loginInfo = new HashMap<>();
        loginInfo = info;

        // 2-2) 맵퍼에 요청, type / loginId로 일치하는 데이터 있는지 여부 확인
        Map<String, Object>getMemInfo = memberMapper.getLoginInfo(loginInfo);

        return result;
    }

}
