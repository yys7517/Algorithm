package Kotlin.Level_1

/**
 * 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return
 * 명함의 가로 길이와 세로 길이의 정보가 담겨진 2차원 배열

 * Hint ) 명함을 회전해서 수납할 수 있다 -> 어떤 길이든 가로가 될 수도 있고 세로도 될 수가 있다.

가로  세로
60  50
30  70
60  30
80  40

가로와 세로 중, 가장 긴 길이를 수용할 곳을 가로로 설정한다면
가로에는 80 60 60 70(명함 회전)
세로에는 30(명함 회전) 30 40 50

이때, 모든 명함들을 수납하려면 80 * 50 의 직사각형 크기가 필요하다.
최대의 최대 값과 최소의 최대 값을 찾아서 곱해주면 된다.
 */
fun main() {
    println(
        solution(
            arrayOf(intArrayOf(60,50), intArrayOf(30,70), intArrayOf(60, 30), intArrayOf(80, 40))
    )
    )

    println(
        solution(
        arrayOf(intArrayOf(10,7), intArrayOf(12,3), intArrayOf(8,15), intArrayOf(14,7) ,intArrayOf(5,15))
    )
    )

    println(
        solution(
        arrayOf(intArrayOf(14,4), intArrayOf(19,6), intArrayOf(6,16), intArrayOf(18,7), intArrayOf(7,11))
    )
    )
}

private fun solution(sizes: Array<IntArray>): Int {
//    val widths = mutableListOf<Int>()
//    val heights = mutableListOf<Int>()
//
//    // 가로를 최대 길이를 수용할 곳으로 설정한다면
//    sizes.forEach {
//        widths.add(max(it[0], it[1]))
//        heights.add(min(it[0], it[1]))
//    }
//
//    val answer = widths.max() * heights.max()

    // 최대 길이 중 최대, 최소 길이 중 최대를 모두 수용할 수 있는 크기가 정답
//    val answer = sizes.map { it.maxOrNull()!! }.maxOrNull()!! * sizes.map { it.minOrNull()!! }.maxOrNull()!!
    val answer = sizes.maxOf { it.maxOrNull()!! } * sizes.maxOf { it.minOrNull()!! }
    return answer
}