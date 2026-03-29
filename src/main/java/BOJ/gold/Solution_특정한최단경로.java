package BOJ.gold;

import java.io.*;
import java.util.*;

public class Solution_특정한최단경로 {
    static int N, E;
    static int v1, v2;

    static List<List<int[]>> adj;
    static int answer;
    static final int MAX = 200_000 * 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 지름길의 개수
        E = Integer.parseInt(st.nextToken()); // 고속도로의 길이 D

        adj = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 양방향 간선
            adj.get(start).add(new int[] { end, cost });
            adj.get(end).add(new int[] { start, cost });
        }

        st = new StringTokenizer(br.readLine(), " ");

        // 2개의 정점을 반드시 거치면서 N으로 이동
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        // 1 ~ N까지, v1, v2를 반드시 거치면서
        int[] dist1 = dijkstra(1);
        int[] distV1 = dijkstra(v1);
        int[] distV2 = dijkstra(v2);

        // for(int i = 1; i < dist.length; i++) {
        //   System.out.print(dist[i] + " ");
        // }

        int path1 = dist1[v1] + distV1[v2] + distV2[N];
        int path2 = dist1[v2] + distV2[v1] + distV1[N];
        answer = Math.min(path1, path2);

        if(answer >= MAX) {
            answer = -1;
        }

        System.out.println(answer);
    }

    static int[] dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> a[1] - b[1] );
        pq.add(new int[] {start, 0});

        int[] dist = new int[N+1];
        Arrays.fill(dist, MAX);
        dist[start] = 0;

        while( !pq.isEmpty() ) {
            int[] curr = pq.poll();

            int now = curr[0];
            int cost = curr[1];

            // System.out.println(now);
            // System.out.println(cost);

            if( dist[now] < cost ) continue;

            for( int[] nextNode: adj.get(now) ) {
                int next = nextNode[0];
                int nextCost = nextNode[1];

                if( dist[next] > dist[now] + nextCost ) {
                    dist[next] =  dist[now] + nextCost;
                    pq.add(new int[] { next, dist[next] });
                }
            }
        }

        return dist;
    }
}
