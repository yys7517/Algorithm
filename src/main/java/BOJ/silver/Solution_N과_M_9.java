package BOJ.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_N과_M_9 {
    static int N, M;
    static int[] answer;
    static boolean[] visited;
    static int[] arr;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        Arrays.sort(arr);

        answer = new int[M];    // M길이의 수열
        visited = new boolean[10001];

        backtracking(0);

        System.out.print(sb);
    }

    static void backtracking(int depth) {
        // M개를 모두 골랐다면 StringBuilder에 추가 후 리턴
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = -1;    // 현재 depth에서 중복된 값을 사용하지 않도록

        for(int i = 0; i < N; i++) {
            if( visited[i] ) continue;
            if( before == arr[i] ) continue;    // 이전 반복에서 before값이 등록되면, 다음 반복에서 동일한 값이 사용되지 않는다.

            visited[i] = true;
            answer[depth] = arr[i];
            before = arr[i];

            backtracking(depth + 1);

            visited[i] = false;
        }
    }
}
