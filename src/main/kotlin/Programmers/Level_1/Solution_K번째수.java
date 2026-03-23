package Programmers.Level_1;

import java.util.Arrays;

public class Solution_K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int c = 0; c < commands.length; c++) {
            int[] command = commands[c];

            int i = command[0]; // 2
            int j = command[1]; // 5
            int k = command[2]; // 3

            int[] arr = new int[j-i+1];

            // i번째 수의 인덱스는 i-1이다.
            for(int idx = 0; idx < arr.length; idx++) {
                arr[idx] = array[i-1+idx];
                // System.out.println(arr[idx]);
            }

            // System.out.println();
            Arrays.sort(arr);

            for(int idx = 0; idx < arr.length; idx++) {
                // System.out.println(arr[idx]);
            }
            // System.out.println();

            answer[c] = arr[k-1];
        }

        return answer;
    }
}
