package Programmers.Level_2;

public class Solution_타겟넘버 {
    public int solution(int[] numbers, int target) {
        int answer = 0;

        answer = dfs(numbers, 0, 0, target);

        return answer;
    }

    static int dfs(int[] numbers, int idx, int sum, int target) {
        if( idx == numbers.length ) {   // idx가 length와 같을 때는, 모든 수를 조회 완료한거임
            if( sum == target ) return 1;   // 타겟 넘버면 방법의 수 1 리턴

            return 0;
        }

        return dfs(numbers, idx + 1, sum + numbers[idx], target) + dfs(numbers, idx + 1, sum - numbers[idx], target);
    }
}
