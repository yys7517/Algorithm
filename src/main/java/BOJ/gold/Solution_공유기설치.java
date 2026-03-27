package BOJ.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_공유기설치 {
    static int N, C;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        int answer = 0;

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 1. 순서대로 정렬
        Arrays.sort(arr);

        if( C == 2 ) {
            answer = arr[N-1] - arr[0];
        } else {
            // 2. left, right값 설정
            // 거리를 기준으로 left, right값을 설정해야 할듯
            int left = 1;
            int right = arr[N-1] - arr[0];


            while(left <= right) {
                int mid = (left + right) / 2;
                int prev = arr[0];
                int count = 1;  // 공유기 설치 수

                for(int i = 1; i < N; i++) {
                    if( arr[i] - prev >= mid ) {
                        prev = arr[i];
                        count++;
                    }
                }

                if(count >= C) {
                    answer = mid;
                    // count가 오히려 더 많으면
                    // mid값을 늘려서, count를 C에 가깝게 줄여보자
                    left = mid + 1;
                } else {
                    // count < C
                    // 공유기 설치를 해야되는데, C개 만큼, 근데 설치 수가 너무 적다면, mid값이 너무 큰것,
                    right = mid -1;
                }
            }
        }

        System.out.println(answer);
    }
}
