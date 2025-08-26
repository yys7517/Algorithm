package org.example.Baekjoon.Silver

import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/2941
 */

fun main() {
    val sc = Scanner(System.`in`)
    var input = sc.nextLine()

    val matches = listOf("c=","c-","dz=","d-","lj","nj","s=","z=")

    var count = 0
    matches.forEach {
        while( input.contains(it) ) {
            count += 1
            input = input.replaceFirst(it, " ")
            // 동일한 크로아티아 알파벳이 나올 수 있으므로, replaceFirst를 사용해서 한 개씩 replace
            // 공백으로 변경하여, 다른 크로아티아 알파벳이 형성되지 않도록
        }
    }

    input = input.replace(" ", "")
    println(input.length + count)
}