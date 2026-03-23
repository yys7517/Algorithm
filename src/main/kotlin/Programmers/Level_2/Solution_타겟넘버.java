package Programmers.Level_2;

public class Solution_타겟넘버 {

    public int solution(int[] numbers, int target) {
        int index = 0;
        int sum = 0;
        int answer = dfs(numbers, target, index, sum);

        return answer;
    }


    private static int dfs(int[] numbers, int target, int index, int sum) {
        // 모든 숫자를 사용했을 때, index 값은 numbers의 인덱스 범위를 벗어난다. ( = 모든 수를 탐색했다)
        if( index >= numbers.length ) {
            if( sum == target ) {   // target과 같다면, 하나의 방법을 찾은거다.
                return 1;
            } else {
                return 0;   // target값이 아니면 그건 방법이 아니다.
            }
        }

//        더하거나 빼서 target값을 만들기 위해
//        if(index >= 0 && index < numbers.length) {
//            int add = dfs(numbers, target, index + 1, sum + numbers[index]);
//            int sub = dfs(numbers, target, index + 1, sum - numbers[index]);
//
//            return add + sub;
//        }
//
//        return 0;

        int add = dfs(numbers, target, index + 1, sum + numbers[index]);
        int sub = dfs(numbers, target, index + 1, sum - numbers[index]);

        return add + sub;
    }
}
