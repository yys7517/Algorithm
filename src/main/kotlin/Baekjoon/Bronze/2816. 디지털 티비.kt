package org.example.Baekjoon.Bronze

fun main() {
    var N = readLine()!!.toInt()
    val arr = Array(N) { "" }

    repeat(N) {
        arr[it] = readLine()!!
    }

    var sb = StringBuilder()

    var pointer = 0 // 현재 화살표 위치

    val index_1 = arr.indexOf("KBS1")
    for(i in 0 until index_1) {
        sb.append(1)
        pointer++
    }

    for(i in 0 until index_1) {
        val kbs1 = arr[pointer]
        arr[pointer] = arr[pointer-1]
        arr[pointer-1] = kbs1

        sb.append(4)
        pointer--
    }

    val index_2 = arr.indexOf("KBS2")
    for(i in 0 until index_2) {
        sb.append(1)
        pointer++
    }

    for(i in 0 until index_2 - 1) {
        val kbs2 = arr[pointer]
        arr[pointer] = arr[pointer-1]
        arr[pointer-1] = kbs2

        sb.append(4)
        pointer--
    }

    print(sb)
}