package Programmers.Level_2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_게임맵최단거리 {
    static class Coord {
        int x, y;

        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] maps) {
        int answer = bfs(new Coord(0,0), maps);

        return answer;
    }

    private static int bfs(Coord start, int[][] maps) {
        Queue<Coord> queue = new LinkedList<>();

        int sx = start.x;
        int sy = start.y;

        queue.add(start);
        maps[sx][sy] = 1;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while( !queue.isEmpty() ) {
            Coord point = queue.poll();

            int x = point.x;
            int y = point.y;

            if(x == maps.length-1 && y == maps[0].length - 1) {
                return maps[x][y];
            }

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 좌표 밖 or 이미 방문
                if(nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length) continue;
                if(maps[nx][ny] > 1) continue;  // 이미 거리 값이 update된 곳이라면? 방문한 곳이라면?
                if(maps[nx][ny] == 0) continue; // 벽

                queue.add(new Coord(nx, ny));
                maps[nx][ny] = maps[x][y] + 1;
            }
        }

        return -1;
    }
}
