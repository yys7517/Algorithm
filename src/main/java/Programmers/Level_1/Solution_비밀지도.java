package Programmers.Level_1;

import java.util.*;

public class Solution_비밀지도 {
    static String[][] map;

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        map = new String[n][n];

        for(int i = 0; i < n; i++) {
            Arrays.fill(map[i], " ");
        }

        for(int i = 0; i < n; i++) {
            int num = arr1[i];
            int idx = 0;

            while( num != 0 ) {
                map[i][n-1-idx] = num % 2 == 1 ? "#" : " ";
                num /= 2;
                idx++;
            }
        }

        for(int i = 0; i < n; i++) {
            int num = arr2[i];
            int idx = 0;

            while( num != 0 ) {
                if(map[i][n-1-idx].equals("#")) {
                    idx++;
                    num /= 2;

                    continue;
                }

                map[i][n-1-idx] = num % 2 == 1 ? "#" : " ";

                idx++;
                num /= 2;
            }
        }

        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();

            for(int j = 0; j < n; j++) {
                sb.append(map[i][j]);
            }

            answer[i] = sb.toString();
        }

        return answer;
    }
}
