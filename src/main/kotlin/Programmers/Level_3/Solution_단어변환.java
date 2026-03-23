package Programmers.Level_3;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_단어변환 {
    static class WordState {
        String word;
        int count;

        WordState(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public int solution(String begin, String target, String[] words) {
        boolean hasTarget = false;

        // 배열은 contains를 사용할 수 없음
        for(int i = 0 ; i < words.length; i++) {
            if( words[i].equals(target) ) {
                hasTarget = true;
            }
        }

        // 변환할 수 없는 경우에는
        if( !hasTarget ) {
            return 0;
        }

        WordState state = new WordState(begin, 0);

        int answer = bfs(state, target, words);

        return answer;
    }

    private static int bfs(WordState state, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<WordState> queue = new LinkedList<>();

        queue.add(state);

        while( !queue.isEmpty() ) {
            WordState curr = queue.poll();

            String currWord = curr.word;
            int currCount = curr.count;

            // System.out.println(currWord);

            if( currWord.equals(target) ) {
                return currCount;
            }

            for(int i = 0; i < words.length; i++) {
                // 이미 체크한 단어가 아니고, 변환 가능하다면
                if( !visited[i] && canConvert( currWord, words[i]) ) {
                    // System.out.println(words[i]);
                    visited[i] = true;
                    queue.add( new WordState( words[i], currCount + 1) );
                }
            }   // End for
        }   // End While

        return 0;
    }

    /** 한 번에 한 개의 알파벳만 바꿀 수 있다. */
    private static boolean canConvert(String curr, String next) {
        int diffCount = 0;

        for(int i = 0; i < curr.length(); i++) {
            if( curr.charAt(i) != next.charAt(i) ) {
                diffCount++;
            }
        }

        return diffCount == 1;
    }
}
