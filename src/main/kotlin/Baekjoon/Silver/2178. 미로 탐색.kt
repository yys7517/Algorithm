package org.example.Baekjoon.Silver

import java.util.*

data class Point(val x: Int, val y: Int)

fun main() {
    val (rows,cols) = readLine()!!.split(" ").map { it.toInt() }
    val graph = Array(rows) { IntArray(cols) }

    for(i in 0 until rows) {
        val tmp = readLine()!!

        for(j in 0 until cols) {
            graph[i][j] = tmp[j] - '0'      // 0,1 문자열을 숫자로 변환
        }
    }

    fun bfs(point: Point, graph: Array<IntArray>) {
        val dr = arrayOf(1,0,0,-1)
        val dc = arrayOf(0,1,-1,0)

        val queue = LinkedList<Point>()
        queue.add( point )

        while(queue.isNotEmpty()) {
            val tmp = queue.poll()
            val tr = tmp.x
            val tc = tmp.y

            for(i in 0 until 4) {
                val nr = tr + dr[i]
                val nc = tc + dc[i]

                if(nr < 0 || nc < 0 || nr >= rows || nc >= cols) continue

                // 이동할 수 있는 곳인지?
                if(graph[nr][nc] == 1) {
                    graph[nr][nc] = graph[tr][tc] + 1   // 새로 이동하는 칸은, 그 전 칸보다 한 칸 더 이동한 횟수이기 때문
                    queue.add(Point(nr, nc))
                }
            }
        }
    }

    bfs(Point(0,0), graph)

    println( graph[rows-1][cols-1] )
}

