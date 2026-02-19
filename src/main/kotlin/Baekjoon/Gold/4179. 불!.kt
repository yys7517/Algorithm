package org.example.Baekjoon.Gold

import java.util.*

fun main() {
    val (R, C) = readLine()!!.split(" ").map { it.toInt() }

    val map = Array(R) { Array(C) {""} }
    val distMap = Array(R) { IntArray(C) { -1 } }
    val fireDistMap = Array(R) { IntArray(C) { -1 } }

    val fire_Q = LinkedList<Pair<Int, Int>>()
    val jihoon_Q = LinkedList<Pair<Int, Int>>()

    for (r in 0 until R) {
        val line = readLine()!!
        for (c in 0 until C) {
            val ch = line[c].toString()
            map[r][c] = ch

            when(ch) {
                "F" -> {
                    fireDistMap[r][c] = 0
                    fire_Q.add(r to c)
                }

                "J" -> {
                    distMap[r][c] = 0
                    jihoon_Q.add(r to c)

                    // 시작점이 가장자리 일 때
                    if(r == 0 || r == R-1 || c == 0 || c == C-1) {
                        println(1)
                        return
                    }
                }
            }
        }
    }

    // 불이 없을 경우에는 어떻게?
    val dx = arrayOf(-1,0,1,0)
    val dy = arrayOf(0,-1,0,1)

    // 1. 불이 이동할 수 있는 지도를 먼저 그리자.
    while(fire_Q.isNotEmpty()) {
        val (sx, sy) = fire_Q.poll()

        for(i in 0 until 4) {
            val nx = sx + dx[i]
            val ny = sy + dy[i]

            // 좌표 내 이동할 수 있는지 확인
            if(nx !in 0 until R || ny !in 0 until C) continue

            // -1 값은 벽일 수도 있고, 길일 수도 있다.
            if(map[nx][ny] == "#") continue         // 벽이라면
            if(fireDistMap[nx][ny] != -1) continue  // 이미 방문된 정점이라면

            fireDistMap[nx][ny] = fireDistMap[sx][sy] + 1
            fire_Q.add(nx to ny)
        }
    }

    // 2. 주훈이 이동할 수 있는 지도
    while(jihoon_Q.isNotEmpty()) {
        val (sx, sy) = jihoon_Q.poll()

        for(i in 0 until 4) {
            val nx = sx + dx[i]
            val ny = sy + dy[i]

            // 좌표 내 이동할 수 있는지 확인
            if(nx !in 0 until R || ny !in 0 until C) continue

            // -1 값은 벽일 수도 있고, 길일 수도 있다.
            if(map[nx][ny] == "#") continue         // 벽이라면
            if(distMap[nx][ny] != -1) continue      // 이미 방문된 정점이라면

            // 불이 지나가는 길인가?
            // 주훈이가 불보다 늦게 지나거나 같이 지나는가? -> 불이 이미 확산된 자리는, 주훈이가 지나갈 수 없다.
            if(fireDistMap[nx][ny] != -1 && fireDistMap[nx][ny] <= distMap[sx][sy] + 1) continue

            distMap[nx][ny] = distMap[sx][sy] + 1
            jihoon_Q.add(nx to ny)

            // 다음 지점이 가장자리인가?
            if(nx == 0 || nx == R-1 || ny == 0 || ny == C-1) {
                println( distMap[nx][ny] + 1 )  // 가장자리에서 한 칸 더 이동해야 탈출할 수 있다.
                return
            }
        }
    }

    println("IMPOSSIBLE")
}
