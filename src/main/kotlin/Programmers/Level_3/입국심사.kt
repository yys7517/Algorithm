package org.example.Programmers.Level_3

fun solution(n: Int, times: IntArray): Long {
    var answer: Long = 0

    val sorted = times.sorted()
    val min = sorted.first().toLong()
    val max = sorted.last().toLong()

    var left = min
    var right = max * n     // right는 가장 비효율적으로 심사했을 때 걸리는 시간, 가장 긴 시간동안 심사하는 사람한테 n명이 모두 받을 경우

    while(left <= right) {
        val mid = (left + right) / 2

        var checked = 0L
        for(time in times) {
            checked += mid / time
        }

        if( checked >= n ) {
            answer = mid        // 최소값을 구하기 위해서, answer값을 바로 return하지 않는다.
            right = mid - 1
        } else if ( checked < n ) {
            left = mid + 1
        }
    }

    return answer
}

fun main() {
    println(solution(
        n = 6,
        times = intArrayOf(7, 10)
    ))
}