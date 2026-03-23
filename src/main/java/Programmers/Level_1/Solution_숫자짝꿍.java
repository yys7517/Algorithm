package Programmers.Level_1;

public class Solution_숫자짝꿍 {
    public String solution(String X, String Y) {
        String answer = "";

        StringBuilder sb = new StringBuilder(); // String Builder를 사용하는 것이, String 변수에 += 을 사용하는 것보다 시간을 아낄 수 있다.

        // 0 ~ 9의 숫자로 이루어진 문자열, 각 요소의 개수를 찾아보자.
        int[] xCount = new int[10];
        int[] yCount = new int[10];

        // xCount[i], yCount[i] > 0이고, Math.min(xCount[i], yCount[i]) 만큼, i를 출력

        for(int i = 0; i < X.length(); i++) {
            // int num = Integer.parseInt(String.valueOf(X.charAt(i)));
            int num = X.charAt(i) - '0';    // 숫자로 이루어진 Char - '0'을 하면, 숫자 값을 Int 형으로 변환 할 수 있다.
            xCount[num]++;
        }

        for(int i = 0; i < Y.length(); i++) {
            // int num = Integer.parseInt(String.valueOf(Y.charAt(i)));
            int num = Y.charAt(i) - '0';
            yCount[num]++;
        }

        boolean isDuplicate = false;

        for(int i = 9; i >= 0; i--) {
            if(xCount[i] > 0 && yCount[i] > 0) {
                isDuplicate = true;
                int count = Math.min(xCount[i], yCount[i]);

                for(int j = 0; j < count; j++) {
                    // answer += String.valueOf(i);
                    sb.append(i);
                }
            }
        }

        // 중복되는 값이 없다면, 짝꿍이 없다.
        if(!isDuplicate) {
            return "-1";
        }

        answer = sb.toString();

        // 큰 수부터 내려가면서 반복하는데, 0으로 시작한다? 그럼 짝꿍 중 가장 큰 수가 0이라는 뜻이므로, 0이다.
        if(answer.startsWith("0")) {
            return "0";
        }

        // System.out.println(answer);
        return answer;
    }
}
