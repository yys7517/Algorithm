package org.example.CodeSignal.HashSet

/**
 * You are given a string s consisting of lowercase English letters, and a list of characters letters.
 * Both the string s and the list letters have lengths ranging from 1 to 1,000,000.
 *
 * Your task is to return a list containing the characters that are common to both the string s and the list letters.
 * Each element of the string and each element in the list letters are characters ranging from a to z.
 */

fun commonCharacters(s: String, letters: List<Char>): List<Char> {
    val list = mutableListOf<Char>()

    val set = letters.toHashSet()

    s.forEach { ch ->
        if( set.contains(ch) && !list.contains(ch) ) list.add(ch)
    }

    return list.sorted()
}