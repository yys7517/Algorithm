package Programmers.Level_1;

public class Solution_모의고사 {
    public int[] solution(int[] answers) {
        int[] student1 = {1,2,3,4,5};
        int[] student2 = {2,1,2,3,2,4,2,5};
        int[] student3 = {3,3,1,1,2,2,4,4,5,5};


        int[] counts = new int[3];
        int maxCount = counts[0];

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == student1[i % student1.length]) {
                counts[0]++;
            }

            if(answers[i] == student2[i % student2.length]) {
                counts[1]++;
            }

            if(answers[i] == student3[i % student3.length]) {
                counts[2]++;
            }
        }

        for(int i = 0; i < 3; i++) {
            maxCount = Math.max(maxCount, counts[i]);
        }

        int count = 0;
        for(int i = 0; i < 3; i++) {
            if(counts[i] == maxCount) {
                count++;
            }
        }

        int[] answer = new int[count];
        int idx = 0;

        for(int i = 0; i < 3; i++) {
            if(counts[i] == maxCount) {
                answer[idx++] = i+1;
            }
        }

        return answer;
    }
}
