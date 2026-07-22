package Programmers.Level_3;

import java.util.*;

public class Solution_섬_연결하기 {

    public int solution(int n, int[][] costs) {
        int answer = 0; // 최소 비용의 합

        // 0. n개의 정점 루트 노드 정보를 초기화
        int[] parent = new int[n+1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // 1. 간선 비용을 기준으로 오름차순으로 정렬
        Arrays.sort(costs, (a,b) -> Integer.compare(a[2], b[2]));

        int selected = 0;   // MST 만들기 위해 선택된 간선.

        // 2. 비용이 작은 간선부터 연결
        for(int[] edge: costs) {
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];

            // 사이클이 생기지 않는 경우에만, a와 b를 연결한다.
            if( union(parent, a, b) ) {
                answer += cost;     // 최소비용의 합에 비용을 추가한다.
                selected++;
            }

            // 간선이 n-1 개이면, 연결 중단
            if( selected == n-1 ) break;
        }

        return answer;
    }

    static int find(int[] parent, int x) {
        if(parent[x] == x) return x;    // 루트 노드이면, 자기 자신과 부모 노드 정보가 같다.
        return parent[x] = find(parent, parent[x]);     // 자신의 부모의 부모가 집합의 루트 노드이다.
    }

    static boolean union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);

        if( rootA == rootB ) return false;  // 부모가 같다면, 동일한 집합이므로, 둘이 연결하면 사이클이 발생할 우려가 있다.

        parent[rootB] = rootA;

        return true;
    }
}
