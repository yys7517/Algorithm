package org.example.CodeSignal.TwoPointer

fun findPairs(numbers: IntArray, target: Int): List<Pair<Int, Int>> {
    // 1. Sort Array (정렬)
    numbers.sort()

    // 2. left, right pointer
    var left = 0
    var right = numbers.size - 1

    val pairs = mutableListOf<Pair<Int, Int>>()

    while(left < right) {
        val total = numbers[left] + numbers[right]

        if( total == target ) {
            pairs.add(
                Pair(numbers[left], numbers[right])
            )

            // 중복된 숫자로 새로운 쌍을 만들지 않기 위해
            left++
            right--
        } else if ( total < target ) {
            left++
        } else {
            right--
        }
    }

    return pairs
}

fun main() {
    val numbers = intArrayOf(1, 3, 5, 2, 8, -2)
    val result = findPairs(numbers, 6)
    for (pair in result) {
        println("${pair.first} ${pair.second}")
    }
}