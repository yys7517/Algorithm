package Programmers.Level_2;

import java.util.*;

public class Solution_더_맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        // 가장 맵지 않은 음식을 2개 골라서, 섞고

        // 이걸 계속 반복,, 모두 K 이상일 때까지

        // 오름차순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(a, b));

        for(int i = 0; i < scoville.length; i++) {
            pq.add( scoville[i] );
        }

        while(!pq.isEmpty()) {
            if(pq.peek() < K) {
                // K보다 낮은 음식이 있다면
                int a = pq.poll();

                if(!pq.isEmpty()) {
                    int b = pq.poll();
                    int mixed = a + ( b * 2 );

                    pq.add(mixed);
                    answer++;
                } else {
                    // 섞을 음식이 없는데, 스코빌이 K보다 낮다면
                    return -1;
                }
            }

            // 모든 음식이 스코빌 지수가 K이상이면 종료
//             boolean allPass = true;

//             for(int sco: pq) {
//                 if( sco < K ) allPass = false;
//             }

//             if(allPass) break;

            // 시간 초과 발생

            // PQ라서 가장 앞에 있는 값만 확인해도 됨 !!
            if(pq.peek() >= K) break;
        }

        return answer;
    }
}
