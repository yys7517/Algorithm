package org.example.Baekjoon.Silver

/**
 * https://www.acmicpc.net/problem/24511
 */
import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val N = br.readLine().toInt()
    val type = br.readLine().split(" ").map { it.toInt() }
    val queueStack = br.readLine().split(" ").map { it.toInt() }
    val M = br.readLine().toInt()
    val insert = br.readLine().split(" ").map { it.toInt() }

    val deque = ArrayDeque<Int>()

    // 스택(1)은 삽입한 값과, pop 값이 같으므로 제외하고 큐(0) 타입의 원소만, deque 초기 값으로 설정
    for(i in type.indices) {
        if(type[i] == 0) {
            deque.add(queueStack[i])
        }
    }

    val sb = StringBuilder()

    // M 길이의 수열 삽입
    for(i in insert.indices) {
        deque.addFirst(insert[i])
        sb.append("${deque.removeLast()} ")
    }

    bw.write(sb.toString())
    bw.flush()
    bw.close()
    br.close()
}