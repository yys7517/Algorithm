package BOJ.gold;

import java.util.*;
import java.io.*;

public class Solution_이분그래프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());  // Test case

        for (int t = 0; t < K; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            // 정점의 개수 V, 간선의 개수 E
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            // 그래프 연결
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                adj.add(new ArrayList<>());
            }

            int[] colors = new int[V + 1];    // 청팀, 백팀을 나누자
            // 0 : 아직 방문 안함
            // 1 : 청팀
            // -1: 백팀

            for (int i = 0; i < E; i++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st1.nextToken());
                int end = Integer.parseInt(st1.nextToken());

                adj.get(start).add(end);
                adj.get(end).add(start);
            }

            boolean isRight = true;

            for (int start = 1; start <= V; start++) {
                if (colors[start] == 0) {
                    colors[start] = 1;

                    // dfs가 false(모순)를 뱉으면?
                    if (!dfs(start, colors[start], V, adj, colors)) {
                        isRight = false; // "야, 여긴 망했어!" 도장 찍고
                        break;           // 뒤에 남은 정점들은 볼 것도 없이 즉시 탈출!
                    }
                }
            }


            System.out.println(isRight ? "YES" : "NO");
        }
    }

    static boolean dfs(int start, int prevColor, int V, List<List<Integer>> graph, int[] colors) {

        for (int next : graph.get(start)) {
            if (colors[next] == 0) {
                // 새로 만나는 정점인가?
                colors[next] = prevColor * -1;  // 이전 정점과는 다른 집합이다!

                if (!dfs(next, colors[next], V, graph, colors)) {
                    return false;
                }

            } else if (colors[next] == colors[start]) {
                // 이전과 똑같은 집합을 만났다?
                return false;
            }
        }

        return true;
    }
}