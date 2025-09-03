package org.example.Baekjoon.Bronze

/**
 * https://www.acmicpc.net/problem/11005
 */
import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val decimalNumber = nextInt()
    val N = nextInt()

    println( decimalNumber.toString(N).uppercase() )
}