package Programmers.Level_4;

import java.util.Arrays;

public class Solution_징검다리 {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        // 이분 탐색의 제일 첫 번째 - 정렬
        Arrays.sort(rocks);

        // 바위 사이의 거리를 몇으로 해야 n개를 제거할 수 있을까?
        // 바위 사이의 거리, 각 지점 사이의 거리의 최솟값 중에 가장 큰 값을 찾아야 함!
        int left = 1;   // 최소: 1
        int right = distance;  // distance

        while( left <= right ) {
            int mid = (left + right) / 2;   // 각 지점 사이의 거리 최솟값

            int needRemovals = 0;       // 각 지점 사이의 거리 중 최솟값인 mid를 만족하기 위해 제거해야 하는 돌의 갯수
            int current = 0;

            for( int rock: rocks ) {
                if( rock - current >= mid ) {   // mid보다 커야 이동함.
                    current = rock;
                } else {
                    // 사이 거리가 mid보다 작으므로, 바위 제거
                    needRemovals++;
                }
            }

            // 마지막 지점에서 도착 지점까지 이동
            if( distance - current < mid ) {
                // mid보다 간격이 좁으면, 바위를 더 제거해야 한다.
                needRemovals++;
            }

            if( needRemovals > n ) {
                // 바위 제거하는 개수를 줄이려면, 지점 사이의 거리 최솟값인 mid값을 더 줄여도 됨
                right = mid - 1;
            } else {
                // removeCount <= n
                answer = mid;   // n개의 바위를 제거한 것이라면, 정답이 될 수도 있음.

                // 제거 개수가 n개보다 적다면 ? 바위를 더 제거해도 됨. mid 값을 늘리자. (가능한 mid의 최댓값을 찾아야함.)
                left = mid + 1;
            }
        }

        return answer;
    }
}
