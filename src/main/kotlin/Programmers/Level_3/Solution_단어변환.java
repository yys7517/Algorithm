package Programmers.Level_3;

public class Solution_단어변환 {
    static int minCount = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];

        int count = 0;
        dfs(begin, target, words, count, visited);

        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    }

    private static void dfs(String curr, String target, String[] words, int count, boolean[] visited) {
        // target으로 변환에 성공했다면, count 리턴
        if( curr.equals(target) ) {
            minCount = Math.min(minCount, count);
            return;     // 새로운 최솟값을 찾았으므로, 다음 최솟값을 찾으러 return
        }

        for(int i = 0; i < words.length; i++) {
            if( !visited[i] && canConvert(curr, words[i]) ) {

                visited[i] = true;
                dfs( words[i], target, words, count + 1, visited );

                //
                visited[i] = false;
            }
        }
    }

    /** 한 번에 한 개의 알파벳만 바꿀 수 있다. */
    private static boolean canConvert(String curr, String next) {
        int diffCount = 0;

        for(int i = 0; i < curr.length(); i++) {
            if( curr.charAt(i) != next.charAt(i) ) {
                diffCount++;
            }
        }

        return diffCount == 1;
    }
}
