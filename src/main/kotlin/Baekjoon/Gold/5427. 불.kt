package org.example.Baekjoon.Gold

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()

    val tc = br.readLine().toInt()

    val sb = StringBuilder()

    for(t in 0 until tc) {
        val st = StringTokenizer(br.readLine(), " ")
        val w = st.nextToken().toInt()
        val h = st.nextToken().toInt()

        val map = Array(h) { br.readLine().toCharArray() }

        val distMap = Array(h) { IntArray(w) { -1 } }
        val fireMap = Array(h) { IntArray(w) { -1 } }

        val sg_Q = ArrayDeque<IntArray>()
        val fire_Q = ArrayDeque<IntArray>()

        for(r in 0 until h) {
            for(c in 0 until w) {
                when(map[r][c]) {
                    '*' -> {
                        // 불
                        fireMap[r][c] = 0
                        fire_Q.add(intArrayOf(r, c))
                    }

                    '@' -> {
                        // 상근
                        distMap[r][c] = 0
                        sg_Q.add(intArrayOf(r, c))
                    }
                }
            }
        }

        val dx = intArrayOf(-1, 0, 1, 0)
        val dy = intArrayOf(0, -1, 0, 1)

        // 불의 이동 지도
        while(fire_Q.isNotEmpty()) {
            val (sx, sy) = fire_Q.poll()

            for(i in 0 until 4) {
                val nx = sx + dx[i]
                val ny = sy + dy[i]

                if(nx !in 0 until h || ny !in 0 until w) continue
                if(map[nx][ny] == '#' || fireMap[nx][ny] != -1) continue    // 벽이거나, 방문된 지점이라면 건너뜀

                fireMap[nx][ny] = fireMap[sx][sy] + 1
                fire_Q.add(intArrayOf(nx, ny))
            }
        }

        var answer: Int? = null        // 거리

        escape@ while(sg_Q.isNotEmpty()) {
            val (sx, sy) = sg_Q.poll()

            // 가장자리이면? 탈출
            if(sx == 0 || sx == h-1 || sy == 0 || sy == w-1) {
                answer = distMap[sx][sy] + 1
                break@escape
            }

            for(i in 0 until 4) {
                val nx = sx + dx[i]
                val ny = sy + dy[i]

                if(nx !in 0 until h || ny !in 0 until w) continue
                if(map[nx][ny] == '#') continue
                if(distMap[nx][ny] != -1) continue

                // 불이 지나가는 길이고
                // 상근이가 지나가는 시간대가, 불과 같거나, 더 늦는다면
                if(fireMap[nx][ny] != -1 && fireMap[nx][ny] <= distMap[sx][sy] + 1) continue

                distMap[nx][ny] = distMap[sx][sy] + 1
                sg_Q.add(intArrayOf(nx, ny))
            }
        }

        sb.append(answer ?: "IMPOSSIBLE").append("\n")
    }

    println(sb)
}