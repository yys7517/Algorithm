package org.example.Baekjoon.Bronze

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val list = mutableListOf<Int>()
    val numList =( 1..30).toList()

    for(i in 1..28) {
        list.add(sc.nextInt())
    }

    val filtered = numList.filter { it !in list }.sorted()

    println(filtered[0])
    println(filtered[1])
}