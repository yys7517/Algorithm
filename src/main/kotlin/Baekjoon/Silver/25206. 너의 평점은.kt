package org.example.Baekjoon.Silver

/**
 * https://www.acmicpc.net/problem/25206
 */

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    // 전공평점은 전공과목별 (학점 × 과목평점)의 합을 학점의 총합으로 나눈 값이다.
    var sum = 0.0
    var sum1 = 0.0

    for(i in 1..20) {
        val info = sc.nextLine().split(" ")

        if(info.isEmpty()) {
            break
        }
        val grade1 = info[1].toDouble()
        val grade2 = when(info[2]) {
            "A+" -> 4.5
            "A0" -> 4.0
            "B+" -> 3.5
            "B0" -> 3.0
            "C+" -> 2.5
            "C0" -> 2.0
            "D+" -> 1.5
            "D0" -> 1.0
            "F" -> 0.0
            else -> continue
        }

        sum1 += grade1
        sum += grade1 * grade2
    }

    println(sum / sum1)
}

