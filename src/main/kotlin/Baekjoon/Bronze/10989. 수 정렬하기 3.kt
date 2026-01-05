package org.example.Baekjoon.Bronze

import java.io.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = readLine()!!.toInt()
    val arr = IntArray(100001)

    repeat(n) {
        arr[readLine()!!.toInt()] += 1
    }

    for(i in 0 until 10001) {
        if(arr[i] > 0) {
            for(j in 0 until arr[i]) {
                bw.write("$i\n")
            }
        }
    }

    bw.flush()
    bw.close()
}