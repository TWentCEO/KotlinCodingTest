class Solution {
    fun solution(arr: IntArray): Int {
        var answer = arr[0]
        arr.forEach{
            answer = lcm(answer, it)
        }
        return answer
    }
    fun lcm(a: Int, i: Int): Int{
        return a * i / gcd(a, i)
    }

    fun gcd(a: Int, i: Int): Int{
        if (a % i == 0) return i

        return if (a < i) {
            gcd(i, a % i)
        }
        else gcd(i, a % i)
    }

}