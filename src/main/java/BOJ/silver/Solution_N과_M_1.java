package BOJ.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_N과_M_1 {
    static boolean[] visited;
    static int[] answer;

    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1]; // 중복 없이 고르기 위해 visited 사용
        answer = new int[M];

        backtracking(0);
    }

    static void backtracking(int idx) {
        // 길이가 M인 수열을 발견하면 출력
        if(idx == M) {
            for(int i = 0; i < idx; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++) {
            if( !visited[i] ) {
                answer[idx] = i;
                visited[i] = true;

                backtracking(idx + 1);
                visited[i] = false;
            }
        }
    }
}
