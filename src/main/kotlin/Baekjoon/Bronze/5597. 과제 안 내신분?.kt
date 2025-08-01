package org.example.Baekjoon.Bronze

/**
 * https://www.acmicpc.net/problem/5597
 */
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val arr = IntArray(30)

    repeat(28) {
        arr[sc.nextLine().toInt() -1] = 1
    }

    arr.forEachIndexed{ idx, value ->
        if(value == 0) println(idx+1)
    }
}