package Programmers.Level_3;

import java.util.*;

public class Solution_불량사용자 {
    static boolean[] visited;
    static String[] answer;
    static Set<Set<String>> resultSet;

    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        answer = new String[banned_id.length];  // result Arr는 banned_id 길이만큼
        resultSet = new HashSet<>();

        backtracking(0, user_id, banned_id);

        return resultSet.size();
    }


    static void backtracking(int depth, String[] user_id, String[] banned_id) {
        // depth는 user_id 길이만큼 돌면, 모두 확인한 것이므로 종료
        if(depth == banned_id.length) {
//             for(int i = 0; i < answer.length; i++) {
//                 System.out.print(answer[i] + " ");
//             }
//             System.out.println();

            // frodo crodo abc123
            // crodo frodo abc123
            // 순서만 다르고 요소가 같은 경우도 중복으로 취급.
            // 순서가 없는 Set의 성질을 이용하자..
            Set<String> tempSet = new HashSet<>(Arrays.asList(answer));

            resultSet.add(tempSet);
            return;
        }

        for(int i = 0; i < user_id.length; i++) {
            if( visited[i] ) continue;
            if( user_id[i].length() != banned_id[depth].length() ) continue;    // 길이가 안 맞는 유저 아이디는 skip
            if( !isBanned( user_id[i], banned_id[depth] )) continue;    // Ban되는 사용자가 아니면 skip

            visited[i] = true;
            answer[depth] = user_id[i];

            backtracking(depth + 1, user_id, banned_id);
            visited[i] = false;
        }
    }

    static boolean isBanned(String userId, String bannedId) {
        for(int i = 0; i < userId.length(); i++) {
            if( bannedId.charAt(i) == '*' ) continue;
            if( userId.charAt(i) != bannedId.charAt(i) ) return false;
        }

        return true;
    }
}
