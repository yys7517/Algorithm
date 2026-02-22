package org.example.Baekjoon.Gold


fun main() {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    val arr = IntArray(N)

    repeat(N) {
        arr[it] = readLine()!!.toInt()
    }

    arr.sort()

    // 0,0부터 확인( 같은 수의 쌍일 수 있으므로 )
    var left = 0
    var right = 0

    var min = Int.MAX_VALUE

    while(left < N && right < N) {
        val diff = arr[right] - arr[left]

        // 차이가 M과 같으면, 중지
        if( diff == M ) {
            min = M
            break
        }

        if( diff < M ) {
            right++
        } else {
            // diff > M
            min = minOf(min, diff)
            left++
        }
    }


    println(min)
}