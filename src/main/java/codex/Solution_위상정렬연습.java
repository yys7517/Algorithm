package codex;

import java.util.*;

public class Solution_위상정렬연습 {
    public static void main(String[] args) {
        int n = 6;

        int[][] dependencies = {
                {1, 4},
                {1, 2},
                {2, 3},
                {4, 5},
                {3, 6},
                {5, 6}
        };

        System.out.println(Arrays.toString(solution(n, dependencies)));
        // 결과값
        // [1, 2, 3, 4, 5, 6]
    }

    private static int[] solution(int n, int[][] dependencies) {
        int[] answer = new int[n];  // 정점의 처리 순서
        int idx = 0;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // 1. 단방향 인접 리스트와 indegree 만들기
        int[] indegrees = new int[n+1];

        for(int[] dependency: dependencies) {
            int v1 = dependency[0];
            int v2 = dependency[1];

            adj.get(v1).add(v2);
            indegrees[v2]++;
        }

        // 2. 진입차수가 0인 정점을 PQ에 넣기
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i <= n; i++) {
            if( indegrees[i] == 0 ) {
                pq.add(i);
            }
        }

        // 3. 정점을 꺼내 처리하고, 다음 정점의 진입차수 감소시키기
        while(!pq.isEmpty()) {
            int curr = pq.poll();

            answer[idx++] = curr;   // 정점 처리 순서

            // 현재 curr 처리 완료, 현재 curr에서 연결된 다음 정점에서 진입차수를 제거한다.
            for(int next: adj.get(curr)) {
                indegrees[next]--;

                if( indegrees[next] == 0 ) {
                    pq.add(next);
                }
            }
        }

        // 4. 처리한 정점이 n개보다 적다면, 사이클로 판단하기
        if( idx < n ) {
            return new int[] {};
        }

        return answer;
    }
}
