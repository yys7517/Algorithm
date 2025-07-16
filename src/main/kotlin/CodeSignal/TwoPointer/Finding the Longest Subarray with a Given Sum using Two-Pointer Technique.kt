package org.example.CodeSignal.TwoPointer

fun getLongestSubarray(array: IntArray, k: Int): List<Int> {

    // array의 부분 배열의 합이 k가 되는 부분 배열을 찾고
    // 먼저 나타나면서 가장 긴 길이를 가진 부분 배열을 return
    var start = 0
    var end = 0
    var sum = array[0]

    var maxLength = 0
    var resultStart = -1
    var resultEnd = -1

    while (end < array.size) {
        if (sum == k) {
            val length = end - start + 1

            // 최대 길이에 해당하고, 합을 이루는 부분 배열만 기록
            if (length > maxLength) {
                // 시간 복잡도 상 start, end를 기록
                resultStart = start
                resultEnd = end
                maxLength = length
            }

            // end 값을 변경하여, while문 반복 진행
            end++
            if (end < array.size) {
                sum += array[end]
            }

        } else if (sum < k) {
            end++
            if (end < array.size) {
                sum += array[end]
            }
        } else {
            sum -= array[start++]
        }
    }

    return if(resultStart == -1) emptyList() else array.slice(resultStart..resultEnd)
}