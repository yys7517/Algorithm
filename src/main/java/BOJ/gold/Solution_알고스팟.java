package BOJ.gold;

import java.io.*;
import java.util.*;

public class Solution_알고스팟 {
    static final int MAX = Integer.MAX_VALUE;
    static int m,n;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken()); // 가로길이
        n = Integer.parseInt(st.nextToken()); // 세로길이

        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
                // 벽이면 가중치 1
                // 아니면 가중치 0
            }
        }

        int[][] dist = dijkstra();
        System.out.println(dist[n-1][m-1]);
    }

    static int[][] dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], MAX);
        }

        // 시작점 0,0
        dist[0][0] = 0;
        pq.add(new int[] {0, 0, 0});

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,1,-1};

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();

            int x = curr[0];
            int y = curr[1];
            int cost = curr[2];

            if(dist[x][y] < cost) continue;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                int nextCost = map[nx][ny];

                if(dist[nx][ny] > dist[x][y] + nextCost) {
                    dist[nx][ny] = dist[x][y] + nextCost;
                    pq.add(new int[] { nx, ny, dist[nx][ny] });

                    // prev[next] = now;
                }
            }
        }

        return dist;
    }
}
