package org.example.Baekjoon.Bronze

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    val str = sc.nextLine()

    var sum = str.length

    str.forEachIndexed { idx, ch ->
        sum += when(ch) {
            'A', 'B', 'C' -> 2
            'D', 'E', 'F' -> 3
            'G', 'H', 'I' -> 4
            'J', 'K', 'L' -> 5
            'M', 'N', 'O' -> 6
            'P', 'Q', 'R', 'S' -> 7
            'T', 'U', 'V' -> 8
            else -> 9
        }
    }

    print(sum)
}