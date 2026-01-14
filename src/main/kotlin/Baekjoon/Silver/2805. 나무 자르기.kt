package org.example.Baekjoon.Silver

fun main() {
    val (N, target) = readLine()!!.split(" ").map { it.toInt() }
    val trees = readLine()!!.split(" ").map { it.toInt() }

    fun parameterSearch(): Long {
        var answer = 0L

        var left = 0L
        var right = trees.max().toLong()

        while (left <= right) {
            val height = (left + right) / 2

            var curr = 0L // 현재 height값으로 잘라낼 수 있는 나무 길이

            for (tree in trees) {
                if (tree > height) {
                    curr += tree - height
                }
            }

            if (curr >= target.toLong()) {
                // curr(얻을 수 있는 나무) > target
                // 현재 height가 정답이 될 수도 있다.
                answer = height

                // 하지만, height를 더 높여도 된다. 우리는 "적어도 target만큼만 확보하면 되니까"
                left = height + 1

                // 최대로 높이를 높여서, 얻을 수 있는 나무가 target과 같을 때에는, 우리가 원하는 최대 높이 값이 된다.
                // 더 이상 높일 수 없다..
            } else {
                // curr < target
                // 나무를 더 많이 얻으려면, 높이를 낮춰야 한다.
                right = height - 1
            }
        }

        return answer
    }

    print(parameterSearch())
}

//4 7
//20 15 10 17

//5 20
//4 42 40 26 46


