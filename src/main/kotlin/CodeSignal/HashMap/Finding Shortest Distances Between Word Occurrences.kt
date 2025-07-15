package org.example.CodeSignal.HashMap

// ex) listOf("apple", "banana", "apple", "orange", "banana", "apple")
// answer = mapOf("apple" to 2, "banana" to 3)

// 겹치지 않는 단어는 제외
// 겹치는 단어 중, 단어 간 인덱스 거리의 최소 값을 출력

// apple은 3개가 겹치고, banana는 2개가 겹친다.

// 첫 번째 apple과 두 번째 apple은 거리가 2
// 두 번째 apple과 마지막 apple은 거리가 3

// 첫 번째 banana와 마지막 banana는 거리가 3
// 따라서, apple to 2, banana to 3

private fun solution(wordList: List<String>): Map<String, Int> {
    val lastIndexMap = mutableMapOf<String, Int>()
    val minDistMap = mutableMapOf<String, Int>()

    for ((index, word) in wordList.withIndex()) {
        if (word in lastIndexMap) {
            val prevIndex = lastIndexMap[word]!!
            val dist = index - prevIndex
            val currentMin = minDistMap.getOrDefault(word, Int.MAX_VALUE)
            minDistMap[word] = minOf(currentMin, dist)
        }
        lastIndexMap[word] = index
    }

    return minDistMap
}