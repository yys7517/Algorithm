package BOJ.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_N_Queen {
    static int N;
    static int[] map;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N+1]; // 1차원 배열 - 인덱스를 가로 행, 값을 세로 열로 두자.
        count = 0;

        backtracking(1);  // 1행부터

        System.out.println(count);
    }

    static void backtracking(int row) {
        // N개의 퀸을 모두 설치했다면, 재귀 호출시 N + 1
        // count 증가 시키고 return, 다른 경우의 수 찾으러 가기
        if(row == N + 1) {
            count++;
            return;
        } else {
            for( int col = 1; col <= N; col++ ) {
                if( check(row, col) ) {
                    // row행 col열에 설치할 수 있나?
                    map[row] = col;
                    backtracking(row + 1);
                }
            }
        }
    }

    static boolean check(int row, int col) {
        for(int i = 1; i < row; i++) {
            // 1. 같은 열에 배치된 퀸이 있는가?
            if( map[i] == col ) {
                return false;
            }

            // 2. 1차원 배열 map을 쓰기 때문에, 행에 대한 처리는 필요없다.
            // 인덱스 값이 row, map[row]값이 col

            // 3. 행과 열의 차이가 같으면, 대각선이다. (0,0), (1,1)
            if( Math.abs(i-row) == Math.abs(map[i] - col) ) {
                return false;
            }
        }

        return true;
    }
}
