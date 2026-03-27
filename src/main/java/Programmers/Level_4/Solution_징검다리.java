package Programmers.Level_4;

import java.util.Arrays;

public class Solution_징검다리 {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        // 1. left, right값 설정 - 최소 경우의 수, 최악 경우의 수
        // 바위를 제거한 후의, 최대 거리를 구하는 것이므로, 거리를 기준으로 설정
        int left = 0;
        int right = distance;

        // 2.. 탐색할 배열은 무조건 오름차순 정렬
        Arrays.sort(rocks);

        while( left <= right ) {
            // 3. mid 값 설정 후 탐색 진행
            int mid = (left + right) / 2;

            int prev = 0;
            int removeCount = 0;

            for(int i = 0; i < rocks.length; i++) {
                if( rocks[i] - prev >= mid ) {
                    // 바위 간 거리 최소 값 이상을 만족해??
                    prev = rocks[i];    // 그럼 이동!!
                } else {
                    removeCount++;  // 그럼 이 바위는 쓸모 없으니 제거하자.
                }
            }

            // 마지막 바위 지점 - 도착지점
            if( distance - prev < mid ) {
                // 마지막 구간이 최소 값 보다 작으면
                removeCount++; // prev에 위치한 바위도 제거!
            }

            if( removeCount > n ) {
                // 너무 많이 제거했어?
                // mid 값을 줄여서, 바위 제거 개수를 줄이자. mid값보다 크거나 같을 때만 이동시키고 있다.
                right = mid-1;
            } else {
                // removeCount <= n
                // 바위 제거 개수가 작거나 같아?
                // 같으면 정답이 되고!!,
                answer = mid;
                left = mid + 1; // 더 적다면, mid값을 늘려보자
            }
        }

        return answer;
    }
}
