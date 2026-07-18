package Programmers.Level_3;

import java.util.*;

public class Solution_등산코스_정하기 {
    static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // pahts - [i, j, cost] : i - j 양방향 이동, cost 비용
        for(int[] path: paths) {
            int i = path[0];
            int j = path[1];
            int cost = path[2];

            adj.get(i).add(new int[] {j, cost});
            adj.get(j).add(new int[] {i, cost});
        }

        int INF = 10_000_000;

        int[] minIntensity = new int[n+1];
        Arrays.fill(minIntensity, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> Integer.compare(a[1], b[1]));

        // 출입구
        for(int gate: gates) {
            minIntensity[gate] = 0;
            pq.add(new int[] {gate, 0});
        }

        // 산봉우리 표기
        boolean[] isSummit = new boolean[n+1];

        for(int summit: summits) {
            isSummit[summit] = true;
        }

        while(!pq.isEmpty()) {
            int[] currNode = pq.poll();
            int curr = currNode[0];
            int intensity = currNode[1];

            // 이미 최소 intensity로 curr에 도착할 수 있으면 skip
            if(minIntensity[curr] < intensity) continue;

            // 산봉우리에 도착했으면, 탐색 중단 (그 경로의 Intensity 값은 이미 구했다고 볼 수 있기 때문)
            // ..? 다른 길로 내려 오는게 비용이 덜 들면 아 어차피 경로 중 최댓값이 그 경로의 intensity니까? 더 탐색할 필요가 없는건가?
            // 굳이 더 오래 걸리는 길로 내려올 필요도 없고, 올라간 그대로 다시 내려오는게? 최단 경로를 이미 구했기 때문에?
            if( isSummit[curr] ) continue;

            for(int[] nextNode: adj.get(curr)) {
                int next = nextNode[0];
                int cost = nextNode[1];

                int nextIntensity = Math.max(intensity, cost);

                // intensity가 최소가 되도록...
                if( minIntensity[next] > nextIntensity ) {
                    minIntensity[next] = nextIntensity;
                    pq.add(new int[] {next, nextIntensity});
                }
            }
        }

        int bestIntensity = INF;

        for(int i = 1; i <= n; i++) {
            // 산봉우리 이면서, 그 정점까지 이동하는 데에 필요한 Intensity의 최솟값을 찾자.
            if( isSummit[i] ) {
                bestIntensity = Math.min(bestIntensity, minIntensity[i]);
            }
        }

        for(int i = 1; i <= n; i++) {
            if( isSummit[i] && minIntensity[i] == bestIntensity ) {
                // 산봉우리 이면서, 최선의 intensity를 찾았다.
                return new int[] { i, bestIntensity };
            }
        }

        return answer;
    }
}
