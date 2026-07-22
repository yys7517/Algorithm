package codex;

public class Solution_파괴되지않은건물 {
    // skill의 각 행은 [type, r1, c1, r2, c2, degree]형태
    // type - 1 (적의 공격)
    // type - 2 (회복)
    // degree - 공격력(1) or 회복력(2)
    public int solution(int[][] board, int[][] skills) {
        int answer = 0;

        int rows = board.length;
        int cols = board[0].length;

        int[][] changes = new int[rows+1][cols+1];

        for(int[] skill: skills) {
            int type = skill[0];
            int r1 = skill[1];
            int c1 = skill[2];
            int r2 = skill[3];
            int c2 = skill[4];
            int degree = skill[5];

            if( type == 1 ) degree *= -1;

            changes[r1][c1] += degree;
            changes[r1][c2+1] -= degree;

            changes[r2+1][c1] -= degree;
            changes[r2+1][c2+1] += degree;
        }
        /*
            -4 0 0 0 0 +4
            0
            0
            0
            0
            +4
         */

        // 가로 누적합
        for(int row = 0; row <= rows; row++) {
            for(int col = 1; col <= cols; col++) {
                changes[row][col] += changes[row][col-1];
            }
        }

        // 세로 누적합
        for(int row = 1; row <= rows; row++) {
            for(int col = 0; col <= cols; col++) {
                changes[row][col] += changes[row-1][col];
            }
        }

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                board[row][col] += changes[row][col];

                if( board[row][col] > 0 ) answer++;
            }
        }

        return answer;
    }
}
