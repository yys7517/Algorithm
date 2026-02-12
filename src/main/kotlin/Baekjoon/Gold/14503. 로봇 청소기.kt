package org.example.Baekjoon.Gold

import java.util.*

fun main() {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }

    // 현재 위치 x, y , 바라보는 방향 d
    var (x, y, d) = readLine()!!.split(" ").map { it.toInt() }

    // 벽이 있다.
    // 청소되지 않은 경우, 청소

    // 주변 4칸이 모두 청소된 경우, 후진할 수 있다면 후진
    // 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.

    // 주변 4칸 중 청소되지 않은 칸이 있는 경우,
    // 반시계 방향 90도 회전

    // d = 0 북쪽
    // d = 1 동쪽
    // d = 2 남쪽
    // d = 3 서쪽
    val dx = arrayOf(-1, 0, 1, 0)
    val dy = arrayOf(0, 1, 0, -1)
    // d값에 맞게 x + dx[d], y + dy[d] 이동
    // 반시계 방향 90도 회전은 d값을 감소
    // d가 0 ~ 3 왔다갔다 하게 해야함

    val map = Array(N) {
        val st = StringTokenizer(readLine()!!, " ")
        IntArray(M) { st.nextToken().toInt() }
    }

    var result = 0  // 청소한 칸의 수

    while(true) {
        // 1. 현재 칸이 청소 가능하다면 청소
        if(map[x][y] == 0) {
            map[x][y] = -1
            result += 1
        }

        var count = 0 // 청소되지 않은 칸의 수
        // 주변에 청소되지 않은 칸이 있는지 확인
        for(i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            // 이동 가능한가?
            if( nx < 0 || nx >= N || ny < 0 || ny >= M ) continue

            // 이미 청소되었거나, 벽이라면 skip
            if( map[nx][ny] == 1 || map[nx][ny] == -1 ) continue

            count++
        }

        if(count == 0) { // 2. 청소할 수 있는 칸이 없다면,
            // 후진
            val px = x - dx[d]
            val py = y - dy[d]

            // 이동은 가능한지 ?
            if(px in 0 until N && py in 0 until M) {
                if(map[px][py] == 1) {
                    // 벽이면? 가동 종료
                    println(result)
                    return
                } else {
                    // 벽이 아니면, 이동은 할 수 있다.
                    x = px
                    y = py
                }
            }
        } else { // 청소할 수 있는 칸이 있다면,
            // 현재 방향에서 반시계 방향 회전
            // 1 감소 (0 -> 3 -> 2 -> 1 -> 0)
            d -= 1
            if (d < 0) d = 3

            val nx = x + dx[d]
            val ny = y + dy[d]

            //  이동은 가능한지?
            if(nx in 0 until N && ny in 0 until M) {

                // 앞에 칸은 청소 가능한 칸인지?
                if(map[nx][ny] == 0) {
                    x = nx
                    y = ny
                }
            }
        }
    }
}