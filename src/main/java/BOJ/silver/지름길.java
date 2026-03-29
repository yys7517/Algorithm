package BOJ.silver;

import java.util.*;
import java.io.*;

public class 지름길 {
    static int N, D;

    static List<List<int[]>> adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int answer = 0;

        N = Integer.parseInt(st.nextToken()); // 지름길의 개수
        D = Integer.parseInt(st.nextToken()); // 고속도로의 길이 D

        adj = new ArrayList<>();
        for(int i = 0; i <= D; i++) {
            adj.add(new ArrayList<>());
            adj.get(i).add(new int[] {i+1, 1}); // 1씩 다 연결
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if(end > D) continue;           // 도착 지점을 벗어나는 지름길일 때
            if(end-start < cost) continue;  // 지름길로 가는게 더 오래 걸릴 때

            adj.get(start).add(new int[] { end, cost });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[1] - b[1] );
        pq.add(new int[] {0, 0});

        int[] dist = new int[D+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

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

                if(next > D) continue;

                if( dist[next] > dist[now] + nextCost ) {
                    dist[next] =  dist[now] + nextCost;
                    pq.add(new int[] { next, dist[next] });
                }
            }
        }

        System.out.println(dist[D]);
    }
}
