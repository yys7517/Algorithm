package codex;

import java.util.Arrays;

public class Solution_크루스칼알고리즘 {

    static int[] parent;    // 루트 노드의 번호를 저장하는 배열

    public static void main(String[] args) {
        int n = 4;

        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        System.out.println(union(0, 1)); // true
        System.out.println(union(1, 2)); // true
        System.out.println(find(0) == find(2)); // true
        System.out.println(union(0, 2)); // false
        System.out.println(union(3, 4)); // true
    }

    static int find(int x) {
        if( parent[x] == x ) return x;  // 부모와 자신이 같다면, 루트 노드이다.
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) return false;    // 둘이 부모가 같다면, 같은 집합, 사이클이 발생할 수 있다.

        parent[rootB] = rootA;

        return true;
    }

    /**
     * costs - [a,b, cost]
     * @param costs - 간선을 이루는 정점 a,b, 연결 비용 정보
     */
    static int solution(int n, int[][] costs) {
        // 노드 개수 n
        parent = new int[n+1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // 1. 모든 간선을 비용 오름차순으로 정렬한다.
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        int selected = 0;   // 간선 수
        int sum = 0;    // 간선 연결 최소 비용의 합

        // 2. 가장 비용이 적은 간선부터 확인
        for(int[] edge: costs) {
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];

            // 3. 두 정점이 다른 집합이면, 간선을 선택하고, union 한다.
            // 4. 같은 집합이면, 사이클이 발생할 수 있으므로, 선택하지 않는다.
            if(union(a, b)) {
                sum += cost;
                selected++;
            }

            // 5. 간선을 n-1개 선택하면 종료 (노드가 n개인 그래프)
            if(selected == n-1) break;
        }

        return sum;
    }
}
