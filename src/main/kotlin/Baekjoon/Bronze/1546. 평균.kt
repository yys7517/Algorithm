package org.example.Baekjoon.Bronze

/**
 * https://www.acmicpc.net/problem/1546
 */

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextLine().toInt()
    val arr = DoubleArray(N)

    repeat(N) {
        arr[it] = sc.nextInt().toDouble()
    }

    val max = arr.max()

    arr.forEachIndexed { idx, value ->
        arr[idx] = (arr[idx] / max) * 100.0
    }

    print(arr.average())
}