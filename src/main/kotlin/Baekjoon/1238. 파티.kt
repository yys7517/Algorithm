package org.example.Baekjoon

import java.util.*

data class Node(
    val idx: Int,
    val cost: Int,
): Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return this.cost - other.cost
    }
}
fun main() {
    val (N, M, X) = readln().split(" ").map{ it.toInt() }
    // N은 정점의 수
    // M은 간선의 수
    // X는 도착 지점

    val graph = Array(N + 1) { mutableListOf<Node>() }
    val reversedGraph = Array(N + 1) { mutableListOf<Node>() }

    var max = 0

    repeat(M) {
        val (start, end, cost) = readln().split(" ").map { it.toInt() }

        graph[start].add(Node(end, cost))
        reversedGraph[end].add(Node(start, cost))
    }

    val distFromX = findDist(N, X, graph)          // X에서 출발 -> 오는 길
    val distToX = findDist(N, X,reversedGraph)   // 역방향 그래프를 기준으로 X에서 출발 -> 가는 길

    for(i in 1..N) {
        if( i == X ) continue
        if(distToX[i] == Int.MAX_VALUE || distFromX[i] == Int.MAX_VALUE) continue
        max = maxOf(max, distToX[i] + distFromX[i])
    }

    print(max)
}

private fun findDist(n: Int, start: Int, graph: Array<MutableList<Node>>): IntArray {

    val dist = IntArray(n + 1) { Int.MAX_VALUE }
    val visited = BooleanArray(n + 1)

    val pq = PriorityQueue<Node>()
    pq.add(Node(start, 0))
    dist[start] = 0

    while (pq.isNotEmpty()) {
        val nowVertex = pq.poll().idx

        if (visited[nowVertex]) continue
        visited[nowVertex] = true

        for (nextNode in graph[nowVertex]) {
            val nextVertex = nextNode.idx
            val cost = nextNode.cost

            // 인접한 nextVertex로 갈 수 있는 거리를 최단거리로 갱신.
            if(dist[nextVertex] > dist[nowVertex] + cost) {
                dist[nextVertex] = dist[nowVertex] + cost
                pq.add(Node(nextVertex, dist[nextVertex]))
            }
        }
    }
//        println(dist.slice(1..N))

    return dist
}