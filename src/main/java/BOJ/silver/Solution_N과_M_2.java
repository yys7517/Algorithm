package BOJ.silver;

import java.util.*;
import java.io.*;

public class Solution_N과_M_2 {
    static int N, M;
    static int[] answer;
    static boolean[] visited;

    static List<List<Integer>> adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = new int[M];    // M길이의 수열
        visited = new boolean[N+1];

        adj = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        backtracking(0);

    }

    static void backtracking(int depth) {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                System.out.print(answer[i] + " ");
            }

            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++) {
            if( !visited[i] ) {
                if( depth == 0 || answer[depth-1] < i) {
                    // depth가 0일 때는 다 출력,

                    // 아니면, 이전에 저장된 값이, 현재 값보다 작을 때
                    // 1 2 이후 , 2 1을 출력할 차례가 온다면,
                    // 1은 2보다 뒤에 올 수없고, 같은 수는 visited에 의해 필터링
                    answer[depth] = i;
                    visited[i] = true;

                    backtracking(depth + 1);
                    visited[i] = false;
                }

            }
        }
    }
}
