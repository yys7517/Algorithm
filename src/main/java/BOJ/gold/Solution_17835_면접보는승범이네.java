package BOJ.gold;

import java.io.*;
import java.util.*;

public class Solution_17835_면접보는승범이네 {
    static class Node implements Comparable<Node> {
        int to;
        long dist;

        Node(int to, long dist) {
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo( Node other ) {
            // 거리가 먼 도시를 찾아야 함.
            return Long.compare( other.dist, this.dist );
        }
    }

    static int N;
    static List<List<int[]>> adj;
    static int[] offices;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        offices = new int[K+1];

        adj = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // adj.get(s).add(new int[] {e, c});

            // 면접장에서 출발하는 다익스트라로 돌려야 하므로 역방향 간선
            adj.get(e).add(new int[] {s, c});
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < K; i++) {
            offices[i] = Integer.parseInt(st.nextToken());
        }

        long[] answer = getLongestCity();

        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    static long[] getLongestCity() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        long[] dist = new long[N+1];
        Arrays.fill(dist, Long.MAX_VALUE);

        // 면접장을 출발지로 설정
        for(int office: offices) {
            pq.add( new Node(office, 0) );
            dist[office] = 0;
        }

        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            int now = curr.to;

            if( dist[now] < curr.dist ) continue;

            for( int[] nextNode: adj.get(now) ) {
                int next = nextNode[0];
                int nextDist = nextNode[1];

                if( dist[next] > dist[now] + nextDist ) {
                    dist[next] = dist[now] + nextDist;
                    pq.add( new Node(next, dist[next]) );
                }
            }
        }

        long maxDist = -1;
        int minCity = -1;

        // 최단 거리 배열을 순회하며 '최단 거리들 중 최댓값'을 찾음
        // 거리가 같을 경우 번호가 작은 것을 출력해야 하므로 1번 노드부터 탐색
        for(int i = 1; i <= N; i++) {
            // 도달할 수 없는 노드 무시
            if(dist[i] != Long.MAX_VALUE && dist[i] > maxDist) {
                maxDist = dist[i];
                minCity = i;
            }
        }

        return new long[] { minCity, maxDist };
    }
}
