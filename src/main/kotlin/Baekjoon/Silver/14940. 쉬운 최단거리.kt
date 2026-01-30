package org.example.Baekjoon.Silver
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = readLine()!!.split(" ").map { it.toInt() }

    val map = Array(n) {
        val st = StringTokenizer(readLine()!!, " ")
        IntArray(m) { st.nextToken().toInt() }
    }

    // 목표 지점을 찾아 출발점으로 지정
    var sx = 0
    var sy = 0

    for(i in 0 until n) {
        for(j in 0 until m) {
            // print("${map[i][j]} ")
            if(map[i][j] == 2) {
                sx = i
                sy = j

                map[i][j] = 0 // 거리로 초기화하기 위해서
            }
        }
        // println()
    }

    // 목표 지점 2에서부터 거리이면,
    // 2에서 BFS로 출발해서 각 지점간의 거리를 구하자
    // sx, sy 에서 출발

    val visited = Array(n) { BooleanArray(m) }

    val queue = ArrayDeque<Pair<Int,Int>>()
    queue.add( Pair(sx, sy) )
    visited[sx][sy] = true

    // 상하 좌우 이동
    val dx = arrayOf(-1,1,0,0)
    val dy = arrayOf(0,0,-1,1)

    while(queue.isNotEmpty()) {
        val tmp = queue.poll()
        val x = tmp.first
        val y = tmp.second

        for(i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue
            if(visited[nx][ny]) continue
            if(map[nx][ny] == 0) continue   // 갈 수 없는 땅

            map[nx][ny] = map[x][y] + 1     // 이전 지점에서 거리 + 1
            queue.add( Pair(nx, ny) )
            visited[nx][ny] = true
        }
    }

    // 갈 수 있는 땅에서 도달할 수 없는 위치는 -1을 출력
    for(i in 0 until n) {
        for(j in 0 until m) {
            if( map[i][j] > 0 && !visited[i][j] ) map[i][j] = -1
//            print("${map[i][j]} ")
            bw.write("${map[i][j]} ")
        }
        bw.write("\n")
//        println()
    }

    bw.flush()
    bw.close()
}