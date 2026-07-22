package codex;

import java.util.Arrays;

public class Solution_랜선자르기연습 {
    /**
        문제

        여러 개의 랜선 길이가 주어진다.
        모든 랜선을 길이가 같은 여러 조각으로 자를 때, required개 이상의 조각을 만들 수 있는 가장 긴 조각의 길이를 반환하자.
        랜선은 남는 부분이 있어도 된다.
     */
    public static void main(String[] args) {
        int[] cables1 = {802, 743, 457, 539};
        System.out.println(solution(cables1, 11)); // 200

        int[] cables2 = {10, 15};
        System.out.println(solution(cables2, 5));  // 5

        int[] cables3 = {5};
        System.out.println(solution(cables3, 5));  // 1
    }

    static long solution(int[] cables, int required) {
        long answer = 0;

        // 1. 정렬
        Arrays.sort(cables);

        // 랜선을 모두 같은 길이의 조각으로 잘라서 required 개수만큼 조각을 낼 때
        // 이 조각의 최대 길이는?
        long left = 1L;         // 최소 조각의 길이
        long right = cables[cables.length-1];    // 최악의 경우, 가장 긴 랜선의 길이와 조각의 길이가 같다.

        while(left <= right) {
            long mid = (left + right) / 2;

            long sliced = 0;

            for( int cable: cables ) {
                sliced += cable / mid;

                if( sliced >= required ) break;
            }

            if( sliced >= required ) {
                // 조각의 길이를 더 늘려도 됨
                answer = mid;
                left = mid + 1;
            } else {
                // sliced < required
                // 조각의 길이가 너무 크다. 조각의 길이를 줄여야 함
                right = mid - 1;
            }
        }

        return answer;
    }
}
