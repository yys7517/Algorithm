package Kotlin.Level_1

import kotlin.math.sqrt

/**
문제 설명
1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.

소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
(1은 소수가 아닙니다.)

제한 조건
n은 2이상 1000000이하의 자연수입니다.
 */

fun main() {
    println(
        solution(10)
    )

    println(
        solution(5)
    )
}

private fun solution(n: Int): Int {
    return (2..n).filter { isPrime(it) }.count()
}

private fun isPrime(n: Int): Boolean {
    if(n < 2) return false
    else if( n == 2 ) return true
    else {
        for( i in 2 .. sqrt(n.toDouble()).toInt() ) {
            if( n % i == 0 ) return false
        }
        return true
    }
}
