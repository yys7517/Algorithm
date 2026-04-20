package Programmers.Level_2;

import java.util.*;

public class Solution_리코쳇로봇 {

    static int[][] map;
    static int R, C;
    static int sx, sy, ex, ey;

    public int solution(String[] board) {
        int answer = 0;

        // (1) 2차원 배열로 변환
        R = board.length;
        C = board[0].length();

        map = new int[R][C];

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                char ch = board[i].charAt(j);

                if( ch == 'R' ) {
                    sx = i;
                    sy = j;
                }

                if( ch == 'G' ) {
                    ex = i;
                    ey = j;
                }

                if( ch == 'D' ) {
                    map[i][j] = -1;
                } else {
                    map[i][j] = Integer.MAX_VALUE;  // 최단 거리를 갱신해야 하므로, MAX값으로 초기화
                }
            }
        }

        bfs();

        return map[ex][ey] != Integer.MAX_VALUE ? map[ex][ey] : -1;
    }

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add( new int[] { sx, sy } );
        map[sx][sy] = 0;

        while( !q.isEmpty() ) {
            int[] curr = q.poll();

            int x = curr[0];
            int y = curr[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                while( validation(nx, ny) && map[nx][ny] != -1 ) {
                    nx += dx[i];
                    ny += dy[i];
                }

                // 장애물이나 벽을 만나면, 반복문이 끝나므로
                // 이전 단계로 다시 이동시켜줘야 한다.
                nx -= dx[i];
                ny -= dy[i];

                if( map[nx][ny] < map[x][y] + 1 ) continue;

                q.add( new int[] { nx, ny } );
                map[nx][ny] = Math.min( map[nx][ny], map[x][y] + 1 );
            }
        }
    }


    static boolean validation( int x, int y ) {
        if( x < 0 || y < 0 || x >= R || y >= C ) return false;
        return true;
    }
}
