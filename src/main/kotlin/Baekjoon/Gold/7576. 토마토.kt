package org.example.Baekjoon.Gold

import java.util.*



fun main(args: Array<String>) {
    val (m, n) = readLine()!!.split(" ").map { it.toInt() }

    // val box = Array(n) { IntArray(m) }
    // repeat(n) { x ->
    //   val st = StringTokenizer(readLine(), " ")
    //   repeat(m) { y ->
    //     box[x][y] = st.nextToken().toInt()
    //   }
    // }

    // 이렇게 작성하면 더 간편
    val box = Array(n) {
        val st = StringTokenizer(readLine()!!, " ")
        IntArray(m) { st.nextToken().toInt() }
    }

    fun checkTomatoBox(): Boolean {
        for( x in 0 until n ) {
            for( y in 0 until m ) {
                if(box[x][y] == 0) {
                    // 안 익은게 하나라도 있다면
                    return false
                }
            }
        }

        return true
    }

    var isNothingTodo = checkTomatoBox()

    if(isNothingTodo) {
        print(0)
        return
    }

    data class Dot(val x: Int, val y: Int, val day: Int)

    val queue = LinkedList<Dot>()
    val visited = Array(n) { BooleanArray(m) }

    for( x in 0 until n ) {
        for( y in 0 until m ) {
            if(box[x][y] == 1) {
                queue.add(Dot(x, y, 0))
                // BFS가 익은 토마토에서 동시에 출발해야 하는데
                // 어차피 익은 곳에서 day값을 0으로 출발하면, 동시에 출발하는 것처럼 실행됨.
            }
        }
    }

    val dx = arrayOf(-1,1,0,0)
    val dy = arrayOf(0,0,-1,1)

    var day = 0

    while(queue.isNotEmpty()) {
        val dot = queue.poll()

        day = dot.day
        val x = dot.x
        val y = dot.y

        for(i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if(nx in 0 until n && ny in 0 until m) {

                if(box[nx][ny] == 0) {
                    box[nx][ny] = 1     // 익은 토마토로 처리
                    queue.add(Dot(nx, ny, day + 1))
                }
            }
        }
    }

    for(x in 0 until n) {
        for(y in 0 until m) {
            if(box[x][y] == 0) {
                // 모든 토마토가 익을 수 없는 상황이면
                println(-1)
                return
            }
        }
    }

    println(day)
}