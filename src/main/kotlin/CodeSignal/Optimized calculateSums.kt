package org.example.CodeSignal

import kotlin.math.*

/**
 * Your mission, should you choose to accept it, is to create a very special kind of map – a function or method, so to speak – that can calculate the total value of all the points (integer numbers) along the road between Town A and Town B, both towns included,for a number of different queries.
 *
 * You might find towns A and B at the same location (i.e., a equals b) or Town A could be located before or after Town B along the road.
 *
 * Just to give you an idea of what you're getting into, let's consider an instance when Town A is at point 1 (i.e., a=1) and Town B is at point 5 (so b=5).
 * Here, the summation of all the points from Town A to Town B inclusive, which are 1, 2, 3, 4, 5, comes up to 15. We hope your map (or function) could calculate this total in similar situations.
 *
 * Of course, in the best interests of Integerland and the occasional travelers, we'd like you to optimize this map.
 * It is essential that it works as efficiently as possible. Your understanding of complexity analysis and various ways of optimizing this task will certainly come in handy.
 *
 * Best of luck on your endeavor!
 */
fun calculateSums(queries: List<Pair<Int, Int>>): List<Long> {
    // queries = Pair(a, b)를 담고있는 리스트
    // Pair(1,5)이면, 1+2+3+4+5 = 15
    // queries = [ Pair(1,5), Pair(2,3) ... ]
    // return queries = [ 15, 5, ... ] 으로 표시

    // 1 ≤ a,b ≤ 1000000000.
    // 1 ≤ queries.size() ≤ 100000

    return queries.map { (a,b) ->
        val start = min(a,b).toLong()
        val end = max(a,b).toLong()
        val n = end - start + 1

        n * (start + end) / 2
    }
}