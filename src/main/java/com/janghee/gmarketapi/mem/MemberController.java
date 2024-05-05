package com.janghee.gmarketapi.mem;

import com.janghee.gmarketapi.tools.ToolManager;
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

    private ToolManager toolManager = new ToolManager();

    @PostMapping("/login.api")
    public Map<String, Object> login(@RequestBody Map<String, Object> info) {
        Map<String, Object> map = new HashMap<>();

        /*
        * 1] info 데이터 정상여부 확인
        * 2] info 에서 loginId / loginPw / loginType 분리, 해서 빈값여부 확인
        * 2-1] 빈값이 아니라면 map으로 다시 만들어서, service 로 넘기면 됨
        * 2-2] 빈값이면, 반환, ( 오류코드 )
        * */

        // 1) loginId / loginType / loginPw 받아오기
        String loginType = toolManager.checkBlank(info.get("loginType"));
        String loginId = toolManager.checkBlank(info.get("loginId"));
        String loginPw = toolManager.checkBlank(info.get("loginPw"));

        // 2) 3가지가 정상적으로 값이 있는지 확인, 없으면 빈값 오류코드 반환
        // 오류코드 : 9990 / 오류메시지 : 아이디 및 패스워드 입력 후 다시 시도해주세요.
        /**
         * {
         *   "code": "9990",
         *   "msg": "아이디 및 패스워드 입력 후 다시 시도해주세요."
         * }
         *
         * Ajax 가 분리 처리해준다.
         * resBody.code => 요런식으로 분리가 됨! 이걸로 오류가 있는지 확인 후 처리
         */
        if("".equals(loginType) || "".equals(loginId) || "".equals(loginPw)) {
            map.put("code", "9990");
            map.put("msg", "아이디 및 패스워드 입력 후 다시 시도해주세요.");
            return map;
        }

        return map;
    }
}
