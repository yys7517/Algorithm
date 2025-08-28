package org.example.Baekjoon.Silver

import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/2563
 */

fun main() = with(Scanner(System.`in`)) {
    val N = nextLine().toInt()

    val total = N * 100
    val array = Array(101) { IntArray(101) }
    var count = 0

    repeat(N) {
        val info = nextLine().split(" ")
        val x = info[0].toInt()
        val y = info[1].toInt()

        for(i in x until x+10) {
            for(j in y until y+10) {
                if(array[i][j] == 1) {
                    continue
                }

                array[i][j] = 1
            }
        }
    }


    for(i in 1..100) {
        for(j in 1..100) {
            if(array[i][j] == 1) {
                count++
            }
        }
    }

    println(count)

}