import java.util.*
import java.io.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val map = Array(n) { IntArray(m) }
    val visited = Array(n) { BooleanArray(m) }

    var sx = 0
    var sy = 0

    for (i in 0..n-1 ) {
        val line = readLine()!!.split(" ").map{ it.toInt() }
        for( j in 0..m-1 ) {
            map[i][j] = line[j]

            if(map[i][j] == 2) {
                sx = i
                sy = j
            }
        }
    }

    // map에서 0은 갈 수 없는 땅, 1은 갈 수 있는 땅, 2는 목표 지점

    fun bfs() {
        val queue = LinkedList<Pair<Int, Int>>()
        queue.add( Pair(sx, sy) )
        visited[sx][sy] = true
        map[sx][sy] = 0 // 0으로 만들어놓고 시작

        val dx = arrayOf(-1, 1, 0, 0)
        val dy = arrayOf(0, 0, -1, 1)

        while(queue.isNotEmpty()) {
            val tmp = queue.poll()

            val tx = tmp.first
            val ty = tmp.second

            for(i in 0..3) {
                val nx = tx + dx[i]
                val ny = ty + dy[i]

                // map을 벗어나면 스킵
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue


                if(map[nx][ny] == 1 && !visited[nx][ny]) {
                    map[nx][ny] = map[tx][ty] + 1
                    queue.add(Pair(nx, ny))
                    visited[nx][ny] = true
                }
            }
        }
    }

    bfs()

    // 원래 갈 수 없는 땅인 위치는 0을 출력하고, 
    // 원래 갈 수 있는 땅인 부분 중에서 도달할 수 없는 위치는 -1을 출력한다.
    for(i in 0..n-1) {
        for ( j in 0..m-1 ) {
            if(map[i][j] == 1 && !visited[i][j]) {
                map[i][j] = -1
            }

            bw.write(map[i][j].toString() + " ")
        }
        bw.write("\n")
    }

    bw.flush()
    bw.close()
}
