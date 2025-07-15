package org.example.LeetCode

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    val l1 = ListNode(2)
    l1.next = ListNode(4)
    l1.next!!.next = ListNode(3)

    val l2 = ListNode(5)
    l2.next = ListNode(6)
    l2.next!!.next = ListNode(4)

    addTwoNumbers(l1, l2)
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var p1 = l1
    var p2 = l2

    val dummyHead = ListNode(0)
    var current = dummyHead
    var carry = 0   // carry - 올림 수

    while( p1 != null || p2 != null || carry != 0 ) {
        val val1 = p1?.`val` ?: 0
        val val2 = p2?.`val` ?: 0

        val sum = val1 + val2 + carry
        carry = sum / 10 // 올릴 자리 수는 두 합을 10으로 나눈 값

        current.next = ListNode(sum % 10)   // 올림 수를 제외한 자리수는 10으로 나눈 나머지 값
        current = current.next!!  // 결과 노드 포인터 이동

        // 현재 포인터 이동
        p1 = p1?.next
        p2 = p2?.next
    }

    // 결과 값은 dummyHead next 부터 node를 삽입했으므로
    return dummyHead.next
}