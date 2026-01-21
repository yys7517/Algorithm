package org.example.Baekjoon.Silver

fun main() {
    val (K, N) = readLine()!!.split(" ").map { it.toInt() }

    val arr = IntArray(K) {
        readLine()!!.toInt()
    }.sorted()

    var left = 1L       // 랜선의 최소 길이는 1이다.
    var right = arr[K-1].toLong()   // 랜선의 최대 길이

    var maxLength = 0L

    while(left <= right) {
        val mid = (left + right) / 2

        var count = 0L

        for(i in 0 until K) {
            count += arr[i] / mid
        }
        // N개의 랜선을 만들어야함.
        if(count >= N) {
            maxLength = maxOf(mid, maxLength)  //   이 때 랜선의 길이가 정답이 될 수 있음.
            left = mid + 1

        } else {
            // count < N
            // 만들 수 있는 랜선의 개수가 N보다 적다면
            // mid값을 줄여야함..
            right = mid - 1
        }
    }

    print(maxLength)
}