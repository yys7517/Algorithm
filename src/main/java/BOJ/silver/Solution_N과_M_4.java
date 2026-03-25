package BOJ.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_N과_M_4 {
    static int N, M;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = new int[M];    // M길이의 수열

        backtracking(0);

        System.out.print(sb);
    }

    static void backtracking(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(answer[i]).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (depth == 0 || answer[depth - 1] <= i) {
                answer[depth] = i;
                backtracking(depth + 1);
            }
        }
    }
}
