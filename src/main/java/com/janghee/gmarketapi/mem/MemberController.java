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


    /**
     *
     * @param info
     * @return
     */
    @PostMapping("/login.api")
    public Map<String, Object> login(@RequestBody Map<String, Object> info) {
        Map<String, Object> map = new HashMap<>();

        /**
         *
         * @RequestParam : Form 에서 사용
         * - input => id = Key
         * - input => value = value
         *
         * @RequestBody : 일반적으로, Ajax, 앱통신 등에서 사용.
         * - key = key
         * - value = value
         *
         */

        /*
        * 1] info 데이터 정상여부 확인
        * 2] info 에서 loginId / loginPw / loginType 분리, 해서 빈값여부 확인
        * 2-1] 빈값이 아니라면 map으로 다시 만들어서, service 로 넘기면 됨
        * 2-2] 빈값이면, 반환, ( 오류코드 )
        * */
        // <input type="text" id="loginIdEmail" />
        // 1) loginId / loginType / loginPw 받아오기
        String loginType = toolManager.checkBlank(info.get("loginType"));
        String loginId = toolManager.checkBlank(info.get("loginId"));
        String loginPw = toolManager.checkBlank(info.get("loginPw"));

        // 2) 3가지가 정상적으로 값이 있는지 확인, 없으면 빈값 오류코드 반환
        /**
         * Ajax 가 분리 처리해준다.
         * resBody.code => 요런식으로 분리가 됨! 이걸로 오류가 있는지 확인 후 처리
         */
        // 문저열비교 ==

        /**
         * # 필요한거
         *
         * 로그인
         * 아이디/패스워드/타입
         *
         * 반환되야 되는거
         * 코드/메시지/닉네임/유저키
         *
         * 바디로 받겠다고 결정
         *
         * 작업 순서 작성
         */

        /**
         * 접근자 함수명 (파라미터 파라미터명)
         *
         * 1] 서비스한테, info 파라미터 전달. => OK
         * 2] 서비스 함수로부터 전달받기. => OK
         * 3] map 에 매핑후 리턴하기 => OK
         */

        if("".equals(loginType) || "".equals(loginId) || "".equals(loginPw)) {
            map.put("code", "9990");
            map.put("msg", "아이디 및 패스워드 입력 후 다시 시도해주세요.");
        } else {
            Map<String, Object> result = memberService.getLoginInfo(info);
            map = result;
        }

        return map;
    }
}

/**
 * 조건
 * loginType : D
 * userKey : 맨마지막 회원의 유저키에서 1개 증가 => integer
 * updateDate : yyyyMMdd - 20240513
 * updateTime : HHmmss - 210300
 *
 * SimpleFormat : 얘 찾아보시고, 타입 형변환
 * Date today = new Date(); -> 오늘 현재날짜 및 시간불러오기
 *
 * # 프론트 참조
 * - 디자인 입히지 않기 => 나중에
 * - 다음 -> 주소불러오기 API
 */