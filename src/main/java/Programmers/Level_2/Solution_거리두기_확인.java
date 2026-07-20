package Programmers.Level_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution_거리두기_확인 {
    // (r1, c1), (r2, c2) 사이의 맨해튼 거리 = |r1-r2| + |c1-c2|
    // 행과 열 좌표 차이의 합

    // 응시자 간에는 맨해튼 거리 2 이하이면 안됨, 3이상
    // 사이에 파티션이 있으면 상관없음

    // P - 응시자
    // O - 테이블
    // X - 파티션

    public int[] solution(String[][] places) {
        int[] answer = {};
        answer = new int[5];
        Arrays.fill(answer, 1);

        int idx = 0;

        for( String[] place: places ) {
            char[][] map = new char[5][5];

            for( int i = 0; i < 5; i++ ) {
                for(int j = 0; j < 5; j++) {
                    map[i][j] = place[i].charAt(j);
                }
            }

            for( int i = 0; i < 5; i++ ) {
                for(int j = 0; j < 5; j++) {
                    if(map[i][j] == 'P') {
                        if( !BFS(i,j,map) ) {
                            answer[idx] = 0;
                        }
                    }
                }
            }

            idx++;
        }

        return answer;
    }

    static boolean BFS(int sx, int sy, char[][] map) {
        boolean[][] visited = new boolean[5][5];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {sx, sy, 0});
        visited[sx][sy] = true;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while(!q.isEmpty()) {
            int[] curr = q.poll();

            int x = curr[0];
            int y = curr[1];
            int dist = curr[2];

            // 거리가 2인 부분 까지만 확인하자.
            if(dist >= 2) continue; // 거리가 2인 부분에서 탐색을 계속하면, 거리가 3인 지점을 찾게 된다.

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if( nx < 0 || nx >= 5 || ny < 0 || ny >= 5 ) continue;
                if( map[nx][ny] == 'X' ) continue;  // 파티션인가?
                if( visited[nx][ny] ) continue;     // 방문한 곳인가?

                // 거리 2이하에서 응시자를 발견하면, 거리두기 실패
                if( map[nx][ny] == 'P' ) {
                    return false;
                }

                q.add(new int[] {nx, ny, dist + 1});
                visited[nx][ny] = true;
            }
        }

        return true;
    }
}