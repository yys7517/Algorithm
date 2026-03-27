package BOJ.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드2 {
    static int N, M;
    static StringBuilder sb;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt( st.nextToken() );
        }

        // M = Integer.parseInt(br.readLine());

        // visited = new boolean[N+1];
        // sb = new StringBuilder();
        // answer = new int[M];
        M = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        Arrays.sort(arr);

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++) {
            int num = Integer.parseInt( st1.nextToken() );

            int count = getUpperBound(num) - getLowerBound(num);

            sb.append(count).append(" ");
        }

        System.out.println(sb);
    }

    // num보다 초과하는 값의 첫 번째 인덱스
    static int getUpperBound(int num) {
        int left = 0;
        int right = arr.length;

        while(left < right) {
            int mid = (left + right) / 2;

            if(arr[mid] > num) {
                // 너가 num보다 커?
                // 그럼 왼쪽도 더 볼게
                right = mid;
            } else {
                // arr[mid] <= num
                // num보다 작거나 같아?
                // 난 초과하는 값을 찾아야해
                left = mid + 1;
            }
        }

        return right;
    }

    // num이 있다면, num의 첫 번째 인덱스
    static int getLowerBound(int num) {
        int left = 0;
        int right = arr.length;

        while(left < right) {
            int mid = (left + right) / 2;

            if(arr[mid] >= num) {
                // 너가 num보다 크거나 같아?
                // 그럼 왼쪽에 더 있는지 보자
                right = mid;
            } else {
                // num보다 작아?
                left = mid + 1;
            }
        }

        return right;
    }
}
