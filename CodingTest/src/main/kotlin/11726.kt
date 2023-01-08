import java.io.*

private var array = intArrayOf()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine()!!.toInt()
    array = IntArray(n+1)
    println(topDown(n))
}

private fun topDown(n: Int) : Int {
    if (n == 0 || n == 1) return 1
    if (array[n] != 0) return array[n]

    array[n] = (topDown(n - 1) + topDown(n - 2)) % 10007
    return array[n]
}