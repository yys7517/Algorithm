package Programmers.Level_2;

import java.util.*;

public class Solution_모음사전 {
    static String[] words = {"A", "E", "I", "O", "U"};
    static List<String> resultList;
    static int answer;

    public int solution(String word) {

        resultList = new ArrayList<>();
        dfs("", word);

        return answer;
    }

    static void dfs(String curr, String word) {
        // 단어와 같은지 먼저 확인
        if( curr.equals(word) ) {
            answer = resultList.indexOf(curr) + 1;
            return;
        }

        // 5글자가 되면, 더 이상 length를 늘리면 안됨
        if( curr.length() == 5 ) return;

        for(int i = 0; i < words.length; i++) {
            // System.out.println(curr + words[i]);
            resultList.add(curr + words[i]);
            dfs( curr + words[i] , word);
        }

    }
}
