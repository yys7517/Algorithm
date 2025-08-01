package org.example.Baekjoon.Bronze

import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/3052
 */
fun main() {
    val sc = Scanner(System.`in`)
    val set = hashSetOf<Int>()

    repeat(10) {
        set.add( sc.nextLine().toInt() % 42 )
    }

    print(set.size)
}