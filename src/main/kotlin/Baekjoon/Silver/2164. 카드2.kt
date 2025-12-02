package org.example.Baekjoon.Silver

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()

    val queue = ArrayDeque<Int>()

    for(i in 1..N) {
        queue.add(i)
    }

    var cnt = 1
    while (queue.size > 1) {
        if( cnt % 2 == 1 ) {
            queue.removeFirst()
        } else {
            queue.addLast(queue.removeFirst())
        }

        cnt++
    }

    println(queue.removeFirst())
}