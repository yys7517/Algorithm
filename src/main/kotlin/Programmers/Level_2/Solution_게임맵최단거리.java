package Programmers.Level_2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_게임맵최단거리 {
    static class Coord {
        int x, y, dist;

        Coord(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public int solution(int[][] maps) {
        int answer = bfs(new Coord(0,0,1), maps);

        return answer;
    }

    private static int bfs(Coord start, int[][] maps) {
        Queue<Coord> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];

        int sx = start.x;
        int sy = start.y;

        queue.add(start);
        visited[sx][sy] = true;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while( !queue.isEmpty() ) {
            Coord point = queue.poll();

            int x = point.x;
            int y = point.y;
            int dist = point.dist;

            if(x == maps.length-1 && y == maps[0].length - 1) {
                return dist;
            }

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 좌표 밖 or 이미 방문
                if(nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length || visited[nx][ny]) continue;
                if(maps[nx][ny] == 0) continue; // 벽

                queue.add(new Coord(nx, ny, dist + 1));
                visited[nx][ny] = true;
            }
        }

        return -1;
    }
}
