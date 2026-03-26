package Programmers.Level_1;

import java.util.*;

public class Solution_같은숫자는싫어 {
    public int[] solution(int []arr) {
        int[] answer = {};

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < arr.length; i++) {
            if( !deque.isEmpty() && deque.peekLast() == arr[i] ) continue;
            deque.addLast(arr[i]);
        }

        int size = deque.size();
        answer = new int[size];
        int idx = 0;

        while(!deque.isEmpty()) {
            answer[idx++] = deque.peekFirst();
            deque.removeFirst();
        }

        return answer;
    }
}
