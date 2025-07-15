package org.example.LeetCode

/** Given an integer x, return true if x is a palindrome, and false otherwise.

Example 1:
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
*/
fun isPalindromeNumber(x: Int): Boolean {
    val s = x.toString()

    // 문자열의 시작부터 절반까지.. 끝에서부터 절반까지 반복하면
    for( i in 0..s.length/2 ) {
        if( s[i] != s[s.length-1-i] ) return false
    }

    return true
}