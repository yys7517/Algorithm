package Programmers.Level_2;

import java.util.*;

public class Solution_올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            if( s.charAt(i) == '(') {
                // 여는 괄호는 다 push
                deque.addLast(s.charAt(i));
            } else {
                // 닫는 괄호를 만나면, 스택에서 꺼내온다.
                if(deque.isEmpty()) {
                    return false;   // 스택이 비어있다면, false
                } else {
                    // 스택에 값이 있다면, 꺼내와서 괄호 매칭
                    deque.removeLast();
                }
            }
        }

        if(!deque.isEmpty()) return false;

        return true;
    }
}
