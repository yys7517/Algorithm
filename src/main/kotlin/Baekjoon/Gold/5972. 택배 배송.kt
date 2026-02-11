package org.example.Baekjoon.Gold

import java.util.*

fun main() {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }

    val graph = Array(N + 1) { mutableListOf<Pair<Int, Int>>() }
    val dist = IntArray(N + 1) { Int.MAX_VALUE }

    repeat(M) {
        val(start, end, cost) = readLine()!!.split(" ").map{ it.toInt() }

        // 양방향 길
        graph[start].add(end to cost)
        graph[end].add(start to cost)
    }

    val pq = PriorityQueue<Pair<Int,Int>>(compareBy { it.second } )
    val start = 1 // 1부터 시작

    dist[start] = 0
    pq.add(start to dist[start])

    while(pq.isNotEmpty()) {
        val (now, d) = pq.poll()
        if(dist[now] < d) continue  // 이미 now까지 오는 저장된 거리가 더 짧다면 이번 정점은 무시한다.

        for( nextVertex in graph[now] ) {
            val (next, cost) = nextVertex

            if(dist[next] > dist[now] + cost) {
                dist[next] = dist[now] + cost
                pq.add(next to dist[next])
            }
        }
    }

    println(dist[N])
}