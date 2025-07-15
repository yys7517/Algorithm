package org.example.CodeSignal.HashSet

/**
 * Your task is to create a function in Kotlin that determines whether each galaxy in list1 is also present in list2.
 * The solution should efficiently use Kotlin's HashSet to optimize comparisons, rather than looping through arrays directly.
 *
 * Each element of the resulting Boolean list should indicate whether the corresponding galaxy from list1 was found in list2.
 * The order of results should match the order of galaxies in list1.
 *
 * For example, the first element of the Boolean list should reflect the presence of the first galaxy from list1 in list2.
 *
 * list1의 요소가 list2에 포함되있으면 true
 * 포함되어 있지 않다면 false
 *
 * val list1 = listOf("andromeda", "milkyway", "sombrero", "whirlpool")
 * val list2 = listOf("whirlpool", "andromeda", "triangulum")
 *
 * val result = listOf(true, false, false, true)
 * "andromeda", "whirlpool"이 포함되어 있으므로 true
 */

fun findGalaxies(list1: List<String>, list2: List<String>): List<Boolean> {
    val set = list2.toHashSet()

    return list1.map { s ->
        set.contains(s)
    }
}