package BOJ.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 부분수열의_합 {
    static int N, S;
    static int[] arr;
    static int count;
    static boolean[] visited;

    // static StringBuilder sb;
    static List<Integer> result;
    static Set<Set<Integer>> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // sb = new StringBuilder();
        count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        S = Integer.parseInt(st.nextToken());
        set = new HashSet<>();
        result = new ArrayList<>();

        visited = new boolean[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        backtracking(0, 0);

        // 목표합(S)이 0일 경우, 아무것도 안 고른 '공집합'도 합이 0으로 카운트됩니다.
        // 문제에서 '크기가 양수인 부분수열'이라고 했으니 공집합의 경우 1을 빼줍니다.
        if (S == 0) {
            count--;
        }

        System.out.println(count);
    }

    static void backtracking(int depth, int sum) {
        if (depth == N) {
            if (sum == S) {
                count++;
            }
            return;

        } else {
            // 현재 값을 더하거나, 말거나
            backtracking(depth + 1, sum + arr[depth]);
            backtracking(depth + 1, sum);
        }
    }
}
