package org.example.Baekjoon.Silver

import java.util.*

fun main() {
    val (n,m,v) = readLine()!!.split(" ").map{ it.toInt() }
    val graph = Array(n+1) { IntArray(n+1) }
    var visit = ArrayList<Int>(n+1)

    repeat(m) {
        val (x,y) = readLine()!!.split(" ").map { it.toInt() }
        graph[x][y] = 1
        graph[y][x] = 1
    }

    dfs(v, graph, visit)
    println()

    visit = ArrayList<Int>(n+1)
    bfs(v, graph, visit)
}

private fun dfs(start: Int, graph: Array<IntArray>, visit: ArrayList<Int>) {
    visit.add(start)
    print("$start ")

    for( i in 1 until graph.size ) {
        if( graph[start][i] == 1 && !visit.contains(i) ) {
            dfs(i, graph, visit)
        }
    }
}

private fun bfs(start: Int, graph: Array<IntArray>, visit: ArrayList<Int>) {
    val queue = LinkedList<Int>()
    queue.add(start)
    visit.add(start)

    while(queue.isNotEmpty()) {
        val v = queue.poll()
        print("$v ")

        for( i in 1 until graph.size ) {
            if( graph[v][i] == 1 && !visit.contains(i) ) {
                queue.add(i)
                visit.add(i)
            }
        }
    }
}