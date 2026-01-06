package org.example.Baekjoon.Gold


fun main(args: Array<String>) {
    val N = readLine()!!.toInt()

    //단, 회의는 한번 시작하면 중간에 중단될 수 없으며
    //한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.

    val meetings = mutableListOf<Pair<Int, Int>>()

    repeat(N) {
        val (s, e) = readLine()!!.split(" ").map { it.toInt() }
        meetings.add(Pair(s, e))
    }

    // 끝나는 시간 기준으로 오름차순 정렬 후, 시작 시간을 기준으로 오름차순 정렬
    // 끝나는 시간이 빠른 회의부터 진행해야, 더 많은 회의를 진행할 수 있고,
    // 끝나는 시간이 같을 경우, 시작 시간이 더 빠른 회의를 진행해야 더 많은 회의를 진행할 수 있기 때문이다.
    val sortedMeetings = meetings.sortedWith(
        compareBy<Pair<Int, Int>> { it.second }
            .thenBy { it.first }
    )

//    println(sortedList)

    var lastEndTime = 0
    var count = 0
    var maxCount = 0

    for(i in 0 until N) {
        val meeting = sortedMeetings[i]
        val start = meeting.first
        val end = meeting.second

        if( start >= lastEndTime ) {
            count++
            lastEndTime = end
        }

        maxCount = maxOf(maxCount, count)
    }

    println(maxCount)
}