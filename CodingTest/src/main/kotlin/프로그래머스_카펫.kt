class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = IntArray(2)
        var a = (brown + yellow)
        for (i in 3 .. (a / 3)) {
            if ((i - 2) * ((a / i)-2) >= yellow) {
                answer[0] = i
                answer[1] = a / i
            }
        }
        return answer
    }
}