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

    while(pq.isNotEmpty()) {
        val (now, d) = pq.poll()
        if( dist[now] < d ) continue    // 이미 더 짧은 거리 값을 구했다면, 이 정점은 지나지 않는다.

        for(nextVertex in graph[now]) {
            val (next, cost) = nextVertex
            if( dist[next] > dist[now] + cost ) {
                dist[next] = dist[now] + cost
                pq.add(next to dist[next])
            }
        }
    }

    println(dist[end])
}