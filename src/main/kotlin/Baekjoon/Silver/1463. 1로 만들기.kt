package org.example.Baekjoon.Silver

fun main() {
    val X = readLine()!!.toInt()

    val dp = IntArray( X + 1)   // 1로 만드는 연산 횟수 저장
    dp[1] = 0   // 1은 1이므로, 연산이 필요없다.

    for(i in 2..X) {
        dp[i] = dp[i-1] + 1     // X에서 1을 뺄 수 있다.

        if( i % 2 == 0 ) {
            dp[i] = minOf(dp[i] , dp[i/2] + 1)  //  X가 2로 나눠진다면 2로 나눈다.
        }

        if( i % 3 == 0 ) {
            dp[i] = minOf(dp[i], dp[i/3] + 1)   // 3으로 나눠진다면 3으로 나눈다.
        }
    }

    print(dp[X])    // X가 1이 되는데 필요한 연산횟수
}