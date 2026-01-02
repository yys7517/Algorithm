package org.example.Baekjoon.Gold

import java.util.*

fun main() {
    val (N, Q) = readLine()!!.split(" ").map { it.toInt() }

    var size = 1 shl N     // 전체 격자 길이

    val map = Array(size) {
        val st = StringTokenizer(readLine())
        IntArray(size) { st.nextToken().toInt() }
    }

    val dx = arrayOf(-1, 1, 0, 0)
    val dy = arrayOf(0, 0, -1, 1)

    // 마법사가 시전하는 파이어스톰 단계
    val st = StringTokenizer(readLine(), " ")
    while(st.hasMoreTokens()) {
        val L = st.nextToken().toInt()
        val l = 1 shl L     // 부분 격자 길이

        /* 시계방향 90도 배열 회전
         4x4 배열에서
         [0, 0] -> [0, 3]
         [0, 1] -> [1, 3]
         [0, 2] -> [2, 3]
         [0, 3] -> [3, 3]

         [1, 0] -> [0, 2]
         [1, 1] -> [1, 2]
         [1, 2] -> [2, 2]

         [i, j] -> [j, size - 1 - i]*/

        val copiedMap = Array(size) { IntArray(size) }

        // l씩 건너뛰면서 시작점을 기준으로, 회전을 시작.
        for(startX in 0 until size step l) {
            for(startY in 0 until size step l) {
                // 회전 시작
                for(i in 0 until l) {
                    for(j in 0 until l) {

                        copiedMap[startX + i][startY +j] = map[l - 1 - j + startX][i + startY]
                        /* startX - 0
                         startY - 0
                         l = 4

                         newBoard[0][0] = A[3][0]
                         newBoard[0][1] = A[2][0]
                         newBoard[0][2] = A[1][0]
                         newBoard[0][3] = A[0][0]

                         newBoard[1][0] = A[3][1]
                         newBoard[1][1] = A[2][1]
                         newBoard[1][2] = A[1][1]


                         startX - 2
                         startY - 2
                         l = 2

                         newBoard[2 + 0][2 + 0] = A[3 ( 2-1-0+2 ) ][2 (0+2)]
                         newBoard[2 + 0][2 + 1] = A[2 ( 2-1-1+2 ) ][2]
                         newBoard[2 + 1][2 + 0] = A[3][3]
                         newBoard[2 + 1][2 + 1] = A[2][3]*/
                    }
                }
            }
        }

        val minus = Array(size) { BooleanArray(size) }

        // 인접한 얼음이 3개 미만이라면, 얼음을 녹인다.
        for(x in 0 until size) {
            for( y in 0 until size ) {
                if(copiedMap[x][y] == 0) continue

                var count = 0

                for(i in 0 until 4) {
                    val nx = x + dx[i]
                    val ny = y + dy[i]

                    if(nx < 0 || ny < 0 || nx >= size || ny >= size) continue
                    if( copiedMap[nx][ny] == 0 ) continue

                    count++
                }

                if(count < 3)
                    minus[x][y] = true
            }
        }

        for(i in 0 until size) {
            for( j in 0 until size ) {
                map[i][j] = copiedMap[i][j]
                if(minus[i][j] && map[i][j] > 0) map[i][j]--
            }
        }
    }

    val visited = Array(size) { BooleanArray(size) }

    var cnt = 0
    var max = 0
    val sum = map.sumOf { it.sum() }

    fun dfs(x: Int, y: Int) {
        if( map[x][y] == 0 || visited[x][y] ) return

        visited[x][y] = true
        cnt++
        max = maxOf(max, cnt)

        for(i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if( nx < 0 || ny < 0 || nx >= size || ny >= size ) continue

            dfs(nx, ny)
        }
    }

    /*fun bfs() {
        val queue = LinkedList<Pair<Int, Int>>()

        for( i in 0 until size ) {
            for ( j in 0 until size ) {
                if(map[i][j] > 0 && !visited[i][j]) {
                    queue.add(Pair(i,j))
                    visited[i][j] = true

                    cnt = 1

                    while(queue.isNotEmpty()) {
                        val tmp = queue.poll()

                        val tx = tmp.first
                        val ty = tmp.second

                        for(i in 0 until 4) {
                            val nx = tx + dx[i]
                            val ny = ty + dy[i]

                            if( nx < 0 || ny < 0 || nx >= size || ny >= size ) continue

                            if(!visited[nx][ny] && map[nx][ny] > 0) {
                                queue.add(Pair(nx, ny))
                                visited[nx][ny] = true
                                cnt++
                            }
                        }
                    }
                }
            }
        }
    }*/

    for(i in 0 until size) {
        for(j in 0 until size) {
            cnt = 0             // 얼음 덩어리(연결 요소)마다, 얼음 개수 초기화
            dfs(i, j)
        }
    }


    println(sum)
    println(max)
}