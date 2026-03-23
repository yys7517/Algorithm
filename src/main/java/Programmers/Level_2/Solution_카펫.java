package Programmers.Level_2;

public class Solution_카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        // brown = 2*w + 2*h - 4


        // 4 <= w + h - 2 <= 2500
        // 6 <= w + h <= 2502

        // brown + yellow = w*h
        // yellow = w*h - brown
        // yellow = w*h -2w -2h +4
        // yellow = (w-2)(h-2)

        for(int h = 0; h < 2500; h++) {
            for(int w = h; w < 2500; w++) {
                if(brown == 2*w + 2*h - 4 && w*h == brown + yellow) {
                    return new int[] {w, h};
                }
            }
        }

        return new int[] {0, 0};
    }
}
