package org.example.Baekjoon.Bronze

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    var X = sc.nextLine().toInt()

    repeat(sc.nextLine().toInt()) {
        val list = sc.nextLine().split(" ")
        X -= list[0].toInt() * list[1].toInt()
    }

    if( X == 0 ) {
        println("Yes")
    } else {
        println("No")
    }
}