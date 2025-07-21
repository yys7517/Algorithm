package org.example.Baekjoon.Bronze

/**
 * https://www.acmicpc.net/problem/2480
 */
import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val dices = sc.nextLine().split(" ")
    //같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
    if(dices[0] == dices[1] && dices[1] == dices[2]) {
        println(10000 + dices[0].toInt() * 1000)
    } else if( dices[0] == dices[1] || dices[0] == dices[2] ) {
        //같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
        println(1000 + dices[0].toInt() * 100)
    } else if(dices[1] == dices[2]) {
        //같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
        println(1000 + dices[1].toInt() * 100)
    } else {
        //모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.
        val max = dices.max().toInt()
        println(max * 100)
    }
}