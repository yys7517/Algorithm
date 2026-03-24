package Programmers.Level_2;

public class Solution_카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        // brown = 2*w + 2*h - 4
        // brown + yellow = w*h
        // yellow = w*h - brown
        // yellow = w*h -2w -2h +4
        // yellow = (w-2)(h-2)

        // yellow의 값이 최소 1이므로, width는 최소 3이다.
        for(int width = 3; width < brown / 2; width++) {
            if( (brown - 2 * width) % 2 == 0) {
                int height = (brown - 2 * width) / 2 + 2;

                if( width * height == brown + yellow && (width-2) * (height-2) == yellow) {
                    if(width >= height) {   // 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
                        return new int[] { width, height };
                    }

                }
            }
        }

        return answer;
    }
}
