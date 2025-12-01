package org.example.Baekjoon.Silver

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val n = nextLine().toInt()
    val m = nextLine().toInt()
    val graph = Array(n+1) { IntArray(n+1) }
    val visit = ArrayList<Int>()
    var cnt = 0

    repeat(m) {
        val (u,v) = nextLine().split(" ").map { it.toInt() }
        graph[u][v] = 1
        graph[v][u] = 1
    }

    fun bfs(v: Int) {
        val queue = LinkedList<Int>()
        queue.add(v)
        visit.add(v)

        while(queue.isNotEmpty()) {
            val tmp = queue.poll()

            for(i in 1..n) {
                if(graph[tmp][i] == 1 && i !in visit) {
                    cnt++
                    visit.add(i)
                    queue.add(i)
                }
            }
        }
    }

    bfs(1)
    println(cnt)
}