package org.example.Baekjoon.Bronze

import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/2884
 */
fun main() {
    val sc = Scanner(System.`in`)

    val h = sc.nextInt()
    val m = sc.nextInt()

    // 45분 일찍 알람 설정
    if( m >= 45 ) {
        print("$h ${m-45}")
    } else {
        if( h > 0 ) {
            print("${h-1} ${m-45 + 60}")
        } else {
            print("${h-1 + 24} ${m-45 + 60}")
        }
    }
}