package org.example.Baekjoon.Silver

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val T = readLine()!!.toInt()
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    bw.use { bw ->
        repeat(T) {
            val day = readLine()!!.toInt()
            val arr = readLine()!!.split(" ").map { it.toInt() }

            // 역 방향 탐색!
            // 뒤에서부터 가장 큰 주가를 찾아낸다.
            // 이유는 그 가격에 판매하는게 가장 큰 이익이기 때문

            // ex) 1 1 3 1 2
            // 뒤에 있는 1은 2에 판매하는게 가장 유리하고,
            // 앞에 있는 1 1은 3에 판매하는게 가장 유리하다.

            var result = 0L
            var max = 0

            for(i in arr.size -1 downTo 0) {
                max = maxOf(arr[i], max)
                result += max - arr[i]
            }

            bw.write("$result\n")
        }
    }
}