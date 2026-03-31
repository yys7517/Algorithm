package BOJ.gold;

import java.io.*;
import java.util.*;

public class Solution_최소비용구하기2 {
    static List<List<int[]>> adj;
    static int n;
    static int[] prev;

    static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj.get(s).add(new int[]{ e, c });
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[] dist = dijkstra(s);

        // for(int i = 1; i <= n; i++) {
        //   System.out.print(prev[i] + " ");
        // }

        int idx = e;
        int count = 1;
        List<Integer> path = new ArrayList<>();

        while( idx != -1 ) {
            path.add(idx);
            idx = prev[idx];
            if(idx == -1) break;
            // System.out.println(idx);
            count++;
        }

        System.out.println(dist[e]);
        System.out.println(count);
        for(int i = path.size()-1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
    }

    static int[] dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        prev = new int[n+1];
        prev[start] = -1;

        int[] dist = new int[n+1];
        Arrays.fill(dist, MAX);
        dist[start] = 0;

        pq.add(new int[] {start, 0});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();

            int now = curr[0];
            int cost = curr[1];

            if(dist[now] < cost) continue;

            for(int[] nextNode: adj.get(now)) {
                int next = nextNode[0];
                int nextCost = nextNode[1];

                if(dist[next] > dist[now] + nextCost) {
                    dist[next] = dist[now] + nextCost;
                    pq.add(new int[] {next, dist[next]});

                    prev[next] = now;
                }
            }
        }

        return dist;
    }
}
