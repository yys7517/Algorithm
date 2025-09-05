package org.example.Baekjoon.Bronze

import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    while(true) {
        val a = nextInt()
        val b = nextInt()

        if( a == 0 && b == 0)
            return

        if( b / a > 1 && b % a == 0 ) { // 첫 번째 숫자가 두 번째 숫자의 약수이다.
            println("factor")
        } else if( a / b > 1 && a % b == 0 ) {  // 첫 번째 숫자가 두 번째 숫자의 배수이다.
            println("multiple")
        } else {
            println("neither")
        }
    }
}