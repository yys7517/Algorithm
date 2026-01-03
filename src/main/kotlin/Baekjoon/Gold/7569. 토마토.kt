package org.example.Baekjoon.Gold

import java.util.*

fun main(args: Array<String>) {
    val (m, n, h) = readLine()!!.split(" ").map { it.toInt() }

    val box = Array(h) {
        Array(n) {
            val st = StringTokenizer(readLine()!!, " ")
            IntArray(m) { st.nextToken().toInt() }
        }
    }

    fun checkTomatoBox(): Boolean {

        for( z in 0 until h ) {
            for( x in 0 until n ) {
                for( y in 0 until m ) {
                    if(box[z][x][y] == 0) {
                        // 하나라도 안 익은게 있다면
                        return false
                    }
                }
            }
        }

        return true
    }

    val isNothingToDo = checkTomatoBox()
    if(isNothingToDo) {
        print(0)
        return
    }

    data class Dot(val z: Int, val x: Int, val y: Int, val day: Int)

    val queue = LinkedList<Dot>()

    for( z in 0 until h ) {
        for( x in 0 until n ) {
            for( y in 0 until m ) {
                if(box[z][x][y] == 1) {
                    queue.add(Dot(z,x,y,0))
                }
            }
        }
    }

    val dx = arrayOf(-1, 1, 0, 0, 0, 0)
    val dy = arrayOf(0, 0, -1, 1, 0, 0)
    val dz = arrayOf(0, 0, 0, 0, -1, 1)

    var day = 0

    while(queue.isNotEmpty()) {
        val dot = queue.poll()

        day = dot.day
        val x = dot.x
        val y = dot.y
        val z = dot.z

        for(i in 0 until 6) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            val nz = z + dz[i]

            if( nx in 0 until n && ny in 0 until m && nz in 0 until h) {
                if(box[nz][nx][ny] == 0) {
                    box[nz][nx][ny] = 1
                    queue.add(Dot(nz, nx, ny, day + 1))
                }
            }

        }
    }

    for( z in 0 until h ) {
        for( x in 0 until n ) {
            for( y in 0 until m ) {
                if(box[z][x][y] == 0) {
                    // 모든 토마토가 익지 못하는 상황이라면?
                    print(-1)
                    return
                }
            }
        }
    }

    print(day)

}