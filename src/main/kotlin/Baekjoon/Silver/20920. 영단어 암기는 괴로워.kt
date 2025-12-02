package org.example.Baekjoon.Silver

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val map = hashMapOf<String, Int>()  // 단어 별 횟수를 작성할 맵
    val (N, M) = br.readLine().split(" ").map { it.toInt() }

    val set = hashSetOf<String>()

    repeat(N) {
        val word = br.readLine()
        if(word.length >= M) {
            set.add(word)
            map[word] = map.getOrDefault(word, 0) + 1
        }
    }

    val result = set.sortedWith(
        compareBy<String> { map[it]?.times(-1) }    // 1. 자주 나온 단어 내림차순
        .thenBy { -it.length }  // 2. 길이 내림차순
        .thenBy { it })         // 3. 알파벳 오름차순

    result.forEach {
        bw.write(it + "\n")
    }

    bw.flush()
    br.close()
    bw.close()
}