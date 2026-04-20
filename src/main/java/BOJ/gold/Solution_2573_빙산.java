package BOJ.gold;

import java.util.*;
import java.io.*;

public class Solution_2573_빙산 {
    static int N, M;
    static int[][] map;

    static int time = 0;

    static int[] dx = { -1,1,0,0 };
    static int[] dy = { 0,0,1,-1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = solution();
        System.out.println( answer );
    }

    static int solution() {
        while( !isAllMelted() ) {
            melt();

            int count = 0;
            boolean[][] visited = new boolean[N][M];

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if( map[i][j] > 0 && !visited[i][j] ) {
                        count++;
                        bfs(i,j, visited);
                    }
                }
            }

            if( count >= 2 ) {
                return time;
            }
        }

        return 0;
    }

    static void melt() {
        int[][] copiedMap = new int[N][M];

        for(int x = 0; x < N; x++) {
            for(int y = 0; y < M; y++) {
                copiedMap[x][y] = map[x][y];
            }
        }

        // melt
        for(int x = 0; x < N; x++) {
            for(int y = 0; y < M; y++) {

                if( map[x][y] > 0 ) { // 빙산?
                    int around = 0;

                    for(int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        if( nx < 0 || ny < 0 || nx >= N || ny >= M ) continue;
                        if( map[nx][ny] > 0 ) continue;

                        around++;
                    }

                    copiedMap[x][y] = map[x][y] - around > 0 ? map[x][y] - around : 0;
                }
            }
        }

        // map에 옮겨담기
        for(int x = 0; x < N; x++) {
            for(int y = 0; y < M; y++) {
                // System.out.print(copiedMap[x][y] + " ");
                map[x][y] = copiedMap[x][y];
            }
            // System.out.println();
        }

        time++;
    }

    static void bfs(int x, int y, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();

            int sx = curr[0];
            int sy = curr[1];

            for(int i = 0; i < 4; i++) {
                int nx = sx + dx[i];
                int ny = sy + dy[i];

                if( nx < 0 || ny < 0 || nx >= N || ny >= M ) continue;
                if( map[nx][ny] == 0 ) continue;
                if( visited[nx][ny] ) continue;

                q.add( new int[] {nx, ny} );
                visited[nx][ny] = true;
            }
        }
    }

    static boolean isAllMelted() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] > 0) return false;
            }
        }

        return true;
    }
}
