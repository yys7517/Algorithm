package org.example.LeetCode

fun main() {
    println(lengthOfLongestSubstring("abcabcbb"))
    println(lengthOfLongestSubstring("bbbbb"))
    println(lengthOfLongestSubstring("pwwkew"))
}

fun lengthOfLongestSubstring(s: String): Int {
    var subStr = ""
    var maxLen = 0

    for(i in s.indices) {
        // 중복되는 알파벳이 있다면, 가장 앞에 있는 그 알파벳이 나타나는 다음 지점부터 slice -> abca -> (a)bca -> bca -> bcaa -> (bca) -> a
        if (subStr.contains(s[i])) {
           subStr = subStr.slice(subStr.indexOf(s[i]) + 1 until subStr.length)
        }

        subStr += s[i]
        maxLen = maxOf(maxLen, subStr.length)
    }

    return maxLen
}