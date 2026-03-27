package BOJ.silver;

import java.io.*;
import java.util.*;

public class Solution_N과_M_10 {
    static int N, M;
    static boolean[] visited;
    static StringBuilder sb;
    static int[] answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        sb = new StringBuilder();
        answer = new int[M];
        arr = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt( st1.nextToken() );
        }

        Arrays.sort(arr);

        backtracking(0);

        System.out.println(sb);
    }

    static void backtracking(int depth) {

        if( depth == M ) {
            for(int i = 0; i < M; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = -1;

        for(int i = 0; i < N; i++) {
            if( !visited[i] && arr[i] != before) {
                // 비 내림차순 정렬
                // depth가 0일때는 모두 출력, depth가 1이상일 때는 이전 값보다 크거나 같을 때만
                if(depth == 0 || answer[depth-1] <= arr[i]) {
                    visited[i] = true;

                    answer[depth] = arr[i];
                    before = arr[i];
                    backtracking(depth + 1);

                    visited[i] = false;
                }

            }
        }

    }
}
