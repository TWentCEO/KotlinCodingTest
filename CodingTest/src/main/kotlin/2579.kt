import java.io.*

private var arr = intArrayOf()
private var score = intArrayOf()
private var max = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine()!!.toInt()
    arr = IntArray(n + 1)
    score = IntArray(n + 1)
    for(i in 0.. n) {
        score[n] = readLine().toInt()
    }
    bottomUp(n)
    println(max)
}

private fun bottomUp(n: Int) {
    if (n == 1 || n == 0) max = arr[n]
    max = arr[]
}