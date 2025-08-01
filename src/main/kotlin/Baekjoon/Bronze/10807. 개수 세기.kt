package org.example.Baekjoon.Bronze

/**
 * https://www.acmicpc.net/problem/10807
 */
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val size = sc.nextLine().toInt()
    val array = IntArray(size)

    repeat(size) { i ->
        array[i] = sc.nextInt()
    }
    sc.nextLine()

    val find = sc.nextInt()
    print(array.count { it == find })
}