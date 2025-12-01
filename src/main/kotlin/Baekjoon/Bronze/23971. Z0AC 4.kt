package org.example.Baekjoon.Bronze

import kotlin.math.*

fun main() {
    val (H, W, N, M) = readln().split(" ").map { it.toInt() }
    val answer = ceil((H.toFloat() / (N + 1))).toInt() * ceil(W.toFloat() / (M + 1)).toInt()
    println(answer)
}