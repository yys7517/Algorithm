package CodeSignal.TwoPointer

fun findChocPairs(sweetness: IntArray): MutableList<Pair<Int, Int>> {
    // TODO: implement the solution here
    // 1. sort
    sweetness.sort()
    
    // 2. two - pointer
    var left = 0
    var right = sweetness.size - 1
    
    val result = mutableListOf<Pair<Int, Int>>()
    
    while( left < right ) {
        val total = sweetness[left] + sweetness[right]

        // sweetness 배열에 두 수의 합이 0이되는 쌍을 찾아서 출력
        if( total == 0 ) {
            result.add(
                Pair( sweetness[right], sweetness[left] )
            )
        } else if( total < 0 ) {
            left++
        } else {
            right--
        }
    }
    
    return result
}