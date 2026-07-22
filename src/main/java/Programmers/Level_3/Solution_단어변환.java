package Programmers.Level_3;

public class Solution_단어변환 {
    static final int INF = Integer.MAX_VALUE;
    static int minCount = INF;

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        boolean[] visited = new boolean[words.length];

        dfs(begin, target, words, visited, 0);

        // 변환할 수 없는 경우 0을 return
        return minCount == INF ? 0 : minCount;
    }

    static void dfs(String current, String target, String[] words, boolean[] visited, int depth) {
        if( current.equals(target) ) {
            minCount = Math.min(minCount, depth);
            return;
        }

        for(int i = 0; i < words.length; i++) {
            String next = words[i];

            if( !visited[i] && canConvert(current, next) ) {

                visited[i] = true;
                dfs(next, target, words, visited, depth + 1);

                visited[i] = false;
            }
        }
    }

    static boolean canConvert(String a, String b) {
        int difference = 0;

        for(int i = 0; i < a.length(); i++) {
            if( a.charAt(i) != b.charAt(i) ) {
                difference++;
            }
        }

        return difference == 1;
    }
}
