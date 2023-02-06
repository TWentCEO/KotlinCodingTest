class Solution {
    fun solution(s: String): IntArray {
        var answer = mutableListOf<Int>()
        var str = s.substring(2, s.length - 2).split("},{").sortedBy{ it.length }
        str.forEach{ row -> row.split(",").forEach{
            if(!answer.contains(it.toInt())) answer.add(it.toInt())
        }}
        return answer.toIntArray()
    }
}