package org.example.Baekjoon.Silver

fun main() {
    val N = readLine()!!.toInt()
    val cards = readLine()!!.split(" ").map { it.toInt() }.sorted()

    readLine()
    val nums = readLine()!!.split(" ").map { it.toInt() }

    fun getLeftIndex(target: Int): Int {
        var left = 0
        var right = N - 1

        var result = -1

        while(left <= right) {
            val mid = (left + right) / 2

            // target과 값이 같거나, 더 오른쪽에 있으면
            if( cards[mid] >= target ) {
                if(cards[mid] == target) result = mid   // target과 같다면 mid 값이 답이 될 수도 있다. 하지만 가장 왼쪽에 있는 값을 찾아야하기 때문에
                right = mid - 1 // 왼쪽으로 범위를 좁히면서 target보다 크거나 같은 값을 계속 찾는다.
            } else {
                // cards[mid] < target
                left = mid + 1
            }
        }

        return result
    }

    fun getRightIndex(target: Int) : Int {
        var left = 0
        var right = N - 1

        var result = -1

        while(left <= right) {
            val mid = (left + right) / 2

            // target 보다 왼쪽에 있다면,
            if( cards[mid] <= target) {
                if(cards[mid] == target) result = mid   // target과 같다면 mid 값이 답이 될 수도 있다. 하지만 오른쪽 값을 찾아야 하기 때문에.. 오른쪽으로 ㄱㄱ
                left = mid + 1  // 오른쪽으로 범위를 좁혀가면서 값을 찾는다.
            } else {
                right = mid - 1
            }
        }

        return result
    }

    val sb = StringBuilder()
    for( num in nums ) {
        val right = getRightIndex(num)
        val left = getLeftIndex(num)

        // target과 같은 값을 찾을 수 없다면
        if( left == -1 || right == -1 ) {
            sb.append(0).append(" ")
            continue
        }

        var count = right - left + 1
        sb.append(count).append(" ")
    }

    println(sb)
}