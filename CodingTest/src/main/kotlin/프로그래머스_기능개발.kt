class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        var d = IntArray(progresses.size) {0}
        for (i in progresses.indices) {
            while (progresses[i] < 100) {
                progresses[i] += speeds[i]
                d[i]++
            }
        }

        var count = 1
        var max = d[0]
        for (i in 1 until d.size) {
            if (max < d[i]) {
                max = d[i]
                answer.add(count)
                count = 1
            } else {
                count++
            }
        }
        answer.add(count)
        return answer.toIntArray()
    }
}