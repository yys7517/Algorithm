package org.example.Baekjoon.Bronze

/**
 * https://www.acmicpc.net/problem/10810
 */
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val NM = sc.nextLine().split(" ")
    val N = NM[0].toInt()
    val M = NM[1].toInt()

    val arr = IntArray(N)

    repeat(M) {
        val ijk = sc.nextLine().split(" ")
        val i = ijk[0].toInt()
        val j = ijk[1].toInt()
        val k = ijk[2].toInt()

        for(idx in i-1..j-1) {
            arr[idx] = k
        }
    }

    arr.forEach{
        print("$it ")
    }
}