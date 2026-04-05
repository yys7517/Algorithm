package BOJ.silver;

import java.io.*;
import java.util.*;

public class BOJ_용돈관리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;

        // N일
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); // M번 통장에서 인출

        int max = 0;
        int total = 0;

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max( max, arr[i] );
            total += arr[i];
        }

        int answer = 0;

        // Arrays.sort(arr); // i일에 사용할 금액을 순서대로 나열한거라서 정렬하면 안됨

        int left = max;     // 최대 금액은 인출해야 하루는 쓸 수 있음
        int right = total;  // 전체 통장 금액

        while(left <= right) {
            int K = (left + right) / 2;
            int count = 1;
            int currentMoney = K; // 현재 주머니에 가진 돈

            for(int i = 0; i < arr.length; i++) {
                if(currentMoney < arr[i]) {
                    // 모자라면, 통장에서 다시 K원을 인출
                    currentMoney = K;
                    count++;
                }

                currentMoney -= arr[i];   // 그 날 사용
            }

            if( count > M ) {
                left = K + 1;
            } else {
                // count <= M
                answer = K;
                right = K - 1;
            }
        }

        System.out.println(answer);
    }
}
