package org.example.Baekjoon.Gold

fun main() {
    val N = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }

    // dp[i] : i번째 원소까지 만들 수 있는 부분수열의 길이
    val dp = IntArray(N) { 1 }

    // pre[i] : 만들어진 부분 수열이 있을 때,
    // i번째 값 이전에 오는 값의 인덱스 위치
    val pre = IntArray(N) { -1 }

    // ex) arr = 10, 20, 11, 12, 15
    // pre[1] = 0 ( 20 이전에 오는 값인 10은 0번째 )
    // dp[0] = 1 (원소 하나로 만들 수 있는 부분 수열 길이)
    // dp[1] = 2 (10, 20)

    // pre[2] = 0 ( 11 이전에 오는 값인 10은 0번째 )
    // dp[2] = 2 (10, 11)

    // pre[3] = 2 ( 12 이전에는 11만 올 수 있는데, 이게 2번째)
    // dp[3] = 3 (10, 11, 12)

    // pre[4] = 3 ( 15 이전에는 12만 올 수 있는데, 이게 3번째 )

    var maxLen = 1
    var maxIdx = 0

    for(i in 1 until N) {
        for(j in 0 until i) {
            if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                // 다음 요소 값이 더 큰데?
                // dp[j], j까지의 부분 수열 길이 + 1보다
                // i값이 작으면, 갱신
                dp[i] = dp[j] + 1  // j보다 i값이 크므로, j보다 부분 수열 길이가 1 늘어났다.
                pre[i] = j
            }
        }

        // 최대 값 갱신
        if(dp[i] > maxLen) {
            maxLen = dp[i]
            maxIdx = i
        }
    }

    println(maxLen)

    // pre 배열을 사용해서 역추적
    var curr = maxIdx
    val list = mutableListOf<Int>()

    while(curr != -1) {
        list.add(arr[curr])
        curr = pre[curr]
    }

    // 역추적한 값들이므로, 거꾸로 출력해야 정답
    // Stack을 사용해도 됨
    list.reversed().forEach {
        print("$it ")
    }
}