    package com.janghee.gmarketapi.mem;


    import com.janghee.gmarketapi.tools.ToolManager;
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

        private ToolManager toolManager = new ToolManager();

        /**
         *
         * @param info - 로그인타입 및 로그인 아이디 / 패스워드
         * @return - 코드 및 메시지
         *
         * # 순서
         * - getLoginInfo 함수 파라미터 info 맵 생성
         * - 로그인 정보를 담을 result 맵 생성
         * - info(로그인정보)가 null 또는 문자열(객체)이 비어있다면 result.put("code", "9999"), result.put("msg", "가입된 아이디가 아닙니다. 다시 시도해 주세요"); 반환하기
         * - 그렇지 않은 경우 loginInfo 맵을 만들어 info를 할당하기
         * - 맵퍼에 요청, type / loginId 로 일치하는 데이터 있는지 여부 확인
         * - 비어있지 않으면 비밀번호 비교, 같다면 성공처리, 다르면 에러코드처리
         *
         * 1 궁금증 : xml파일에서 loginPw를 추가해야하는지?
         *
         * 방법 1
         * if(info == null || info.isEmpty()) {
         *     result.put(에러코드반환)
         *     result.put(에러메시지반환)
         * } else {
         *     if(info.equals(info)) {
         *         result.put("code", "7770");
         *         result.put("msg", "가입된 아이디가 맞습니다"
         *     } else {
         *         result.put("code", "9990");
         *         result.put("msg", "아이디 패스워드 입력 후 다시 시도해 주세요");
         *     }
         * }
         *
         * 방법 2
         * 1. getLoginInfo((맵)파라미터)함수 만듬
         * 2. 로그인 정보 담을 맵 만듬
         * 3. 로그인 정보 타입과 아이디로 일치하는지 체크
         * 4. 아이디가 일치하면 비밀번호 일치하는지 체크
         * 5. 로그인 정보가 일치하면 성공코드 반환 code : 7770, msg : 로그인 되었습니다.
         * 6. 로그인 정보가 일치하지 않으면 오류코드 반환 : code : "9990", msg : 아이디 또는 패스워드를 확인해주세요.
         * 7. 값 반환
         *
         * loginPw 값 가져옴
         * String loginPw = (String) info.get("loginPw");
         *
//         * if(loginPw == null || loginPw.isEmpty()) {"code", "9990"; "msg", "아이디 또는 패스워드를 확인해주세요";}
         * else {
         *     if(loginPw.equals(info)) {"code", "7770"; "msg", "로그인 되었습니다."}
         *     else {"code", "9990"; "msg", "아이디 또는 패스워드를 확인해주세요";}
         * }
         *
         * - 값 반환
         */
        /**
         *
         *
         * String msg = "test";
         *
         * if (msg == "")
         *
         * if ("".equals(msg))
         */

        public Map<String, Object> getLoginInfo(Map<String, Object> info) {
            Map<String, Object> result = new HashMap<>();

            // 9999 비어 있다
            // 생략되도 상관없음. 컨트롤러에서 정확히 값을 넘겨준건지 여부 확인임
            if(info == null || info.isEmpty()) {
                result.put("code", "9999");
                result.put("msg", "가입된 아이디가 아닙니다. 다시 시도해 주세요");
                return result;
            }

            /**
             *
             * {
             *  "code" : "0000",
             *  "msg" : "success",
             *  "nickname" : "nick",
             *  "userKey": "1000"
             * }
             *
             * {
             *  "code": "0000",
             *  "msg": "success",
             *  "data": {
             *      "nickname": "nick",
             *      "userKey": "1000"
             *  }
             * }
             *
             *
             *
             */


            /**
             * 형태 이름 = 값;
             *
             * 1] info => 회원로그인 정보가 들어잇는 맵임 // OK
             * 2] mapper => mybatis -> query => 회원정보 조회하는 쿼리 -> 작성 -> XML ( 명령이 있음 ) // OK
             * 3] XML 에 있는 애랑 mapper 클래스에 있는 함수랑 매칭 : input/output 형태가 같은지 // OK
             * 4] 맵퍼한테, 회원정보  // OK
             * 4-1] 없으면 ( null ), 오류코드랑 메시지 반환 // OK
             * 5] 맵퍼한테 받은 데이터에서, 패스워드 빼내기. // OK
             * 6] 빼낸거랑, 갖고 넘어온 info의 패스워드(파라미터)랑 비교  // OK
             * 6-1] 다른경우, 오류코드랑 메시지 반환 // OK
             * 7] 유저키, 닉네임 가져오기 ( DB에서 조회한 맵에서 가져오기 ) // OK
             * 8] 결과맵에 성공코드랑 메시지 추가 // OK
             * 9] 결과맵에 유저키랑 닉네임 데이터 추가 : 맵으로 데이터 만들어서 추가 // OK
             * 10] 리턴. // OK
             */

            // 회원정보 전달받기
            Map<String, Object> dbInfo = memberMapper.getLoginInfo(info);
            if (dbInfo == null || dbInfo.isEmpty()) {
                result.put("code", "9991");
                result.put("msg", "회원정보가 없습니다. 가입 후 이용해주세요.");
            } else {
                String dbPassword = toolManager.checkBlank(dbInfo.get("loginPw"));
                String infoPw = toolManager.checkBlank(info.get("loginPw"));

                if(dbPassword.equals(infoPw)) {
                    String dbNickname = toolManager.checkBlank(dbInfo.get("nickname"));
                    String dbUserKey = toolManager.checkBlank(dbInfo.get("userKey"));

                    Map<String, String> data = new HashMap<>();
                    data.put("nickname", dbNickname);
                    data.put("userKey", dbUserKey);

                    result.put("code", "0000");
                    result.put("msg", "성공");
                    result.put("data", data);
                } else {
                    // 다를때
                    result.put("code", "9992");
                    result.put("msg", "패스워드가 일치하지 않습니다. 확인 후 다시 시도해주세요.");
                }
            }

            return result;
        }

        /*
        *
        *
        * */
    }
