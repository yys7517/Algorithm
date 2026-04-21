package BOJ.silver;

import java.util.*;
import java.io.*;

public class Solution_5014_스타트링크 {
    static int F,S,G,U,D;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F+1];
        int[] dist = bfs();

        System.out.println(dist[G] == -1 ? "use the stairs" : dist[G] );
    }

    static int[] bfs() {
        int[] dist = new int[F+1];  // 엘레베이터 버튼 누른 횟수
        Arrays.fill(dist, -1);  // -1은 방문하지 않은 곳

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {S, 0});
        dist[S] = 0;

        while(!q.isEmpty()) {
            int[] curr = q.poll();

            int now = curr[0];
            int cost = curr[1];

            // 윗 방향 (-1로 방문 체크)
            if( now + U <= F && dist[now + U] == -1 ) {
                dist[now + U] = cost + 1;
                q.add( new int[] { now + U, dist[now + U] } );
            }

            // 아랫 방향 (-1로 방문 체크)
            if( now - D > 0 && dist[now - D] == -1 ) {
                dist[now - D] = cost + 1;
                q.add( new int[] { now - D, dist[now - D] } );
            }
        }

        return dist;
    }
}
