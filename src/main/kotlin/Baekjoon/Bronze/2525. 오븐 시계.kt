package org.example.Baekjoon.Bronze

/**
 * https://www.acmicpc.net/problem/2525
 */

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val time = sc.nextLine().split(" ")
    val h = time[0].toInt()
    val m = time[1].toInt()

    val C = sc.nextLine().toInt()   // 요리 시간
    val ch = C / 60
    val cm = C % 60

    if( m + cm >= 60 ) {
        print("${ (h + ch + 1) % 24 } ${ (m + cm) % 60 }")
    } else {
        print("${ (h + ch) % 24 } ${ (m + cm) % 60 }")
    }
}