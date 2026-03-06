package org.example.Baekjoon.Silver

fun main() {
    val (R, C, N) = readLine()!!.split(" ").map{ it.toInt() }
    val result = mutableListOf<Array<CharArray>>()  // result[N] = N초 후, map

    val firstMap = Array(R) { readLine()!!.toCharArray() }

    if (N <= 1) {
        printMap(firstMap)
        return
    }

    // 0초, 1초 모두 같은 지도이다.
    result.add(firstMap)
    result.add(firstMap)

    val dx = intArrayOf(-1,1,0,0)
    val dy = intArrayOf(0,0,-1,1)

    for(n in 2..N) {
        if(n % 2 == 0) {
            // 짝수 초에는, 전체 map에 폭탄이 설치된다.
            result.add(Array(R) { CharArray(C) {'O'} })
        } else {
            // 3초 전에 설치된 폭탄들 기준으로 터진다.
            val prevMap = result[n-1] // 이전 맵 기준으로 갱신
            val bombMap = result[n-3] // 3초 전에 설치된 폭탄 위치

            val currMap = Array(R) { CharArray(C) {'O'} }

            for(x in 0 until R) {
                for(y in 0 until C) {
                    // 3초 전에 폭탄이 있던 곳이라면
                    if(bombMap[x][y] == 'O') {
                        prevMap[x][y] = '.' // 자기 자리도 터진다.

                        for(i in 0 until 4) {
                            val nx = x + dx[i]
                            val ny = y + dy[i]

                            // 좌표 범위라면
                            if(nx in 0 until R && ny in 0 until C) {
                                prevMap[nx][ny] = '.'
                            }
                        }
                    }
                }
            }

            result[n-1] = prevMap // 이전 지도에 폭탄이 있던 곳이 지워졌을 수 있으므로 이전 지도 갱신

            // 이전 맵에서 폭탄을 터뜨린 후, n번째에 삽임
            result.add(prevMap)
        }
    }

    // N초 후, map
    val mapN = result[N]
    printMap(mapN)
}


fun printMap(map: Array<CharArray>) {
    for(x in map.indices) {
        for(y in map[x].indices) {
            print(map[x][y])
        }
        println()
    }
}