package org.example.Baekjoon.Bronze

import java.util.Scanner


/**
 * https://www.acmicpc.net/problem/2753
 */
fun main() {
    val sc = Scanner(System.`in`)

    val year = sc.nextInt()

    if( (year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
        println(1)
    } else {
        println(0)
    }
}