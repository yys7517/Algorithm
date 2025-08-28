package org.example.Baekjoon.Bronze

import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val array = Array(5) { CharArray(15) }

    for(i in 0 until 5) {
        val line = nextLine()
        for( j in 0 until line.length ) {
            array[i][j] = line[j]
        }
    }

    for(i in 0 until 15) {
        for(j in 0 until 5) {
            if(array[j][i]==' ' || array[j][i]== '\u0000') continue

            print(array[j][i])
        }
    }
}