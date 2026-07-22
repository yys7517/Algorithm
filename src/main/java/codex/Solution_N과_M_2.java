package codex;

public class Solution_N과_M_2 {

    static boolean[] visited;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    /**
     * N과 M (2)
     * 1 2 와 2 1 같은 순서가 다른 수열은 같은 수열로 본다.
     */
    public static void main(String[] args) {
        solution(4, 2);
        // 기댓값
        // 1 2
        // 1 3
        // 1 4
        // 2 2
        // 2 3
        // 2 4
        // 3 3
        // 3 4
    }

    static int N;   // 1부터 N까지 중에
    static int M;   // 길이 M인 수열

    static void solution(int n, int m) {
        visited = new boolean[n+1];
        answer = new int[m];

        N = n;
        M = m;

        dfs(0, 1);   // 0부터 시작, answer 채우자

        System.out.println(sb);
    }

    static void dfs(int idx, int start) {
        // 길이 M인 수열 출력
        if(idx == M) {
            for(int i = 0; i < idx; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i <= N; i++) {
            if( !visited[i] ) {
                // 현재 i를 방문 안했을 때
                answer[idx] = i;
                visited[i] = true;

                dfs(idx + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
