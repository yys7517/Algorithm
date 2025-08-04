package org.example.Baekjoon.Bronze

/**
 * https://www.acmicpc.net/problem/10809
 */
import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    val S = sc.nextLine()
    val array = IntArray(26) { -1 }

    S.forEachIndexed { idx, ch ->
        // 처음 나오는 위치를 표시
        if(array[ch-'a'] < 0) array[ch - 'a'] = idx
    }

    array.forEach {
        print("$it ")
    }
}