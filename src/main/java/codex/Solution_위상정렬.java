package codex;

import java.util.*;

public class Solution_위상정렬 {
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

        int[][] cycle = {
                {1, 2},
                {2, 3},
                {3, 1}
        };

        System.out.println(Arrays.toString(solution(n, dependencies)));  // {1, 2, 3, 4, 5, 6}
        System.out.println(Arrays.toString(solution(n, cycle)));
    }

    static ArrayList<ArrayList<Integer>> adj;

    static int[] solution(int n, int[][] dependencies) {
        // 인접 그래프 생성
        adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // 진입차수 배열
        int[] indegree = new int[n+1];

        for(int i = 0; i < dependencies.length; i++) {
            int[] edge = dependencies[i];
            // a -> b 단방향 간선
            int a = edge[0];
            int b = edge[1];

            adj.get(a).add(b);  // a -> b 연결
            indegree[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0) {
                pq.add(i);
            }
        }

        // 작업 순서
        int[] order = new int[n];
        int index = 0;

        while(!pq.isEmpty()) {
            // 현재 작업 완료
            int curr = pq.poll();
            order[index++] = curr;      // 현재 작업 처리 순서

            for( int next: adj.get(curr) ) {
                indegree[next]--;

                // 선행 작업이 완료된 (인접 차수가 없는 정점) 작업은 바로 PQ에 삽입
                if (indegree[next] == 0) {
                    pq.add(next);
                }
            }
        }

        if (index < n) {
            return new int[0]; // 사이클 때문에 모든 작업을 처리하지 못함
        }

        return order;
    }
}
