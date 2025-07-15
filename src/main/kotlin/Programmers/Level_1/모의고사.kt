package Kotlin.Level_1

/** 모의고사
 * 완전탐색
 * 각 문제에 대한 정답이 answers와 같이 주어질 때,
 * 문제를 다음과 같이 찍었을 때, 가장 많이 맞춘 사람 번호를 리턴
 * 여럿일 경우, 번호를 오름차순으로 정렬해서 리턴
 * 문제의 정답은 1,2,3,4,5 중 하나

 * 1번 : 1,2,3,4,5 반복
 * 2번 : 2,1,2,3,2,4,2,5 반복
 * 3번 : 3,3,1,1,2,2,4,4,5,5 반복
 */

fun main() {
    println(
        solution(intArrayOf(1,2,3,4,5)).contentToString()
    )

    println(
        solution(intArrayOf(1,3,2,4,2)).contentToString()
    )
}

private fun solution(answers: IntArray): IntArray {
    val student1 = intArrayOf(1,2,3,4,5)
    val student2 = intArrayOf(2,1,2,3,2,4,2,5)
    val student3 = intArrayOf(3,3,1,1,2,2,4,4,5,5)
    val counts = intArrayOf(0,0,0)

    // students.size 마다 정답이 반복
    answers.forEachIndexed { index, answer ->
        // 1번 0 ~ 4, 5 ~ 9, 10 ~ 14 ..
        if( student1[index % student1.size] == answer ) {
            counts[0] += 1
        }

        // 2번 0 ~ 7, 8 ~ 15
        if( student2[index % student2.size] == answer ) {
            counts[1] += 1
        }

        // 3번 0 ~ 9, 10 ~ 19, 20 ~ 29
        if( student3[index % student3.size] == answer ) {
            counts[2] += 1
        }
    }

    val result = mutableListOf<Int>()

    counts.forEachIndexed { i, count ->
        if( count == counts.maxOrNull()!! ) {
            result.add(i+1)
        }
    }

    return result.sorted().toIntArray()
}