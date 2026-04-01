package Programmers.Level_2;

import java.util.*;

public class Solution_프로세스 {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        ArrayDeque<int[]> dq = new ArrayDeque<>();

        for(int i = 0; i < priorities.length; i++) {
            dq.addLast(new int[] { i, priorities[i] } );    // {인덱스, 우선순위}
        }

        while( !dq.isEmpty() ) {
            int[] curr = dq.peekFirst();

            int idx = curr[0];
            int pr = curr[1];

            // for(int[] next: dq) {
            //     System.out.print("(" + next[0] + ", " +  next[1] + ") ");
            // }
            // System.out.println();

            boolean hasHigher = false;

            // 더 우선순위가 높은 값이 있다면?
            for(int[] next : dq) {
                if(next[1] > pr) {
                    hasHigher = true;
                    break;
                }
            }

            // 뒤에 다시 넣어줌
            if(hasHigher) {
                dq.addLast(dq.removeFirst());
                continue;
            } else {
                dq.removeFirst();
                answer++;

                // 꺼낸 값이, 우리가 찾는 값이면?
                if( idx == location ) {
                    return answer ;
                }
            }


        }

        return answer;
    }
}
