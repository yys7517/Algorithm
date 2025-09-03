package org.example.Baekjoon.Bronze

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val decimalNumber = nextInt()
    val N = nextInt()

    println( decimalNumber.toString(N).uppercase() )
}