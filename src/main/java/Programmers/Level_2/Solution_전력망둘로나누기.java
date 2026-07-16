package Programmers.Level_2;

import java.util.ArrayList;

public class Solution_전력망둘로나누기 {
    static ArrayList<ArrayList<Integer>> adj;
    static int N;
    static boolean[] visited;
    static int minDiff;

    static int dfs(int current) {
        int child = 1;

        for(int next: adj.get(current)) {
            if( !visited[next] ) {
                visited[next] = true;
                child += dfs(next);
            }
        }

        // 현재 current에서 DFS를 했을 때, 현재 current를 루트로 하는 서브트리의 크기를 구할 수 있다.
        // 현재 서브트리 크기, 전체 크기 - 현재 서브트리 크기 는 전력망의 차이와 같다. (전선이 끊어진 것과 같은 원리)
        int diff = Math.abs(child - (N - child));   // 재귀가 타고 내려가면 갈 수록, 서브트리의 루트 값이 달라지므로, 모든 케이스의 전력망의 차이를 모두 구할 수 있다.

        minDiff = Math.min(minDiff, diff);
        return child;
    }

    public int solution(int n, int[][] wires) {
        adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        N = n;
        visited = new boolean[n+1];

        minDiff = Integer.MAX_VALUE;

        for(int[] wire: wires) {
            int v1 = wire[0];
            int v2 = wire[1];

            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }

        visited[1] = true;
        dfs(1);

        return minDiff;
    }
}
