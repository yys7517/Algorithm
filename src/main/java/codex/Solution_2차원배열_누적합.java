package codex;

import java.util.Arrays;

public class Solution_2차원배열_누적합 {
    public static void main(String[] args) {
        int[][] board = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9, 10, 11, 12}
        };

        int[][] queries = {
                {0, 0, 1, 1},
                {1, 1, 2, 3},
                {0, 2, 2, 3}
        };

        long[] result = solution(board, queries);
        System.out.println(Arrays.toString(result));        // [14,54,45]
    }

    static long[] solution(
            int[][] board,
            int[][] queries
    ) {
        int rows = board.length;
        int cols = board[0].length;

        long[][] prefix = new long[rows + 1][cols + 1];

        // 1. 가로 방향으로 누적합 구하기
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= cols; j++) {
                prefix[i][j] = prefix[i][j-1] + board[i-1][j-1];
            }
        }

        // 2. 세로 방향으로 누적합 구하기
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= cols; j++) {
                prefix[i][j] += prefix[i-1][j];
            }
        }

        long[] answer = new long[queries.length];

        int idx = 0;

        for(int[] query: queries) {
            int r1 = query[0];
            int c1 = query[1];

            int r2 = query[2];
            int c2 = query[3];

            // 2. 각 직사각형의 합 구하기
            answer[idx++] = prefix[r2+1][c2+1]
                    - prefix[r2+1][c1]
                    - prefix[r1][c2+1]
                    + prefix[r1][c1];
        }

        return answer;
    }
}
