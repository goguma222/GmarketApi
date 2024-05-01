package com.janghee.gmarketapi.mem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/mem")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping("/login.api")
    public Map<String, Object> login(@RequestBody Map<String, Object> info) {
        /*
        * 1] info 데이터 정상여부 확인
        * 2] info 에서 loginId / loginPw / loginType 분리, 해서 빈값여부 확인
        * 2-1] 빈값이 아니라면 map으로 다시 만들어서, service 로 넘기면 됨
        * 2-2] 빈값이면, 반환, ( 오류코드 )
        * */


        Map<String, Object> map = new HashMap<>();
        return map;
    }
}
