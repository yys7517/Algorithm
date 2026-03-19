package Programmers.Level_1;

import java.util.*;

class Solution_영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();

        // 1. 첫 번째 단어는 무조건 통과이므로 미리 세팅
        set.add(words[0]);
        char lastChar = words[0].charAt(words[0].length() - 1);

        for(int i = 1; i < words.length; i++) {
            String word = words[i];

            // 누가 이미 말한 단어를 말했거나, 끝말잇기가 성립하지 않는다면
            if( set.contains(word) || word.charAt(0) != lastChar ) {

                // 차례와 번호 값을 초기화
                int turn = (i / n) + 1;
                int num = (i % n) + 1;

                // {번호, 차례} 값을 리턴
                return new int[] {num , turn};
            }

            set.add( word );
            lastChar = word.charAt(word.length() -1);
        }

        return new int[] {0, 0};
    }
}
