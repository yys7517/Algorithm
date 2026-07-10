package Programmers.Level_2;

import java.util.*;

public class Solution_리코쳇로봇 {

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int[][] map;

    static int r, c;
    static int sr, sc;      // 시작 위치
    static int er, ec;      // 도착 위치

    public int solution(String[] board) {
        int answer = 0;

        r = board.length;
        c = board[0].length();

        map = new int[r][c];

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length(); j++) {
                if( board[i].charAt(j) == 'R' ) {
                    sr = i;
                    sc = j;
                    map[i][j] = 0;    // 시작점

                    q.add(new int[] {i, j});
                    visited[i][j] = true;

                } else if( board[i].charAt(j) == 'D' ) {
                    map[i][j] = -1;
                } else if( board[i].charAt(j) == 'G' ) {
                    er = i;
                    ec = j; // 도착점
                    map[i][j] = Integer.MAX_VALUE;

                } else {
                    map[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while(!q.isEmpty()) {
            int[] curr = q.poll();

            // 현재 위치
            int x = curr[0];
            int y = curr[1];

            for(int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;

                // 게임판 위의 장애물이나 게임판 가장자리까지 부딪힐 때까지 미끄러져 움직이는 것을 한 번의 이동
                while(true) {
                    nx += dx[i];
                    ny += dy[i];

                    if( nx < 0 || ny < 0 || nx >= r || ny >= c ) break;
                    if( map[nx][ny] == -1 ) break;
                }

                // 장애지점을 만나서 멈춘 것이므로, 한 칸 빠꾸해야함
                nx -= dx[i];
                ny -= dy[i];

                if( !visited[nx][ny] ) {
                    // 현재 위치로 오기까지 이동 횟수 갱신
                    map[nx][ny] = map[x][y] + 1;

                    q.add(new int[] { nx, ny });
                    visited[nx][ny] = true;
                }

            }
        }

        return map[er][ec] == Integer.MAX_VALUE ? -1 : map[er][ec];
    }
}
