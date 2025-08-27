package org.example.Baekjoon.Silver

/**
 * https://www.acmicpc.net/problem/1316
 */
import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextLine().toInt()

    var count = 0

    repeat(N) {
        val word = sc.nextLine()

        if(groupCheck(word)) {
            count++
        }
    }

    println(count)
}

private fun groupCheck(word: String): Boolean {
    val used = mutableListOf<Char>()

    if(word.length <= 2) {
        return true
    } else {
        var ch = word[0]    // 이전 알파벳

        for(i in 1 until word.length) {
            if(word[i] != ch && !used.contains(word[i])) {
                // 이전 알파벳이 다음 알파벳과 다르고, 다음 알파벳이 사용된 적이 없다면, 그룹 단어가 맞으니 계속 진행
                used.add(ch)
                ch = word[i]
            } else if( used.contains(word[i]) ) {
                return false
            }
        }

        return true
    }
}