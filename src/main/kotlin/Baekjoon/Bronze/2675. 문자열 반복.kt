package org.example.Baekjoon.Bronze

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    repeat(sc.nextLine().toInt()) {
        val RS = sc.nextLine().split(" ")

        val R = RS[0].toInt()
        val S = RS[1]

        S.forEachIndexed { idx, ch ->
            repeat(R) { print(ch) }
        }
        println()
    }
}