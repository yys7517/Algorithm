
import java.util.*

fun main() {
    val (N, Q) = readLine()!!.split(" ").map { it.toInt() }

    val length = 1 shl N     // 전체 격자 길이

    val map = Array(length) {
        val st = StringTokenizer(readLine())
        IntArray(length) { st.nextToken().toInt() }
    }

    val dx = arrayOf(-1, 1, 0, 0)
    val dy = arrayOf(0, 0, -1, 1)

    // 마법사가 시전하는 파이어스톰 단계
    val st = StringTokenizer(readLine(), " ")
    while(st.hasMoreTokens()) {
        val L = st.nextToken().toInt()
        val subLength = 1 shl L     // 부분 격자 길이

        /* 시계방향 90도 배열 회전
         4x4 배열에서
         [0, 0] -> [0, 3]
         [0, 1] -> [1, 3]
         [0, 2] -> [2, 3]
         [0, 3] -> [3, 3]

         [1, 0] -> [0, 2]
         [1, 1] -> [1, 2]
         [1, 2] -> [2, 2]

         [i, j] -> [j, size - 1 - i]*/

        val newBoard = Array(length) { IntArray(length) }

        // l씩 건너뛰면서 시작점을 기준으로, 회전을 시작.
        for(startX in 0 until length step subLength) {
            for(startY in 0 until length step subLength) {
                // 회전 시작
                for(i in 0 until subLength) {
                    for(j in 0 until subLength) {

                        newBoard[startX + i][startY +j] = map[subLength - 1 - j + startX][i + startY]
                        /* startX - 0
                         startY - 0
                         l = 4

                         newBoard[0][0] = A[3][0]
                         newBoard[0][1] = A[2][0]
                         newBoard[0][2] = A[1][0]
                         newBoard[0][3] = A[0][0]

                         newBoard[1][0] = A[3][1]
                         newBoard[1][1] = A[2][1]
                         newBoard[1][2] = A[1][1]


                         startX - 2
                         startY - 2
                         l = 2

                         newBoard[2 + 0][2 + 0] = A[3 ( 2-1-0+2 ) ][2 (0+2)]
                         newBoard[2 + 0][2 + 1] = A[2 ( 2-1-1+2 ) ][2]
                         newBoard[2 + 1][2 + 0] = A[3][3]
                         newBoard[2 + 1][2 + 1] = A[2][3]*/
                    }
                }
            }
        }

        // 인접한 얼음이 3개 미만이라면, 얼음을 녹인다.
        val melt = Array(length) { BooleanArray(length) }

        for(x in 0 until length) {
            for( y in 0 until length ) {
                if(newBoard[x][y] == 0) continue

                var count = 0       // 인접한 얼음 개수

                for(i in 0 until 4) {
                    val nx = x + dx[i]
                    val ny = y + dy[i]

                    if(nx < 0 || ny < 0 || nx >= length || ny >= length) continue

                    if(newBoard[nx][ny] > 0) count++
                }

                if(count < 3)
                    melt[x][y] = true
            }
        }

        for(i in 0 until length) {
            for( j in 0 until length ) {
                map[i][j] = newBoard[i][j]
                if(melt[i][j] && map[i][j] > 0) map[i][j]--
            }
        }
    }

    val visited = Array(length) { BooleanArray(length) }

    var iceCount = 0
    var maxCount = 0
    var sum = 0

    // dfs로 영역 내 얼음 개수 세기
    fun dfs(x: Int, y: Int) {
        if(map[x][y] == 0 || visited[x][y]) return

        visited[x][y] = true
        iceCount++

        for(i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if(nx < 0 || ny < 0 || nx >= length || ny >= length) continue
            if(visited[nx][ny]) continue

            dfs(nx, ny)
        }
    }

    for(i in 0 until length) {
        for(j in 0 until length) {
            sum += map[i][j]
            iceCount = 0             // 얼음 덩어리(연결 요소)마다, 얼음 개수 초기화
            dfs(i, j)
            maxCount = maxOf(maxCount, iceCount)   // 영역 하나 순회 다 마치고 나와서, max 값 갱신
        }
    }

//    sum = map.sumOf { it.sum() }
    println(sum)
    println(maxCount)
}