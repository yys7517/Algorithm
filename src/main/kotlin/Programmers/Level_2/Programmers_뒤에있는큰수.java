package Programmers.Level_2;

import java.util.Arrays;
import java.util.Stack;

public class Programmers_뒤에있는큰수 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        // 기본 값을 뒷 큰 수가 없을 경우로 해서, -1로 초기화
        // for(int i = 0; i < numbers.length; i++) {
        //     answer[i] = -1;
        // }

        // 미리 -1로 채워두면 나중에 뒷 큰수가 없는 경우를 따로 처리할 필요가 없습니다.
        Arrays.fill(answer, -1);

        Stack<Integer> stack = new Stack<>();

        // 역순으로 탐색할 수 있다.
        // 뒤에 있는 수를 Stack에 저장하고, 배열의 앞으로 향하면서, 스택에 있는 수가 더 작다면, 버려버린다.
        for(int i = numbers.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() <= numbers[i]) {
                // numbers[i] = 현재 수.
                // stack.peek(), 스택에 있는 수 = 현재 수보다 뒤에 있는 수
                // 근데 그 수가 현재 수보다 작거나 같다? 그러면 버린다.
                stack.pop();
            }

            if(stack.isEmpty()) {
                answer[i] = -1;
            } else {
                answer[i] = stack.peek();   // peek()을 하는 이유는 현재 뒷 큰수가 앞에 있는 수의 뒷 큰수가 될 수 있다
                // 이해가 안되면 그림 그려보자
            }

            stack.push(numbers[i]);
        }


        return answer;
    }
}
