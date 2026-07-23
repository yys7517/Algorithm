package Programmers.Level_2;

public class Solution_도넛과_막대_그래프 {

    public int[] solution(int[][] edges) {
        // 모두 방향 그래프 (단방향 간선)
        // 단방향이므로, 진입 차수, 진출 차수?

        // 도넛 모양 그래프 - n개의 정점, n개의 간선
        // 막대 모양 그래프 - n개의 정점, n-1개의 간선
        // 8자 모양 그래프 - n개의 정점, n+1개의 간선

        // 도넛 모양 그래프, 막대 모양 그래프, 8자 모양 그래프의 수의 합은 2이상이다.

        int maxNode = 0;

        // 최대 정점 번호 확인
        for (int[] edge : edges) {
            maxNode = Math.max(maxNode, Math.max(edge[0], edge[1]));
        }

        int[] indegree = new int[maxNode + 1];
        int[] outdegree = new int[maxNode + 1];

        // 0. 진입차수, 진출차수 기록
        for(int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];

            // a -> b (단방향 간선)
            indegree[b]++;
            outdegree[a]++;
        }

        // 1. 생성 정점은 진입 차수가 0이며, 진출 차수가 항상 2이상이다.
        int created = 0;

        for(int i = 1; i <= maxNode; i++) {
            if( indegree[i] == 0 && outdegree[i] >= 2 ) {
                created = i;
                break;
            }
        }

        // System.out.println("생성 정점 : " + created);

        // 2. 생성 정점의 진출 차수는 전체 그래프의 수이다.
        int totalCount = outdegree[created];

        // 3. 8자 그래프의 가운데 정점은 진입 차수가 2보다 크거나, 진출 차수가 2이다.
        // 진입 차수가 2보다 큰 이유는, 생성된 정점으로부터 간선이 이어질 수 있기 때문
        int eightCount = 0;

        for(int i = 1; i <= maxNode; i++) {
            if( indegree[i] >= 2 && outdegree[i] == 2 ) {
                eightCount++;
            }
        }

        // 4. 막대 그래프의 마지막 정점은, 진입 차수가 1이상이고, 진출 차수가 0이다.
        // 막대 그래프의 진입 차수가 1이상인 이유는, 생성 정점으로부터의 간선이 이어질 수 있기 때문?
        int stickCount = 0;

        for(int i = 1; i <= maxNode; i++) {
            if( outdegree[i] == 0 && indegree[i] >= 1 ) {
                stickCount++;
            }
        }

        // 도넛 그래프 개수 = 전체 - 막대 - 8자
        int doughnuts = totalCount - stickCount - eightCount;

        // return {생성된 정점의 번호, 도넛 그래프 수, 막대 그래프 수, 8자 그래프 수}
        return new int[] {created, doughnuts, stickCount, eightCount};
    }
}
