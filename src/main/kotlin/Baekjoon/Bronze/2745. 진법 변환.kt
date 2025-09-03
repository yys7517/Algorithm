package org.example.Baekjoon.Bronze

/**
 * https://www.acmicpc.net/problem/2745
 */
import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val N = next()
    val B = nextInt()

    val answer = N.toInt(B)  // B진법 수 N을 10진수로 변환
    println(answer)
}

/**
    1. 10진수를 N진수로 변환
    val decimalNumber = 123 // 10진수
    val binaryString = decimalNumber.toString(2) // 2진수로 변환
    val octalString = decimalNumber.toString(8)  // 8진수로 변환
    val hexString = decimalNumber.toString(16)   // 16진수로 변환

---------------------------------------------------------------------
    2. N진수를 10진법으로 변환
    val binaryString = "1111011" // 2진수 문자열
    val octalString = "173"     // 8진수 문자열
    val hexString = "7b"        // 16진수 문자열

    val decimalFromBinary = binaryString.toInt(2) // 2진수 문자열을 10진수로 변환
    val decimalFromOctal = octalString.toInt(8)   // 8진수 문자열을 10진수로 변환
    val decimalFromHex = hexString.toInt(16)    // 16진수 문자열을 10진수로 변환
*/
