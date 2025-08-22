package org.example.Baekjoon.Bronze

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val word = sc.nextLine()

    val map = hashMapOf<Char, Int>()

    // 대소문자 구분 없이 개수 셈.
    word.forEach {
        if(map.containsKey(it.lowercaseChar())) {
            map[it.lowercaseChar()] = map[it.lowercaseChar()]!! + 1
        } else {
            map[it.lowercaseChar()] = 1
        }
    }

    val maxCount = map.values.max()

    if( map.count { entry -> entry.value == maxCount } > 1 ) {
        println("?")
    } else {
        val maxCh = map.filter { entry -> entry.value == maxCount }
        println(maxCh.keys.first().uppercaseChar())
        // 대문자로 출력한다.
    }
}