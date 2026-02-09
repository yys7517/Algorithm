package org.example.Baekjoon.Silver

import java.util.PriorityQueue

fun main() {
    val (N, D) = readLine()!!.split(" ").map { it.toInt() }

    val dp = IntArray( D + 1 ) { it }
    val shortcuts = mutableListOf<Triple<Int, Int, Int>>()

    repeat(N) {
        val (start, end, cost) = readLine()!!.split(" ").map { it.toInt() }

        // 지름길의 역할을 하는지 확인
        if( cost < end - start && end <= D) {
            shortcuts.add(Triple(start, end, cost))
        }
    }

    for(i in 1..D) {
        dp[i] = minOf(dp[i], dp[i-1] + 1)

        for(shortcut in shortcuts) {
            val(start, end, cost) = shortcut

            if(end == i) {
                // 현재 위치가 지름길의 도착지점과 같다면
                dp[i] = minOf(dp[i], dp[start] + cost)
            }
        }
    }

    println(dp[D])
}