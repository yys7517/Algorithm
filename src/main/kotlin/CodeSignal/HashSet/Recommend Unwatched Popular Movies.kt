package org.example.CodeSignal.HashSet

/** Recommend Unwatched Popular Movies
 * You are developing an application that provides users with movie recommendations based on their past viewing history.
 *
 * The goal is to identify a list of popular movies the user has not yet watched.
 *
 * You are provided with three lists: userHistory, popularMovies, and unpopularMovies.
 *
 * The userHistory list consists of unique integers representing the IDs of movies the user has already watched.
 *
 * The popularMovies list contains unique integers representing the IDs of movies that are currently popular according to some source.
 *
 * The unpopularMovies list contains unique integers representing movies that are not popular according to some other source.
 *
 * Note that it is possible to have an element that exists both in list popularMovies and in unpopularMovies.
 *
 * Your task is to develop a Kotlin function named recommendMovies that takes these three lists as inputs and returns a new list.
 * This list should contain the IDs of the popular movies that the user has not yet watched, and which are not included in the unpopularMovies list.
 *
 * The resulting list should be sorted in ascending order, and each ID in the list should be unique (no repeats).
 * 오름차순으로 리턴
 *
 * Note: The input lists can contain between
 * 1 and 1000000 elements (inclusive) and the elements are between
 * 1 and 1000000 inclusive.
 */

fun recommendMovies(userHistory: List<Int>, popularMovies: List<Int>, unpopularMovies: List<Int>): List<Int> {
    // popularMovies와 unpopularMovies에 동일한 중복된 ID 값이 존재할 수 있다.
    // userHistory = 유저가 감상했던 영화 ID 목록

    // popularMovies, unpopularMovies = 좋은 평, 나쁜 평을 기록한 영화 ID 목록
    // 결과 result = 유저가 감상하지 않은 영화 중, popular한 영화를 오름차순으로 출력
    // userHistory와 unpopular에 포함되지 않으면서 popular에만 포함된 영화 ID 들을 출력
    val historySet = userHistory.toHashSet()
    val unpopularSet = unpopularMovies.toHashSet()

    val result = popularMovies.filter {
        !historySet.contains(it) && !unpopularSet.contains(it)
    }

    return result.sorted()
}