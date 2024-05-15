package com.janghee.gmarketapi.tools;


/**
 * 패키지 함수 만드는 순서
 * - checkBlank(Object object) 함수 만들기
 * - checkStr 변수 만들어서 빈 문자열 할당하기
 * - object null이면 빈 문자열 반환하기
 * - object가 null이 아니면 String이 맞는지 확인하기
 * - object가 String이 맞으면 문자열로 변환하여 checkStr에 할당하기
 * - object가 String이 아니면 checkStr에 빈문자열 할당하기
 * - 값을 반환하기
 */
public class ToolManager {

    public String checkBlank(Object object) {
        String checkStr = "";

        if(object == null) {
            checkStr = "";
        } else {
            if(object instanceof String) {
                checkStr = object.toString();
            } else {
                checkStr = "";
            }
        }
        return checkStr;
    }
}
