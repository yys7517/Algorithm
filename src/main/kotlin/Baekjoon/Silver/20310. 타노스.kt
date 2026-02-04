package org.example.Baekjoon.Silver

fun main() {
    val s = readLine()!!
    val zeroToRemove = s.count{ it == '0' } / 2 // 제거해야 하는 0의 개수
    val oneToRemove = s.count{ it == '1' } / 2  // 제거해야 하는 1의 개수

    // 원본 S를 재배치하면 안됨!!
    // 사전순으로 가장 빠르게 만들어야함.
    var removedOnes = 0
    var removedZeros = 0

    var afterRemoveOne = ""   //

    // 사전순으로 가장 빠르게 만들려면, 최대한 앞에 있는 1을 제거.
    for(i in 0 until s.length) {
        if( s[i] == '1' && removedZeros < oneToRemove )  {
            // 1을 skip하고, skip한 개수 증가
            removedZeros += 1
        } else {
            // 0 이거나, 이미 1을 충분히 skip한 상태면 newStr에 삽입
            afterRemoveOne += s[i]
        }
    }

    //println(afterRemoveOne)   // 1을 제거한 후의 String

     var resultStr = "" // 이제 0을 제거하자.

    // 0은 뒤에서부터 제거해야, 사전순으로 빨라진다.
     for(i in afterRemoveOne.length-1 downTo 0) {
       if(afterRemoveOne[i] == '0' && removedOnes < zeroToRemove) {
         removedOnes += 1
       } else {
         resultStr += afterRemoveOne[i]
       }
     }

    // 0을 제거하면서 resultStr에는 역순으로 삽입되었으므로 reversed 된 값을 출력
    val afterRemoveZero = resultStr.reversed()
    println(afterRemoveZero)
}