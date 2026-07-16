package Programmers.Level_1;

import java.util.ArrayList;

public class Solution_모의고사 {
    public int[] solution(int[] answers) {
        int[] answer = {};

        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] count = new int[4];

        for(int i = 0; i < answers.length; i++) {
            if( answers[i] == student1[i % student1.length] ) {
                count[1]++;
            }

            if( answers[i] == student2[i % student2.length] ) {
                count[2]++;
            }

            if( answers[i] == student3[i % student3.length] ) {
                count[3]++;
            }
        }

        // 가장 많이 맞춘 문제 개수
        int maxCount = Integer.MIN_VALUE;
        for(int i = 1; i <= 3; i++) {
            maxCount = Math.max(maxCount, count[i]);
        }

        // 문제를 가장 많이 맞춘 학생 수, 여럿이면 오름차순 return
        ArrayList<Integer> answerList = new ArrayList<>();

        for(int i = 1; i <= 3; i++) {
            if(count[i] == maxCount) {
                answerList.add(i);
            }
        }

        answer = new int[answerList.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
