package org.example.Baekjoon.Bronze

/**
 * https://www.acmicpc.net/problem/2903
 */
import java.util.Scanner
import kotlin.math.pow

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()

    // (2^n + 1)^2
    println (
        (2.0.pow(n.toDouble()) + 1).pow(2.0).toInt()
    )
}