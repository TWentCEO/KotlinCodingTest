class Solution {
    fun solution(n: Int): Int {
        var list = IntArray(n+1)

        list[1] = 1
        list[2] = 1

        for (i in 3 .. n) {
            list[i] = (list[i-1] + list[i-2]) % 1234567
        }
        return list[n]
    }

}