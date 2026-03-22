package Programmers.Level_3;

import java.util.*;

public class Solution_여행경로 {
    public String[] solution(String[][] tickets) {
        List<String> path = new ArrayList<>();              // 경로
        boolean[] visited = new boolean[tickets.length];    // 티켓 사용 여부를 체크하는 방문 배열

        // 만일 가능한 경로가 2개 이상일 경우에는 알파벳 순서가 앞서는 경로를 return
        Arrays.sort(tickets,
                (a, b) -> a[0].equals(b[0]) ? a[1].compareTo(b[1]) : a[0].compareTo(b[0])
        );  // 출발 지점이 같다면, 도착지점 기준으로 오름차순 정렬

        int count = 0;      // 티켓 사용 개수.
        path.add("ICN");

        dfs("ICN", tickets, visited, path, count);
        return path.toArray(new String[0]);
    }

    // 해당 경로로 쭉 갈 수 있는지, 아니면 다시 돌아와야 하는지 알기 위해 boolean 타입을 반환형으로 둔다.
    private boolean dfs(String current, String[][] tickets, boolean[] visited, List<String> path, int count) {
        // 모든 티켓을 사용했다면, 여행 경로를 더 출력할 필요가 없다.
        if (count == tickets.length) {
            return true;
        }

        for (int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];

            // 현재 위치가 출발점인 티켓을 찾았다면, && 티켓을 사용하지 않았다면
            if ( !visited[i] && ticket[0].equals(current) ) {
                String dest = ticket[1];    // 도착지점
                visited[i] = true;
                path.add(dest);

                // 이 경로로 쭉 갈 수 있는지 확인
                if( dfs(dest, tickets, visited, path, count + 1) ) {
                    return true;
                }

                // 다른 경로로 가기 위해 다시 돌아와야 한다면? (백트래킹)
                path.remove( path.size() - 1 );
                visited[i] = false;
            }
        }

        return false;
    }
}
