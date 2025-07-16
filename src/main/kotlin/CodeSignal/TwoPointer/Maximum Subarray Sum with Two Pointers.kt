package org.example.CodeSignal.TwoPointer

// 슬라이딩 윈도우
fun maximumSum(numbers: IntArray, k: Int): Pair<Int, Int> {
    var left = 0
    var sum = 0L

    // 초기 k 크기의 윈도우의 합 left = 0, right = k-1
    for(i in 0 until k) {
        sum += numbers[i]
    }

    var maxSum = sum
    var maxFirstIndex = 0

    for( right in k until numbers.size ) {
        // 오른쪽으로 이동하면서 sum의 값이 변경됨. left 인덱스에 있던 값을 빼고, right 인덱스에 있던 값을 더함.
        sum += numbers[right] - numbers[left]
        left++

        if( sum > maxSum ) {
            maxSum = sum
            maxFirstIndex = left
        }
    }

    // return 최대 합, SubArray 인덱스
    return Pair(maxSum.toInt(), maxFirstIndex)
}