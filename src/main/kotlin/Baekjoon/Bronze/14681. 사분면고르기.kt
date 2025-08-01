package org.example.Baekjoon.Bronze

import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/14681
 */

fun main() {
    val sc = Scanner(System.`in`)
    val x = sc.nextLine().toInt()
    val y = sc.nextLine().toInt()

    if( x > 0 && y > 0 ) {
        println(1)
    } else if( x < 0 && y > 0 ) { 
        println(2)
    } else if( x < 0 && y < 0 ) {
        println(3)
    } else {
        println(4)
    }
}