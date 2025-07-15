package org.example.CodeSignal.HashMap

/**
 * In the mystical land of Lexiconia, a magical string s is hidden within a scroll.
 *
 * Your task is to reveal the mysterious chapters it contains by partitioning this string into as many segments as possible, ensuring no letter appears in more than one chapter.
 * Your objective is to transform these chapters into a list illustrating their lengths in the sequence they were extracted.
 *
 * Consider the string "abacdcd", where an intelligent partition would yield the chapters "aba" and "cdcd", resulting in lengths [3, 4].
 * 마지막 문자열이 나오는 곳에서 파티션을 나눠야 함.
 * a는 마지막 문자가 인덱스 2번에 나오고
 * b는 마지막 문자가 인덱스 1번에서 나오므로, 2번에서 파티션 나눔
 * start = 0, end = 2
 * 2 - 0 + 1 = 3
 *
 * c는 인덱스 5번, d는 인덱스 6번
 * start = 3, end = 6
 * 6 - 3 + 1 = 4
 *
 * [3, 4]
 * The string s can stretch up to an impressive length of 1,000,000 characters, composed entirely of lowercase English letters from 'a' to 'z'.
 * Your mission is to craft a Kotlin function solution(s: String): List<Int>
 *     that takes these magical characters and returns a list of integers representing each chapter's length,
 *     maintaining the order they appeared in the original string.
 *     The partition should ensure that each letter only appears in one segment.
 *
 * Constraints: 제약조건
 * The length of the input string n will be between 1 and 1,000,000. 문자열의 길이는 1 <= length <= 1,000,000
 * All characters in the string will be lowercase English alphabets ('a' to 'z'). 모든 문자열은 소문자
 * The solution must have a time complexity of O(n). 시간 복잡도는 O(n)
 */
private fun solution(s: String): List<Int> {
    val result = mutableListOf<Int>()
    val lastIndex = IntArray(26) // 각 문자의 마지막 인덱스 저장

    // 각 문자의 마지막 등장 위치를 찾음
    for (i in s.indices) {
        lastIndex[s[i] - 'a'] = i
    }

    var start = 0
    var end = 0

    for (i in s.indices) {
        // 현재 문자의 마지막 등장 위치까지 현재 파티션에 포함되어야 함
        end = maxOf(end, lastIndex[s[i] - 'a'])

        // 현재 위치가 파티션의 끝에 도달하면 파티션 완성
        if (i == end) {
            result.add(end - start + 1)
            start = i + 1
        }
    }

    return result
}