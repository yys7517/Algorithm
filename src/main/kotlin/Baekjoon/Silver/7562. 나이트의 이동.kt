package org.example.Baekjoon.Silver

import java.util.*


fun main() {
    val t = readLine()!!.toInt()
    val sb = StringBuilder()

    repeat(t) {
        val l = readLine()!!.toInt()
        val graph = Array(l) { IntArray(l) }

        val (sx, sy) = readLine()!!.split(" ").map { it.toInt() }
        val (ex, ey) = readLine()!!.split(" ").map { it.toInt() }

        val sPoint = Point(sx, sy)
        val ePoint = Point(ex, ey)

        // 출발점과 도착점이 같다면
        if(sPoint == ePoint) {
            sb.append("0").append("\n")
        } else {
            // 최소 탐색 횟수니까 BFS를 사용하는게 맞겠지?
            var count = 0

            val queue = LinkedList<Point>()

            queue.add( sPoint )

            // 이동할 수 있는 경우의 수
            val dx = arrayOf(1,2,2,1,-1,-2,-1,-2)
            val dy = arrayOf(-2,-1,1,2,2,1,-2,-1)

            while(queue.isNotEmpty()) {
                val tPoint = queue.poll()
                val tx = tPoint.x
                val ty = tPoint.y

                for(i in 0..7) {
                    if(tx + dx[i] < 0 || ty + dy[i] < 0 || tx + dx[i] >= l || ty + dy[i] >= l) {
                        // 체스판 범위를 벗어나는 경우면 스킵
                        continue
                    }

                    // 이동한 지점
                    val dPoint = Point(tx + dx[i], ty + dy[i])

                    // 방문한 적이 없다면, 이동 횟수 기록
                    if(graph[dPoint.x][dPoint.y] == 0) {
                        graph[dPoint.x][dPoint.y] = graph[tx][ty] + 1

                        if( dPoint == ePoint ) {
                            count = graph[dPoint.x][dPoint.y]
                            queue.clear()
                            break
                        }
                        queue.add(dPoint)
                    }
                }
            }


            sb.append(count).append("\n")
        }
    }

    println(sb)
}