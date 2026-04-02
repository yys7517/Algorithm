package BOJ.silver;

import java.io.*;
import java.util.*;

public class Solution_계단오르기 {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[301];
        int[] dp = new int[301];

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // dp[i] = 계단의 i번째 칸을 무조건 밟는 다는 전제 하에 최대 값
        dp[1] = arr[1];
        if( n >= 2 ) dp[2] = arr[1] + arr[2];

        for(int i = 3; i <= n; i++) {
            dp[i] = Math.max(
                    dp[i-3] + arr[i-1] + arr[i],
                    dp[i-2] + arr[i]
            );
        }

        System.out.println(dp[n]);
    }
}
