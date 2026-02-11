package org.example.Baekjoon.Gold
import java.util.*

fun main() {
    val N = readLine()!!.toInt()
    val M = readLine()!!.toInt()

    val graph = Array(N+1) { mutableListOf<Pair<Int, Int>>() }
    val dist = IntArray(N+1) { Int.MAX_VALUE }

    repeat(M) {
        val (start, end, cost) = readLine()!!.split(" ").map { it.toInt() }
        graph[start].add( end to cost )
    }

    val (start, end) = readLine()!!.split(" ").map { it.toInt() }
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second } )

    dist[start] = 0
    pq.add(start to 0)

    val routes = mutableListOf<Int>()
    val pre = IntArray(N + 1)   // 이전 위치를 저장
    pre[start] = 0

    while(pq.isNotEmpty()) {
        val (now, d) = pq.poll()
        if( dist[now] < d ) {
            continue    // 이미 더 짧은 거리 값을 구했다면, 이 정점은 지나지 않는다.
        }

        for(nextVertex in graph[now]) {
            val (next, cost) = nextVertex
            if( dist[next] > dist[now] + cost ) {
                dist[next] = dist[now] + cost
                pre[next] = now
                pq.add(next to dist[next])
            }
        }
    }

    var count = 0
    var idx = end

    // pre에 저장된 값이 0이면, 시작점까지 온 것이므로 역추적 종료
    while(idx != 0) {
        count++
        routes.add(idx)
        idx = pre[idx]
    }

    println(dist[end])
    println(routes.size)
    println(routes.reversed().joinToString(" "))    // 역추적 경로이므로 reverse된 값을 출력
}