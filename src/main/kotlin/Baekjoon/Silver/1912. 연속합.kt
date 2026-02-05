package org.example.Baekjoon.Silver

fun main() {
    // arr = [10, -4, 3, 1, 5, 6, -35, 12, 21, -1]
    // dp[0] = 10 ( arr[0] )                            => arr[0]
    // dp[1] = -4 or 10-4 ( arr[1] or dp[0] + arr[1] )  => dp[0] + arr[1]
    // dp[2] = 3 or 10-4+3 or -4+3 ( arr[2] or dp[0] + arr[1] + arr[2] or arr[1] + arr[2] ) => dp[0] + arr[1] + arr[2]

    // dp[i] => i번째 수 까지 연속된 합 중 최대 값을 저장한다.

    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }
    val dp = IntArray(n)

    dp[0] = arr[0]
    var max = dp[0]

    for(i in 1 until n) {
        if( arr[i] < arr[i] + dp[i-1] ) {
            dp[i] = arr[i] + dp[i-1]
        } else {
            dp[i] = arr[i]
        }

        max = maxOf(max, dp[i])     // 수열 내 연속합 중 최대 값
    }

    print(max)
}