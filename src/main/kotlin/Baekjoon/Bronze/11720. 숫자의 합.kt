package org.example.Baekjoon.Bronze

/**
 * https://www.acmicpc.net/problem/11720
 */
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val N = sc.nextLine().toInt()
    val numbers = sc.nextLine()

    var sum = 0

    for(i in 0 until N) {
        sum += numbers[i].toString().toInt()
    }

    print(sum)
}