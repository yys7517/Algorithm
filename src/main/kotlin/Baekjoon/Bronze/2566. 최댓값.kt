package org.example.Baekjoon.Bronze

import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/2566
 */

fun main() = with(Scanner(System.`in`)) {
    val array = Array(9) { IntArray(9) }
    var max = Int.MIN_VALUE
    var maxI = 0
    var maxJ = 0

    for(i in 0 until 9) {
        for(j in 0 until 9) {
            array[i][j] = nextInt()
            if( array[i][j] > max ) {
                max = array[i][j]
                maxI = i + 1
                maxJ = j + 1
            }
        }
    }

    println(max)
    println("$maxI $maxJ")
}