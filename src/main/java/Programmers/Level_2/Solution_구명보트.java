package Programmers.Level_2;

import java.util.*;

public class Solution_구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        // 최대 2명
        // 무게 제한 limit
        // left + right

        int left = 0;
        int right = people.length -1;

        while( left < right ) {
            if( people[left] + people[right] <= limit ) {
                answer++;   // 최적의 경우: 2명이서 보트 탑승
                left++;
                right--;
            } else {
                // left + right > limit
                // 둘의 합이 limit보다 크면, right만 탑승
                answer++;
                right--;
            }
        }

        if( left == right ) {
            answer++;
        }

        return answer;
    }
}
