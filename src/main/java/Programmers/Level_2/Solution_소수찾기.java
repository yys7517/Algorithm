package Programmers.Level_2;

import java.util.*;

public class Solution_소수찾기 {
    static Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];

        permutation("", 0, numbers, visited);

        int answer = set.size();

        return answer;
    }

    static void permutation(String curr, int index, String numbers, boolean[] visited) {
        // 빈 값이 아니고, 소수 값이라면 set에 더해준다.
        if( !curr.equals("") && isPrime(Integer.parseInt(curr))) {
            set.add(Integer.parseInt(curr));
        }

        for(int i = 0; i < numbers.length(); i++) {

            if( !visited[i] ) {
                visited[i] = true;
                permutation(curr + numbers.charAt(i), index + 1, numbers, visited);
                visited[i] = false;
            }
        }
    }

    // 1과 자기 자신으로만 나누어지는 수
    static boolean isPrime(int num) {
        if( num < 2 ) return false;

        for(int i = 2; i <= Math.sqrt(num); i++) {
            if( num % i == 0 ) return false;
        }

        return true;
    }
}
