package org.example.Baekjoon.Bronze

import java.io.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = readLine()!!.toInt()
    val arr = IntArray(10001)   // 1 ~ 10000 까지의 자연수들이 주어진다.

    repeat(n) {
        arr[ readLine()!!.toInt() ] += 1    // arr[i] = 자연수 i의 개수
    }

    bw.use {
        for( i in 0 until 10001 ) {     // 오름차순으로 출력
            if(arr[i] > 0) {             // i가 있다면
                repeat(arr[i]) {
                    bw.write("$i \n")
                }
            }
        }
    }
}