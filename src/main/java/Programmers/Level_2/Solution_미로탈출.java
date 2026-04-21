package Programmers.Level_2;

import java.util.*;

public class Solution_미로탈출 {
    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] visited;
    static int R, C;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};

    public int solution(String[] maps) {
        int answer = 0;

        R = maps.length;
        C = maps[0].length();

        int sx = 0;
        int sy = 0;
        int lx = 0;
        int ly = 0;
        int ex = 0;
        int ey = 0;

        for(int i = 0; i < R; i++) {
            for(int j = 0;  j < C; j++) {
                char ch = maps[i].charAt(j);

                if( ch == 'S' ) {
                    sx = i;
                    sy = j;
                }

                if( ch == 'E' ) {
                    ex = i;
                    ey = j;
                }

                if( ch == 'L' ) {
                    lx = i;
                    ly = j;
                }
            }
        }

        Node start = new Node(sx, sy);
        Node lever = new Node(lx, ly);
        Node end = new Node(ex, ey);

        int distStartToLever = bfs(start, lever, maps);
        int distLeverToEnd = bfs(lever, end, maps);

        // System.out.println("distStartToLever = " + distStartToLever);
        // System.out.println("distLeverToEnd = " + distLeverToEnd);

        if( distStartToLever == -1 || distLeverToEnd == -1 ) {
            return -1;
        }

        answer = distStartToLever + distLeverToEnd;

        return answer;
    }

    static int bfs(Node start, Node end, String[] maps) {
        Queue<Node> q = new LinkedList<>();
        visited = new int[R][C];
        for(int i = 0; i < R; i++) {
            Arrays.fill( visited[i], -1 );
        }

        q.add(start);
        visited[start.x][start.y] = 0;

        while(!q.isEmpty()) {
            Node curr = q.poll();

            int x = curr.x;
            int y = curr.y;

            if( x == end.x && y == end.y ) {
                return visited[x][y];
            }

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if( nx < 0 || ny < 0 || nx >= R || ny >= C ) continue;
                if( maps[nx].charAt(ny) == 'X' ) continue;  // 벽이면 스킵
                if( visited[nx][ny] != -1 ) continue;       // 이미 방문한 곳이면 스킵

                // System.out.println("next X: " + nx + " Y: " + ny);
                visited[nx][ny] = visited[x][y] + 1;
                q.add(new Node(nx, ny));
            }
        }

        return -1;
    }
}
