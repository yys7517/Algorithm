package org.example.Baekjoon.Silver

import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val (n,m) = nextLine().split(" ").map{ it.toInt() }
    val graph = Array(n+1) { IntArray(n+1) }
    val visit = ArrayList<Int>()
    var cnt = 0

    fun dfs(v: Int) {
        visit.add(v)

        for(i in 1..n) {
            // v랑 연결된 정점이고, 방문한 적이 없다면
            if(graph[v][i] == 1 && i !in visit) {
                dfs(i)
            }
        }
    }

    repeat(m) {
        val (u,v) = nextLine().split(" ").map { it.toInt() }
        graph[u][v] = 1
        graph[v][u] = 1
    }

    for(i in 1 .. n) {
        if(i !in visit) {
           cnt++
           dfs(i)
        }
    }

    println(cnt)
}