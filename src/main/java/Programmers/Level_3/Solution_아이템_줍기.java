package Programmers.Level_3;

import java.util.*;

public class Solution_아이템_줍기 {
    // 여러 직사각형들이 겹쳐진 형태로 지형이 표현됨.
    // 캐릭터는 이 직사각형의 둘레를 따라 이동 가능하다.
    public int solution(int[][] rectangles, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        int[][] map = new int[51 * 2][51 * 2];

        // Character X, Y : 출발 지점
        // Item X, Y: 도착 지점

        // 가장 짧은 거리를 return -> BFS

        /**
         * 좌표에 2를 곱하는 이유는, 입출력 예 #2에서, (6,4)와 (7,4)를 보면 이해가 되는데, 너비가 1인 직사각형 같은 경우
         * 2차원 배열로 표현하면, { 1, 1 } 로 서로 붙어있기 때문에, BFS 탐색이 내부로 진행될 수 있다.
         * 그래서 2를 곱해서, 확실하게 구분해준 것이다.
         */
        // 둘레만 1로 처리
        for(int[] rectangle: rectangles) {
            int sx = rectangle[0] * 2;
            int sy = rectangle[1] * 2;
            int ex = rectangle[2] * 2;
            int ey = rectangle[3] * 2;

            for(int x = sx; x <= ex; x++) {
                for(int y = sy; y <= ey; y++) {
                    // 테두리가 아닌 영역은 -1로 표기하여, 이동하지 못하도록 좌표를 설정
                    if( x > sx && x < ex && y > sy && y < ey ) {
                        map[x][y] = -1;
                    } else {
                        // 테두리를 1로 색칠해야 하는데
                        if(map[x][y] != -1) {
                            /* 어떤 직사각형의 내부가 된 곳은 절대로 테두리에 포함시키면 안된다!!! */
                            map[x][y] = 1;
                        }
                    }
                }
            }
        }

        // map 초기화 완료 했고, 이제 BFS
        answer = bfs(map, characterX * 2, characterY * 2, itemX * 2, itemY * 2);

        // 최소 이동 거리 (좌표 * 2 했으므로, 이동 거리도 2로 나눈 값이 정답)
        return answer / 2;
    }

    // (sx, sy) -> (ex, ey) 최단 거리 return
    static int bfs(int[][] map, int sx, int sy, int ex, int ey) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<int[]> q = new ArrayDeque<>();

        // 출발점
        q.add(new int[] {sx, sy, 0});
        visited[sx][sy] = true;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int dist = curr[2];

            // 아이템이 있는 목적지에 도착했다면, 최단 거리 dist값을 return
            if( x == ex && y == ey )  {
                return dist;
            }

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 좌표 범위 벗어났나?
                if( nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length ) continue;

                // 방문?
                if( visited[nx][ny] ) continue;

                // 테두리로만 이동 가능하다.
                if( map[nx][ny] != 1 ) continue;

                q.add(new int[] {nx, ny, dist +1});
                visited[nx][ny] = true;
            }
        }

        return 0;
    }
}
