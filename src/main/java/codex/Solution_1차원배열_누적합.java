package codex;

import java.util.Arrays;

public class Solution_1차원배열_누적합 {
    public static void main(String[] args) {
        int[] numbers = {5, 1, 3, 7, 2};

        int[][] queries = {
                {0, 2},
                {1, 3},
                {3, 4}
        };

        long[] result = solution(numbers, queries);

        System.out.println(Arrays.toString(result));
    }

    static long[] solution(int[] numbers, int[][] queries) {
        // prefix 배열 길이 = target 배열의 길이 + 1
        long[] prefix = new long[numbers.length + 1];

        for(int i = 0; i < numbers.length; i++) {
            prefix[i+1] = prefix[i] + numbers[i];
        }

        System.out.println(Arrays.toString(prefix));
        long[] answer = new long[queries.length];

        for(int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            // left ~ right 누적합 : [right + 1] - [left]
            answer[i] = prefix[right+1] - prefix[left];
        }

        return answer;
    }
}
