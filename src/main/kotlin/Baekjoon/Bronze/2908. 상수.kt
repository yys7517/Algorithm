package org.example.Baekjoon.Bronze

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val numbers = sc.nextLine().split(" ")

    val num1 = numbers[0].reversed().toInt()
    val num2 = numbers[1].reversed().toInt()

    if(num1 > num2) print(num1) else print(num2)
}