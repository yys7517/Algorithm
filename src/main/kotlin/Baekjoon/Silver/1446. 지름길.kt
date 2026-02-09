package org.example.Baekjoon.Silver

import java.util.PriorityQueue

fun main() {
    val (N, D) = readLine()!!.split(" ").map { it.toInt() }

    val graph = Array(D + 1){ mutableListOf<Pair<Int, Int>>() }
    for(i in 0 until D) {
        graph[i].add( i+1 to 1 )     // i에서 i+1 지점으로 가는 거리는 1이다.
    }

    repeat(N) {
        val (start, end, cost) = readLine()!!.split(" ").map { it.toInt() }

        // 지름길의 역할을 하는지 확인
        if( cost < end - start && end <= D) {
            graph[start].add( Pair(end, cost) )
        }
    }

    val dist = IntArray(D + 1) { Int.MAX_VALUE }
    val pq = PriorityQueue<Pair<Int, Int>>() { a, b -> a.second - b.second }

    // 0부터 시작
    dist[0] = 0
    pq.add(0 to 0)

    while(pq.isNotEmpty()) {
        val now = pq.poll().first

        for(nextVertex in graph[now]) {
            val (next, cost) = nextVertex

            if(dist[next] > dist[now] + cost) {
                dist[next] = dist[now] + cost
                pq.add(next to dist[next])
            }
        }
    }

    println(dist[D])
}