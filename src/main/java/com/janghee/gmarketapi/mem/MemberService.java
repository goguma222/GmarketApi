package com.janghee.gmarketapi.mem;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class MemberService {

    public void test() {
        Map<String, Object> any = new HashMap<>();

        // 코드, 메시지
        // key, value 형태로 사용
        any.put("code", "0000");
    }
}
