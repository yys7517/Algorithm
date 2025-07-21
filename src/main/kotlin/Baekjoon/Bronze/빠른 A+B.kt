package org.example.Baekjoon.Bronze

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    repeat(br.readLine().toInt()) {
        val st = StringTokenizer(br.readLine(), " ")
        val sum = (st.nextToken().toInt() + st.nextToken().toInt()).toString()
        bw.write(sum + "\n")    // write 함수는 string param을 받는다.
    }

    bw.flush()
    bw.close()
    br.close()
}