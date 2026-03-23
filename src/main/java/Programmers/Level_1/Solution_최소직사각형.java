package Programmers.Level_1;

public class Solution_최소직사각형 {

    public int solution(int[][] sizes) {
        int maxOfMin = 1;
        int maxOfMax = 1;

        for(int i = 0; i < sizes.length; i++) {
            maxOfMax = Math.max( maxOfMax, Math.max(sizes[i][0], sizes[i][1]));
            maxOfMin = Math.max( maxOfMin, Math.min(sizes[i][0], sizes[i][1]));
        }

        System.out.println(maxOfMax);
        System.out.println(maxOfMin);

        return maxOfMin * maxOfMax;
    }
}
