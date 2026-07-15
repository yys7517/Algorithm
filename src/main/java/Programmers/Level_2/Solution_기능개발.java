package Programmers.Level_2;

import java.util.*;

public class Solution_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        // int[] days = new int[progresses.length];
        ArrayDeque<Integer> days = new ArrayDeque<>();

        for(int i = 0; i < speeds.length; i++) {
            int day = (100 - progresses[i]) % speeds[i] == 0 ?
                    (100 - progresses[i]) / speeds[i]
                    : ((100 - progresses[i]) / speeds[i]) + 1;

            // days[i] = day;
            days.add(day);
        }

        // for(int i = 0; i < days.length; i++) {
        //     System.out.printf("%d ", days[i]);
        // }

        ArrayList<Integer> answerList = new ArrayList<>();

        while( !days.isEmpty() ) {
            int curr = days.poll();
            int count = 1;

            // 남은 완료일자가 있는지 && 그 업무가 이미 완료된 업무인지
            while( !days.isEmpty() && days.peekFirst() <= curr ) {
                days.removeFirst();
                count++;
            }

            answerList.add(count);
        }

        // List 내용을 Array로 Copy
        answer = new int[answerList.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
