package org.example.Baekjoon.Silver

fun main() {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    val INF = 1_000_000     // Int Overflow를 방지하기 위해

    val dist = Array(N+1) { IntArray(N+1) { INF } }

    // 자기 자신으로 가는 거리는 0으로 초기화
    for(i in 1..N) {
        for(j in 1..N) {
            if(i == j) dist[i][j] = 0
        }
    }

    // 문제에서 명시한 거리는 따로 없고, 거쳐가는 친구 수에 따라 케빈 베이컨의 수가 1씩 늘어나므로,
    // 거리 값은 1로 초기화
    repeat(M) {
        val (s, e) = readLine()!!.split(" ").map { it.toInt() }

        dist[s][e] = 1
        dist[e][s] = 1
    }


    // 플로이드 워셜 알고리즘 사용
    // i -> j = i -> k + k -> j
    for(k in 1..N) {
        for(i in 1..N) {
            for(j in 1..N) {
                dist[i][j] = minOf(dist[i][j], dist[i][k] + dist[k][j])
            }
        }
    }


    // 케빈 베이컨의 수가 가장 작은 사람은?
    val kevinBacon = IntArray(N+1)

    // i의 케빈 베이컨 수 = i가 j를 알기위해 거치는 사람의 수를 모두 더한다.
    for(i in 1..N) {
        for(j in 1..N) {
            kevinBacon[i] += dist[i][j]
        }
    }

    var min = kevinBacon[1]
    var minIdx = 1

    for(i in 1..N) {
        if(kevinBacon[i] < min) {
            min = kevinBacon[i]
            minIdx = i
        }
    }

    println(minIdx)
}