package codex;

import java.util.Arrays;

public class Solution_union_find {

    public static void main(String[] args) {
        int n = 3;

        int[] parent = new int[n+1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        unionParent(parent, 1, 2);
        unionParent(parent, 2, 3);
    }

    // Node - [1,2,3]
    // Union: 1,2
    // Union: 2,3

    static int findParent(int[] parent, int x) {
        if(parent[x] == x) return x;    // Root 노드이면, 부모가 자신과 같다.
        return parent[x] = findParent(parent, parent[x]);     // x의 부모는, x의 부모의 부모와 같다.
        // parent[3] = find(parent, 2) = 1;
    }

    static boolean unionParent(int[] parent, int a, int b) {
        int rootA = findParent(parent, a);
        int rootB = findParent(parent, b);

        // a와 b의 부모가 같다 :같은 집합 -> 연결하면 사이클이 발생
        if(rootA == rootB) return false;

        // 더 작은 값을 부모로
        if(rootA < rootB) {
            parent[rootB] = rootA;
        } else {
            parent[rootA] = rootB;
        }

        return true;
    }

}
