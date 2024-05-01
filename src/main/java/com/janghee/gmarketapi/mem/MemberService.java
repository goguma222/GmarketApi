package com.janghee.gmarketapi.mem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class MemberService {

    @Autowired
    MemberMapper MemberMapper;

    /**
     * 자바에서 함수 만드는 규칙
     * 접근자 리턴값 함수명() {내용}
     */
    public void test() {
        Map<String, Object> any = new HashMap<>();

        // 코드, 메시지
        // key, value 형태로 사용
        any.put("code", "0000");
    }
}
