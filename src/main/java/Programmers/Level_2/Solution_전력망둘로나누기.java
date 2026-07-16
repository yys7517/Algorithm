package Programmers.Level_2;

import java.util.*;

public class Solution_전력망둘로나누기 {
    ArrayList<ArrayList<Integer>> adj;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        // 전선 하나 골라서 끊어보자.
        for(int wireNum = 0; wireNum < wires.length; wireNum++) {
            adj = new ArrayList<>();
            for(int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }

            // 전선 하나 끊은 상태의 인접 그래프 생성
            for(int i = 0; i < wires.length; i++) {
                if( i == wireNum ) continue;    // i번째 전선 끊어보기.

                int v1 = wires[i][0];
                int v2 = wires[i][1];

                // v1-v2 연결
                adj.get(v1).add(v2);
                adj.get(v2).add(v1);
            }

            // BFS 돌려보자.
            Queue<Integer> q = new ArrayDeque<>();
            boolean[] visited = new boolean[n+1];

            // 1번 송전탑에서 출발하자
            int count = 1;      // BFS 돌려서, 한 번 탐색에서 개수 찾기
            q.add(1);
            visited[1] = true;

            while(!q.isEmpty()) {
                int curr = q.poll();

                for(int next: adj.get(curr)) {
                    if( !visited[next] ) {
                        q.add(next);
                        visited[next] = true;
                        count++;
                    }
                }
            }

            // 송전탑 개수는 각각
            // count 개, n - count개
            answer = Math.min(answer, Math.abs(count - (n - count)));   // 송전탑 차이 최소값

        } // End 전선 하나 끊기

        return answer;
    }
}
