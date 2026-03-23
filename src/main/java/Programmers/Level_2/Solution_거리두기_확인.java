package Programmers.Level_2;

import java.util.LinkedList;
import java.util.Queue;

class Solution_거리두기_확인 {
    public int[] solution(String[][] places) {
        int[] answer = {1,1,1,1,1};

        // P: 응시자
        // O: 빈 테이블
        // X: 파티션

        for(int i = 0; i < 5; i++) {
            char[][] map = new char[5][5];

            for(int j = 0; j < 5; j++ ) {
                String line = places[i][j];

                for( int k = 0; k < 5; k++ ) {
                    map[j][k] = line.charAt(k);
                }
            }

            for(int x = 0; x < 5; x++) {
                for(int y = 0; y < 5; y++) {
                    if(map[x][y] == 'P') {
                        if(!bfs(x,y,map)) {
                            answer[i] = 0;
                        }
                    }
                }
            }

        }   // End for places
        return answer;
    }


    private boolean bfs(int sx, int sy, char[][] map) {
        // BFS로 2까지만 탐색
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];

        queue.add(new int[] {sx, sy, 0});
        visited[sx][sy] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!queue.isEmpty()) {
            int[] info = queue.poll();
            int x = info[0];
            int y = info[1];
            int dist = info[2];

            // Queue에서 꺼내온 값이 2이면, 이미 2인 지점까지 다 확인함.
            if(dist >= 2) continue;// 다음으로 거리가 3인 지점을 Queue에서 뽑아와서 확인할 필요 x

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 좌표 범위에서 불가능하거나, 방문된 곳인지..
                if(!isPossible(nx, ny) || visited[nx][ny]) continue;
                if(map[nx][ny] == 'X') continue;    // 파티션은 피해서 간다..

                queue.add(new int[] { nx, ny, dist + 1 });
                visited[nx][ny] = true;

                // 파티션을 지나지 않으면서 맨해튼 거리가 2인 지점에서 또 다른 P를 만난다면
                if(map[nx][ny] == 'P') {
                    return false;   // 거리두기 실패!
                }
            } // End for
        }// End while

        return true;   // 거리두기 성공!
    } // End bfs

    private boolean isPossible(int x, int y) {
        if(x < 0 || x >= 5 || y < 0 || y >= 5) {
            return false;
        }

        return true;
    }
}