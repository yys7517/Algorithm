package org.example.Baekjoon.Bronze

    fun main() {
        val n = readLine()!!.toInt()
        val dp = IntArray(n+1)

        dp[0] = 0
        dp[1] = 1

        for(i in 2..n) {
            dp[i] = dp[i-2] + dp[i-1]
        }

        print(dp[n])
    }