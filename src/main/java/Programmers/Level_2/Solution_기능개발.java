package Programmers.Level_2;

import java.util.*;

public class Solution_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        int[] times = new int[speeds.length];

        for(int i = 0; i < speeds.length; i++) {
            int remain = 100 - progresses[i];       // 남은 %
            int time = remain % speeds[i] == 0 ? remain / speeds[i] : remain / speeds[i] + 1;          // 걸리는 시간
            // 남은 시간이 작업 속도로 나누어질 때랑, 딱 안 나누어질 때랑 나눠야함.

            // System.out.print(remain + " ");
            // System.out.print(time + " ");

            times[i] = time;
            deque.addLast(time);
        }

        // System.out.println();

        List<Integer> list = new ArrayList<>();

        while( !deque.isEmpty() ) {
            int currTime = deque.removeFirst();
            // System.out.print(currTime + " ");
            int count = 1;

            if( !deque.isEmpty() ) {
                // System.out.println(deque.peekFirst());

                if( deque.peekFirst() > currTime ) {
                    // 다음 기능이 개발되기까지 더 남았을 때
                    list.add(count);
                } else {
                    // 다음 기능들이 현재 기능보다 더 빨리 개발되었을 때
                    while( !deque.isEmpty() && deque.peekFirst() <= currTime ) {
                        deque.removeFirst();
                        count++;
                    }

                    list.add(count);
                }
            } else {
                list.add(count);
            }
        }

        // for(int num: list) {
        //     System.out.print(num + " ");
        // }


        return list.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
