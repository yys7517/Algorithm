package org.example.Baekjoon.Silver

fun main() {
    val N = readLine()!!.toInt()

    // N개의 정수 A[1], A[2] ... A[N]
    val A = readLine()!!.split(" ").map { it.toInt() }

    val M = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }

    val sb = StringBuilder()

    val sorted = A.sorted()

    for( num in arr ) {
        var answer = 0      // num이 존재하면 1 아니면 0 출력

        var left = 0
        var right = N-1

        while(left <= right) {
            val mid = (left + right) / 2

            if(sorted[mid] == num) {
                answer = 1
                break
            } else if(sorted[mid] >= num) {
                right = mid - 1
            } else  {
                left = mid + 1
            }
        }

        sb.append(answer).append("\n")
    }

    println(sb)
}