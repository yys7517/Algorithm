package Programmers.Level_2;

import java.util.*;

public class Solution_구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0; // 모든 사람을 구출하기 위해 필요한 구명보트 갯수

        int n = people.length;  // people[] - 사람들의 무게

        // 무게 기준 오름차순으로 정렬
        Arrays.sort(people);

        // 하나의 구명보트에는 최대 2명, 무게 제한 limit
        int left = 0;
        int right = n-1;

        while(left <= right) {
            // 딱 한 명만 남은 경우
            if(left == right) {
                answer++;
                break;
            }

            if( people[left] + people[right] <= limit ) {
                left++;
                right--;

                answer++;   // 둘이 같이 타기
            } else {
                // left + right > limit

                // 둘이 같이 못 타니까, 무거운 사람 혼자 타기 (오름차순 정렬)
                right--;
                answer++;
            }
        }

        return answer;
    }
}
