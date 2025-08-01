package org.example.Baekjoon.Bronze

/**
 * https://www.acmicpc.net/problem/10813
 */

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val NM = sc.nextLine().split(" ")
    val N = NM[0].toInt()
    val M = NM[1].toInt()

    val arr = IntArray(N) { i -> i+1 }

    repeat(M) {
        val ij = sc.nextLine().split(" ")
        val i = ij[0].toInt()
        val j = ij[1].toInt()

        swapArray(arr, i-1, j-1)
    }

    arr.forEach{
        print("$it ")
    }
}

fun swapArray(arr: IntArray, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}