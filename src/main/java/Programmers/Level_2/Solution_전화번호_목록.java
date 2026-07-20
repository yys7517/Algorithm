package Programmers.Level_2;

import java.util.Arrays;

public class Solution_전화번호_목록 {
    public boolean solution(String[] phone_book) {

        if(phone_book.length == 1) return true;

        Arrays.sort(phone_book);    // 문자열을 사전순으로 정렬하면 접두어 관계인 전화번호들은 반드시 서로 붙어서 배치

        // 인접한 값만 비교
        for(int i = 0; i < phone_book.length - 1; i++) {
            if( phone_book[i+1].startsWith(phone_book[i]) ) return false;
        }

        return true;
    }
}
