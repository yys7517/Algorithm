package org.example.Baekjoon.Silver

import kotlin.math.min

fun main() {
    val n =  readln().toInt()
    val dp = IntArray(1001)
    dp[0] = 0
    dp[1] = 1
    dp[2] = 2

    // 돌을 뽑는 횟수는, 1개 적은 경우 또는 3개 적은 경우보다 1회 더 많은 횟수이다.
    for(i in 3..n) {
        dp[i] = min(dp[i-1] + 1, dp[i-3] + 1)
    }

    if( dp[n] % 2 == 0 ) {
        print("CY")
    } else {
        print("SK")
    }
}