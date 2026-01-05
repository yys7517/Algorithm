package org.example.Baekjoon.Silver

fun main() {
    val (N, K) = readLine()!!.split(" ").map{ it.toInt() }

    val A = IntArray(N) {
        readLine()!!.toInt()
    }

    var count = 0
    var idx = N - 1
    var curr = K

    while(curr > 0) {
        if( curr/A[idx] > 0 ) {
            count += curr/A[idx]
            curr -= (curr/A[idx]) * A[idx]
        }

        idx--
    }

    print(count)
}