package Programmers.Level_1;

import java.util.*;

public class Solution_체육복 {
    // 잃어 버린 학생 - lost
    // 여벌 옷이 있는 학생 - reserve
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;

        int[] people = new int[n];      // 학생의 체육복 개수를 저장
        Arrays.fill(people, 1);

        for(int r: reserve) {
            people[r-1]++;
        }

        for(int l: lost) {
            people[l-1]--;
        }

        for(int i = 0; i < n; i++) {
            if( people[i] == 0 ) {
                // 여벌 체육복이 없지만 잃어버린 학생

                // 바로 앞 번호의 학생이나, 바로 뒷 번호의 학생이 잃어버린 학생에게 체육복을 빌려줄 수 있다.
                // 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다.
                if( i-1 >= 0 && people[i-1] > 1 ) {
                    people[i-1]--;
                    people[i]++;
                } else if( i+1 < n && people[i+1] > 1 ) {
                    people[i+1]--;
                    people[i]++;
                } else{
                    answer--;
                }
            }
        }

        return answer;
    }
}
