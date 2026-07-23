package Programmers.Level_3;

import java.util.*;

public class Solution_불량사용자 {
    static Set<Integer> combinations;   // 제재 명단에 비트마스킹 적용, 비트마스킹 된 값 Integer

    // 사용자 아이디 중 일부를 * 문자로 가림

    // user_id - 응모자 목록
    // banned_id - 불량 사용자 목록
    public int solution(String[] user_id, String[] banned_id) {
        combinations = new HashSet<>();

        int mask = 0;   // 아무도 마스킹 하지 않음. (1 << 0 으로 하면, user_id[0]을 이미 마스킹한걸로 처리)
        dfs(user_id, banned_id, 0, mask);

        return combinations.size(); // 몇 가지 경우의 수? return
    }

    static void dfs(String[] user_id, String[] banned_id, int depth, int mask) {
        // 제재 명단을 다 확인했다면
        if( depth == banned_id.length ) {
            combinations.add(mask);
            return;
        }

        String banned = banned_id[depth];

        for(int i = 0; i < user_id.length; i++) {
            // 현재 유저 user_id[i]가 이미 마스킹 되었나?
            if( ( mask & (1 << i) ) != 0 ) continue;

            // 제재 아이디 패턴과 동일한가?
            if( !isBanned(banned, user_id[i] ) ) continue;

            int nextMask = mask | (1 << i);

            dfs(user_id, banned_id, depth + 1, nextMask);
        }
    }

    static boolean isBanned(String banned, String userId) {
        // 1. 일단 둘의 길이가 맞아야 하고
        if(banned.length() != userId.length()) return false;

        // 2. 인덱스 위치에 있는 문자가 서로 같아야 하거나, *로 되어있어야함.
        for(int i = 0; i < banned.length(); i++) {
            // * 문자열이 아닌데, 두 문자열의 같은 위치에 글자가 다르면
            if( banned.charAt(i) != '*' && banned.charAt(i) != userId.charAt(i) ) return false;
        }

        return true;
    }
}
