package org.example.CodeSignal

fun solution(nums: List<Int>): Int {
    // nums Integer 리스트가 주어졌을 때, 각 요소 쌍에 차이 값 중 가장 작은 값을 구하시오.

    // 제한조건
    // nums의 크기가 1일 때, 최소 절대 차이는 0, 비교할 쌍이 없기 때문
    // nums에는 중복된 숫자가 포함되지 않습니다.
    if(nums.size < 2) return 0

    val sortedNums = nums.sorted()
    var minDiff = Int.MAX_VALUE

    for( i in 0 until sortedNums.size - 1) {
        val diff = sortedNums[i+1] - sortedNums[i]

        if( diff < minDiff ) {
            minDiff = diff  // 최소값으로 초기화 하기
        }
    }

    return minDiff
}