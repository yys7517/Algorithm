package org.example.Baekjoon.Silver

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val (N, K) = sc.nextLine().split(" ").map { it.toInt() }

    var triple = Triple(0,0,0)

    val arr = Array(N) { Triple(0, 0, 0) }

    repeat(N) {
        val (n,gold, silver, bronze) = sc.nextLine().split(" ").map{ it.toInt() }
        arr[n-1] = Triple(gold, silver, bronze)

        if(n == K) {
            triple = Triple(gold, silver, bronze)
        }
    }

    // 오름차순으로 정렬
    arr.sortWith(compareBy<Triple<Int, Int, Int>> { it.first }
        .thenBy{ it.second }
        .thenBy { it.third } )

    // 등수는 내림차순으로 정렬해야 알 수 있다.
    arr.reverse()

    for(idx in arr.indices) {
        if(arr[idx] == triple) {
            println(idx+1)
            break
        }
    }
}