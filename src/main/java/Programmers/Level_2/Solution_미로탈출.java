package Programmers.Level_2;

import java.util.*;

public class Solution_미로탈출 {
    static int rows;
    static int cols;

    public int solution(String[] maps) {

        rows = maps.length;
        cols = maps[0].length();

        // 출구 문을 개방하기 위해 레버를 당겨야 함.

        // 레버를 들렸다가, 출구로 가야함
        // S - L + L - E 이 최단 경로
        char[][] map = new char[rows][cols];

        int sx = 0;
        int sy = 0;

        int ex = 0;
        int ey = 0;

        int lx = 0;
        int ly = 0;

        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[i].length(); j++) {
                map[i][j] = maps[i].charAt(j);

                if( map[i][j] == 'S' ) {
                    sx = i;
                    sy = j;
                }

                if( map[i][j] == 'E' ) {
                    ex = i;
                    ey = j;
                }

                if( map[i][j] == 'L' ) {
                    lx = i;
                    ly = j;
                }
            }
        }

        int t1 = bfs(map, sx, sy, lx, ly);
        if (t1 == -1) return -1;

        int t2 = bfs(map, lx, ly, ex, ey);
        if (t2 == -1) return -1;

        return t1 + t2;
    }

    // (sx, sy) -> (ex, ey)로 이동하는 최단 거리
    static int bfs(char[][] map, int sx, int sy, int ex, int ey) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {sx, sy, 0});

        boolean[][] visited = new boolean[rows][cols];
        visited[sx][sy] = true;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while(!q.isEmpty()) {
            int[] curr = q.poll();

            int x = curr[0];
            int y = curr[1];
            int dist = curr[2];

            if(x == ex && y == ey) return dist;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if( nx < 0 || ny < 0 || nx >= rows || ny >= cols ) continue;
                if( map[nx][ny] == 'X' ) continue;  // 벽
                if( visited[nx][ny] ) continue;

                q.offer(new int[] {nx, ny, dist + 1});
                visited[nx][ny] = true;
            }
        }

        return -1;
    }
}
