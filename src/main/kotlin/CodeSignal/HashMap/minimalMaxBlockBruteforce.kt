package org.example.CodeSignal.HashMap

fun minimalMaxBlockBruteforce(list: List<Int>): Int {
    var minMaxBlockSize = Int.MAX_VALUE
    var minNum = -1

    val uniqueElements = list.toSet()

    for (num in uniqueElements) {  // Avoid duplicates
        val indices = mutableListOf<Int>()
        for (i in list.indices) {
            if (list[i] == num) {
                indices.add(i)
            }
        }
        indices.add(0, -1)  // 경계 추가 -1 (시작)
        indices.add(list.size)            // 경계 추가 size (끝)

        var maxBlockSize = 0
        for (i in 1 until indices.size) {
            maxBlockSize = maxOf(maxBlockSize, indices[i] - indices[i - 1] - 1)
        }

        if (maxBlockSize < minMaxBlockSize) {
            minMaxBlockSize = maxBlockSize
            minNum = num
        }
    }

    return minNum
}

/**
 * 동작 과정:
 * 각 고유한 숫자마다 그 숫자가 등장하는 모든 인덱스를 찾습니다
 * 시작(-1)과 끝(list.size)을 추가하여 경계를 설정합니다
 * 연속된 인덱스들 사이의 간격을 계산해서 그 숫자가 없는 구간의 길이를 구합니다
 * 각 숫자별로 가장 긴 "공백 구간"을 찾습니다
 * 모든 숫자 중에서 이 "최대 공백 구간"이 가장 작은 숫자를 반환합니다
 *
 * 예시:
 * 리스트: [1, 2, 1, 3, 1, 2]
 * - 숫자 1: 인덱스 [0, 2, 4] → 공백 구간들 [1개, 0개, 1개] → 최대 1
 * - 숫자 2: 인덱스 [1, 5] → 공백 구간들 [1개, 3개, 0개] → 최대 3
 * - 숫자 3: 인덱스 [3] → 공백 구간들 [3개, 2개] → 최대 3
 *
 * 결과: 숫자 1 (최대 공백 구간이 1로 가장 작음)
 */