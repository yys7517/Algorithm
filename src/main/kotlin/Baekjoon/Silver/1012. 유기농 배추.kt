package org.example.Baekjoon.Silver

import java.util.*

fun main() = with(Scanner(System.`in`)){
    repeat(nextInt()) {
        val m = nextInt()
        val n = nextInt()
        val k = nextInt()

        val graph = Array(n) { IntArray(m) }

        // 상하좌우
        val dr = arrayOf(-1,1,0,0)
        val dc = arrayOf(0,0,-1,1)

        var cnt = 0

        repeat(k) {
            val c = nextInt()
            val r = nextInt()
            graph[r][c] = 1
        }

        fun dfs(r: Int, c: Int) {
            for( i in 0 until 4 ) {
                val nr = r + dr[i]
                val nc = c + dc[i]

                if(nr < 0 || nc < 0 || nr >= n || nc >= m ) continue

                if(graph[nr][nc] == 1) {
                    graph[nr][nc] = 0
                    dfs(nr,nc)
                }
            }
        }

        for(r in 0 until n) {
            for( c in 0 until m ) {
                if(graph[r][c] == 1) {
                    graph[r][c] = 0
                    dfs(r,c)
                    cnt++
                }
            }
        }

        println(cnt)
    }
}