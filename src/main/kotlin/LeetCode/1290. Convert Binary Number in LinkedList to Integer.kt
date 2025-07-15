package org.example.LeetCode

/**
 * Linked List Node 에 이진수 0, 1 이 들어가있을 때, 정수로 변환
 *
 * ex) head = [1, 0, 1]
 * sum = 5
 */
fun getDecimalValue(head: ListNode?): Int {
    var p = head
    var sum = 0

    while(p != null) {
        sum = sum * 2 + p?.`val`!!
        p = p?.next
    }

    return sum
}