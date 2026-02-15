package org.example.Baekjoon.Gold

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val coins = mutableListOf<Int>()

    val dp = IntArray(k+1)
    dp[0] = 1

    repeat(n) {
        val value = readln().toInt()
        coins.add(value)
    }

    coins.sort()

    for(coin in coins) {
        // coin을 하나씩 사용하면서 경우의 수를 구한다
        // coin 이상의 가치를 만들 때에만 경우의 수가 달라진다.
        // 예를 들어, 1원'만' 사용해서 만드는 경우의 수는 모두 1이다.
        // 여기서 2원을 뽑아서 사용한다 했을 때,
        // 2원 이상의 가치를 만들 때에, 경우의 수가 증가한다.
        for(i in coin..k) {
            dp[i] += dp[i-coin]
        }
    }

    // dp[i-coin]값을 계속 더해주는 이유.
    // 예를 들면
    // 3원을 만든다고 했을 때,
    // 우리는 1원을 만드는 경우에서, 2원을 더하면 3원을 만들 수 있다.
    // 그래서, dp[3]의 값을 갱신할 때, dp[1]의 값을 더해주는 것이다.
    // 또 예를 들면, 4원을 만든다면, 우리는 2원을 만드는 경우에서 2원을 더하면 되니까
    // dp[4]의 값을 dp[2]의 값을 더해서 갱신해주면 된다.
    println(dp[k])
}

