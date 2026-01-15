package org.example.Baekjoon.Gold

fun main() {

    // 도현이는 집이 많아서 좋겠다..
    val (N, C) = readLine()!!.split(" ").map { it.toInt() }
    val homes = IntArray(N) { readLine()!!.toInt() }.sorted()

    // println(homes)
    // 한 집에는 공유기를 하나만 설치할 수 있고,
    // 가장 인접한 두 공유기 사이의 거리를 가능한 크게 하여 설치

    // 1 2    4      8 9
    // 1 2  4    6   9

    // 1 4 9 (o)
    // 1 6 9 (o)
    // 1 2 9 (x)

    // 가장 인접한 두 공유기 사이의 거리가 최대가 되게 하는...

    // 우리가 구하고자 하는 것은
    // 가장 인접한 두 공유기 사이의 거리..
    // left, right를 어떻게?

    // 가장 인접한 두 공유기 사이의 거리가 최소, 최대가 되게 하는

    // 1, 2에 설치 or 8, 9에 설치 -> 거리가 최소
    // 9, 4에 설치해도 어차피 1에 최대 멀게 설정해도 1, 4에 설치
    var answer = 0

    // 공유기의 개수가 2이면, ( 2 <= C <= N )
    // 오름차순 정렬해서 양쪽 끝의 거리가 최대거리
    if(C == 2) {
        answer = homes[N-1] - homes[0]
    } else {
        var left = 1  // // 두 인접한 집 사이의 거리 최소
        var right = homes[N-1] - homes[0] // 최대

        while(left <= right) {
            val mid = (left + right) / 2  // mid는 공유기를 설치할 수 있는 최소 거리를 지정한 것이라고 생각하면 된다.

            var count = 1                   // 설치한 공유기 개수
            var lastInstalled = homes[0]    // 마지막으로 설치한 공유기 위치

            for( i in 1 until N ) {
                val tryInstall = homes[i]

                val dist = tryInstall - lastInstalled  // 가장 최근에 설치된 공유기와의 인접 거리

                if(dist >= mid) {
                    // 최소 거리보다 멀거나 같은 위치에 있다. => Best Practice! 인접 거리가 멀수록 좋다.

                    // 그러면 설치!
                    lastInstalled = tryInstall
                    count++
                }
            }

            if(C <= count) {
                // 현재 최소 거리로 설치할 수 있는 공유기가 더 많다?
                // 그럼 mid 값을 늘려도 된다.
                answer = mid  // 현재 최소 거리가 정답이 될 수도 있다.
                left = mid + 1
            } else {
                // 현재 지정한 최소 거리로 공유기를 다 설치 못하면,
                // 거리를 더 줄여야함.
                right = mid -1
            }
        }
    }

    print(answer)
}