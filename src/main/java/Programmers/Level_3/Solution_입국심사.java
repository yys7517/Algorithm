package Programmers.Level_3;

import java.util.Arrays;

public class Solution_입국심사 {
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);

        // *** 모든 사람이 심사를 받는데 걸리는 시간을 최소로 하고싶다 ***
        long left = times[0];   // 최소 : 1명 * 최소 시간
        long right = (long) times[times.length-1] * n; // 최악 : n명이 제일 오래 걸리는 심사관한테

        while( left <= right ) {
            long mid = (left + right) / 2;  // 모든 사람이 심사 받는데 걸리는 시간이라면?

            // mid 시간 동안, 심사관들은 몇 명을 체크인 할 수 있을까?
            long checked = 0L;

            for(int time: times) {
                checked += mid / time;

                if( checked >= n ) break;   // 불필요한 연산을 줄일 수 있다.
            }

            if( checked < n ) {
                // mid 값이 더 커져야 함.
                left = mid + 1;
            } else {
                // checked >= n
                // 현재 mid가 정답이거나, mid값을 더 작게 해서, 최솟값을 찾을 수 있음
                answer = mid;
                right = mid - 1;
            }
        }

        return answer;
    }
}
