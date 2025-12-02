package org.example.Baekjoon.Silver

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()

    data class BodySpec(val weight: Int, val height: Int)

    val list = mutableListOf<BodySpec>()

    repeat(N) {
        list.add(BodySpec(sc.nextInt(), sc.nextInt()))
    }

    for(i in list.indices) {
        var cnt = 0
        for( j in list.indices ) {
            if( i == j ) continue

            if( list[i].weight < list[j].weight && list[i].height < list[j].height ) {
                cnt++
            }
        }

        print("${cnt+1} ")
    }
}

