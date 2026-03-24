package BOJ.gold;

import java.io.*;
import java.util.*;

public class Solution_1922_네트워크연결 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt( br.readLine() );
        int M = Integer.parseInt( br.readLine() );

        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj.get(start).add(new int[] {end, cost});
            adj.get(end).add(new int[] {start, cost});
        }

        System.out.println( mst(N, adj) );
    }

    static int mst(int N, List<List<int[]>> adj) {
        int res = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        boolean[] visited = new boolean[N+1];

        pq.add(new int[] {1, 0});
        dist[1] = 0;

        while( !pq.isEmpty() ) {
            int[] curr = pq.poll();
            int now = curr[0];
            int cost = curr[1];

            if(visited[now]) continue;

            visited[now] = true;

            res += cost;

            for( int[] nextNode: adj.get(now) ) {
                int next = nextNode[0];
                int nextCost = nextNode[1];

                if( dist[next] > nextCost ) {
                    dist[next] = nextCost;
                    pq.add( new int[] { next, dist[next] } );
                }
            }
        }

        return res;
    }
}
