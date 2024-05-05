package com.janghee.gmarketapi.tools;

/**
 * public / private / proteceted
 * public => 외부클래스에서도 자유롭게 사용이 가능하다.
 * private => 같은 패키지, 자식클래스 사용가능
 * protected => 사용금지.
 * */
public class ToolManager {
    // public static ToolManager sharedInstance = new ToolManager();

    /**
     * 어떤 기능을 만든다! => 이 기능을 만들 때 순서가 있음!
     * 빈값체크를 만든다!
     * => object => 이게 스트링이 맞는지 확인 -> 형을 확인, String 형이 맞는지 확인, Object -> String 형태인지 확인
     * => 아니면 빈값 반환
     * => 맞으면 String으로 변환 후 반환.
     *
     * -> *java object 형 체크* 로 검색
     * 검색시,[언어 / 내가 할 내용]으로 하면 잘 나옴.
     */

    /**
     * 해당 오브젝트가 빈값인지 확인합니다.
     */
    public String checkBlank(Object object) {
        String checkStr = "";

        if(object == null) {
            checkStr = "";
        } else {
            if(object instanceof String) {
                // instanceof object 가 String가 맞는지 확인
                checkStr = object.toString();
            } else {
                checkStr = "";
            }
        }

        return checkStr;
    }
}
