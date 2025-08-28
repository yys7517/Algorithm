package org.example.Baekjoon.Bronze

/**
 * https://www.acmicpc.net/problem/2738
 */
import java.util.Scanner

fun main() = with(Scanner(System.`in`)){
    val N = nextInt()
    val M = nextInt()

    val array = Array(N) { IntArray(M) }
    val sb = StringBuilder()

    for (i in 0 until N) {
        for (j in 0 until M) {
            array[i][j] = nextInt()
        }
    }

    for (i in 0 until N) {
        for (j in 0 until M) {
            array[i][j] += nextInt()
            sb.append(array[i][j].toString()+ " ")
        }
        sb.append("\n")
    }

    println(sb)
}