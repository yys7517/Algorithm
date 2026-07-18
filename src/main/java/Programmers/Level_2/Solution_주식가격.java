package Programmers.Level_2;

import java.util.*;

public class Solution_주식가격 {
    static int a;

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();   // 인덱스를 넣는다.

        for(int curr = 0; curr < prices.length; curr++) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[curr] ) {
                // 스택에 있는 인덱스 - curr 이전의 인덱스잖아
                // 그럼 이전의 인덱스에 위치한 값이 더 크면? 가격이 떨어진거니까

                int previous = stack.pop();     // 이전 가격의 "시점"
                answer[previous] = curr - previous;
            }

            stack.push(curr);
        }

        // 가격이 한 번도 안 떨어진 애들은 마지막에 Stack에 남아있다.
        while(!stack.isEmpty()) {
            int curr = stack.pop();

            // 전체 시간 - 현재 시간
            answer[curr] = prices.length - 1 - curr;
        }

        return answer;
    }
}
