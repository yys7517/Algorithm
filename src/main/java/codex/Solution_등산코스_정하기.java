package codex;

import java.util.*;

public class Solution_등산코스_정하기 {

    // 1번부터 n번까지의 정점
    // 각 정점은, 출입구, 쉼터, 산봉우리 이다.
    //
    public static void main(String[] args) {

    }

    /**
     *
     * @param n - 1번부터 n번까지 정점
     * @param paths - 정점간 간선 정보 { i , j ,w } - i-j 연결, 비용 w
     * @param gates - 출입구 정점
     * @param summits - 산봉우리 정점
     *
     * 출입구 - 산봉우리 경로 중, 가장 큰 w 값이 그 경로의 intensity
     *
     * @return - 경로 중, intensity가 가장 작은 경로의 [산봉우리 번호, intensity]
     */
    static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // 1. 그래프 연결
        for(int[] path: paths) {
            int start = path[0];
            int end = path[1];
            int cost = path[2];

            adj.get(start).add(new int[] {end, cost});
            adj.get(end).add(new int[] {start, cost});
        }

        // 다익스트라
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        int[] minIntensity = new int[n+1];
        Arrays.fill(minIntensity, Integer.MAX_VALUE);

        // 2. 출발지
        for(int gate: gates) {
            pq.add(new int[] {gate, 0});
            minIntensity[gate] = 0;
        }

        //
        boolean[] isSummit = new boolean[n+1];
        for(int summit: summits) {
           isSummit[summit] = true;
        }

        while (!pq.isEmpty()) {
            int[] currNode = pq.poll();
            int curr = currNode[0];
            int intensity = currNode[1];

            // 이미 curr까지의 minIntensity 값이 기록되어 있다면 생략
            if( minIntensity[curr] < intensity ) continue;

            // 현재 정점이 산봉우리이면, 더이상 탐색할 필요 없다.
            if( isSummit[curr] ) continue;

            for(int[] nextNode: adj.get(curr)) {
                int next = nextNode[0];
                int nextCost = nextNode[1];

                int nextIntensity = Math.max(intensity, nextCost);

                if( minIntensity[next] > nextIntensity ) {
                    minIntensity[next] = nextIntensity;
                    pq.add(new int[] {next, nextIntensity});
                }
            }
        }

        // minIntensity 배열에서, 산봉우리 번호의 인덱스 값 = 산봉우리로 가는 경로에서 기록된 intensity값 중 최솟값
        int bestIntensity = 10_000_000;

        for(int i = 1; i <= n; i++) {
            if( isSummit[i] ) {
                // 현재 정점이 산봉우리일 때, intensity 최솟값을 기록
                // 모든 출입구 -> 산봉우리 경로 중, 최선의 intensity값을 찾을 수 있음.
                bestIntensity = Math.min(bestIntensity, minIntensity[i]);
            }
        }

        for(int i = 1; i <= n; i++) {
            if( isSummit[i] && minIntensity[i] == bestIntensity) {
                return new int[] { i, bestIntensity };
            }
        }

        return answer;
    }
}
