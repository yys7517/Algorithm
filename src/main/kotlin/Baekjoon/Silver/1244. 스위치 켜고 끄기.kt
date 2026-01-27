package org.example.Baekjoon.Silver

fun main() {

    val num = readLine()!!.toInt()  // 스위치 수
    val tmp = readLine()!!.split(" ").map { it.toInt() }

    // 인덱스랑 번호랑 맞게
    val switches = IntArray(num + 1)
    for(i in 1..num) {
        switches[i] = tmp[i-1]
    }

    val std = readLine()!!.toInt()    // 학생 수

    // 토글 스위치
    fun toggle(num: Int) : Int {
        if(num == 1) return 0
        return 1
    }

    repeat(std) {
        val (gen, n) = readLine()!!.split(" ").map { it.toInt() }

        // 여학생 : n, n-i == n+i
        // 남학생: n의 배수

        // gen == 1 남학생
        // gen == 2 여학생
        if(gen == 1) {
            for(i in 1..num) {
                if( i % n == 0 ) {
                    switches[i] = toggle(switches[i])
                }
            }
        } else {
            switches[n] = toggle(switches[n]) // n번째 값 토글

            var lt = n - 1
            var rt = n + 1

            while( lt >= 1 && rt <= num && (switches[lt] == switches[rt]) ) {
                switches[lt] = toggle(switches[lt])
                switches[rt] = toggle(switches[rt])
                lt -= 1
                rt += 1
            }
        }
    }

    for(i in 1..num) {
        print("${switches[i]} ")
        if( i % 20 == 0 ) println()
    }
}