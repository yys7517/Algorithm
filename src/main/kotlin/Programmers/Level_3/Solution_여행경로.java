package Programmers.Level_3;

import java.util.*;

public class Solution_여행경로 {
    public String[] solution(String[][] tickets) {
        List<String> path = new ArrayList<>();
        boolean[] visited = new boolean[tickets.length];

        // 출발 지점이 같다면, 도착지점을 기준으로 오름차순 정렬
        Arrays.sort(tickets,
                (a, b) -> a[0].equals(b[0]) ? a[1].compareTo(b[1]) : a[0].compareTo(b[0])
        );

        // ICN 출발
        path.add("ICN");
        int count = 0;
        dfs("ICN", path, tickets, visited, count);

        return path.toArray(new String[0]);
    }

    // 모든 항공권을 사용할 수 있는지 아닌지, 경로를 다시 되돌아오기 위한 boolean 값 설정
    static boolean dfs(String curr, List<String> path, String[][] tickets, boolean[] visited, int count) {
        // 티켓을 모두 사용한 경우, 종료. true 반환
        if(count == tickets.length) {
            return true;
        }

        for(int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];
            // curr과 같은 출발지점 티켓이고, 사용하지 않은 티켓이라면
            if( !visited[i] && ticket[0].equals(curr) ) {
                String dest = ticket[1];
                visited[i] = true;
                path.add(dest);

                // 백트래킹 종료 전파
                if( dfs(dest, path, tickets, visited, count + 1) ) {
                    return true;    // 이미 티켓을 모두 사용하고, 경로를 모두 출력했을 경우 종료.
                }

                // 티켓을 모두 사용하지 못했다면 BackTracking을 통해, 방문을 취소하고, 경로 다시 탐색
                visited[i] = false;
                path.remove( path.size() - 1 );
            }
        }

        return false;
    }
}
