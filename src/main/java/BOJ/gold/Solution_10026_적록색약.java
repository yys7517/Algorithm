package BOJ.gold;

import java.util.*;
import java.io.*;

public class Solution_10026_적록색약 {
    static int N;
    static char[][] map;
    static boolean[][] visited;

    static int[] dx = { -1,1,0,0 };
    static int[] dy = { 0,0,1,-1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st;

        // st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for(int i = 0; i < N; i++) {
            // st = new StringTokenizer(br.readLine(), " ");
            String line = br.readLine();
            for(int j = 0; j < line.length(); j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int[] answer = new int[2];

        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if( !visited[i][j] ) {
                    answer[0]++;
                    bfs( i, j, visited );
                }
            }
        }

        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if( !visited[i][j] ) {
                    answer[1]++;
                    bfs_RG( i, j, visited );
                }
            }
        }

        System.out.println( answer[0] + " "  + answer[1] );
    }

    static void bfs(int sx, int sy, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();

        q.add ( new int[] { sx, sy });
        visited[sx][sy] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();

            int x = curr[0];
            int y = curr[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if( nx < 0 || ny < 0 || nx >= N || ny >= N ) continue;
                if( visited[nx][ny] ) continue;

                if( map[nx][ny] != map[sx][sy] ) continue;

                visited[nx][ny] = true;
                q.add( new int[] {nx, ny});
            }
        }
    }

    static void bfs_RG(int sx, int sy, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();

        q.add ( new int[] { sx, sy });
        visited[sx][sy] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();

            int x = curr[0];
            int y = curr[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if( nx < 0 || ny < 0 || nx >= N || ny >= N ) continue;
                if( visited[nx][ny] ) continue;

                // 시작점이 R or G 일 때, B를 만나면 스킵
                if( map[sx][sy] == 'R' || map[sx][sy] == 'G' ) {
                    if( map[nx][ny] == 'B' ) continue;
                }

                // 시작점이 B 일 때, R, G를 만나면 스킵
                if( map[sx][sy] == 'B' ) {
                    if( map[nx][ny] == 'R' || map[nx][ny] == 'G' ) continue;
                }

                visited[nx][ny] = true;
                q.add( new int[] {nx, ny});
            }
        }
    }
}
