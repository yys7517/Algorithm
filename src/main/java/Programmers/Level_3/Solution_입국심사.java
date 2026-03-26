package Programmers.Level_3;

import java.util.Arrays;

public class Solution_입국심사 {
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);

        long left = times[0];    // 최소 = 1명 * 최소시간
        long right = (long) times[times.length - 1] * n; // 최악 = 최대시간 * n

        while (left <= right) {
            long mid = (left + right) / 2;   // 이 정도 시간이면 모두 심사가 가능한가?

            long checked = 0L;
            for (int i = 0; i < times.length; i++) {
                // 각 심사위원들이 mid 시간동안 check-in할 수 있는 인원 수
                checked += mid / times[i];
            }

            if (checked >= n) {
                answer = mid;   // 정답이 될 수도 있다.
                right = mid - 1; // 더 적은 시간안에 할 수 있지 않을까?
            } else {
                // checked < n
                // n명을 체크인하려면 더 많은 시간이 필요하다
                left = mid + 1;
            }
        }

        return answer;
    }
}
