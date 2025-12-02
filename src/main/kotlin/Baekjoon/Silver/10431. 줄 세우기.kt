package org.example.Baekjoon.Silver

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    val T = sc.nextInt()

    repeat(T) {
        val t = sc.nextInt()

        val arr = IntArray(20)

        repeat(20) {
            arr[it] = sc.nextInt()
        }

        var cnt = 0
        for( i in 0 until 20 ) {
            cnt += arr.slice(0 until i).count { it > arr[i] }
        }
        println("$t $cnt")
    }
}