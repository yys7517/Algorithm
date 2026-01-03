package org.example.Baekjoon.Silver

import java.util.*

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()

    val map = Array(n) {
        val st = StringTokenizer(readLine()!!, " ")
        IntArray(n) { st.nextToken().toInt() }
    }

    var visited = Array(n) { BooleanArray(n) }
    var height = 0
    var maxHeight = 0

    for( x in 0 until n ) {
        for( y in 0 until n ) {
            maxHeight = maxOf(map[x][y], maxHeight)
        }
    }

    var maxCount = 0     // 안전 영역 최대 개수
    var count = 0   // 안전 영역 개수


    // 인접(상하좌우)
    val dx = arrayOf(-1,1,0,0)
    val dy = arrayOf(0,0,-1,1)

    fun dfs(x: Int, y: Int) {
        visited[x][y] = true

        for(i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if(nx in 0 until n && ny in 0 until n) {
                if(!visited[nx][ny] && map[nx][ny] > height) {
                    dfs(nx, ny)
                }
            }
        }
    }

    // 높이 높여가면서, 안전 영역 개수 찾기
    while(height < maxHeight) {
        count = 0

        for(x in 0 until n) {
            for(y in 0 until n) {
                if(visited[x][y]) continue          // 이미 영역에 포함된 곳은 스킵
                if(map[x][y] <= height) continue    // 현재 비 높이보다 낮은 곳은 안전 영역의 시작이 되지 못함

                count++
                dfs(x, y)
            }
        }

        maxCount = maxOf(maxCount, count)
        visited = Array(n) { BooleanArray(n) }
        height++
    }

    print(maxCount)
}


