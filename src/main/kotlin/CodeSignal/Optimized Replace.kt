package com.codesignal

import kotlin.math.*

fun optimizedReplace(A: List<Long>, B: List<Long>): List<Long> {
    // B[i]의 값과 가장 인접한 값을 가진 B의 인덱스 번호를 구한다.
    // C[i] = A[closestIndex]
    // ex) A = [10, 20, 30, 40, 50]
    // B = [7, 5, 1, 2, 4]

    // B[0] = 7 일때, 가장 인접한 값은 5이고, 인덱스 번호는 1이다
    // 따라서, C[0] = A[1] = 20

    // 값 to 인덱스 형태로 변경 후, 값을 기준으로 정렬한다. -> 인접한 값을 더 빠르게 찾기 위해서
    val sortedB = B.mapIndexed { index, value -> value to index }.sortedBy { it.first }

    val n = B.size

    // 원래 인덱스에 해당하는 B의 값이 sortedB에 위치한 인덱스 값
    val positionInSorted = IntArray(n)
    for ((sortedIndex, pair) in sortedB.withIndex()) {
        val originalIndex = pair.second
        positionInSorted[originalIndex] = sortedIndex
    }

    val C = MutableList(n) { 0L }

    for(i in 0..n-1) {
        val sortedIndex = positionInSorted[i]
        val value = B[i]

        // 이진 탐색을 통해, 인접한 값과 인덱스를 찾음
        val leftIndex = sortedIndex - 1
        val rightIndex = sortedIndex + 1

        val leftDiff = if(leftIndex >= 0) {
            abs(value - sortedB[leftIndex].first)
        } else Long.MAX_VALUE

        val rightDiff = if(rightIndex < n) {
            abs(value - sortedB[rightIndex].first)
        } else Long.MAX_VALUE

        val closestIndex = if(leftDiff < rightDiff) {
            sortedB[leftIndex].second
        } else {
            sortedB[rightIndex].second
        }

        C[i] = A[closestIndex]
    }

    return C
}