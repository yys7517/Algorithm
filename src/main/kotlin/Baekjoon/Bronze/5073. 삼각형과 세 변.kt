package org.example.Baekjoon.Bronze

import kotlin.math.max
fun main() {
    while(true) {
        val (a,b,c) = readln().split(" ").map { it.toInt() }
        if(a == 0 && b == 0 && c == 0) break

        val max = max(max(a,b), c)

        if(a == b && b == c) {
            println("Equilateral")
        } else if( max == a && max >= b + c ) {
            println("Invalid")
        } else if( max == b && max >= a + c) {
            println("Invalid")
        } else if ( max == c && max >= a + b ) {
            println("Invalid")
        } else if( a != b && a != c && b != c) {
            println("Scalene")
        } else {
            println("Isosceles")
        }
    }
}