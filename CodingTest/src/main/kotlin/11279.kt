import java.io.*
import java.util.*

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var n = readLine().toInt()

    val pd = PriorityQueue<Int>(reverseOrder())

    while (n-->0) {
        var i = readLine().toInt()
        when (i) {
            0 -> {
                var t = 0
                pd.poll()?.let{
                    t += it
                }
                println(t)
            }
            else -> {
                pd.add(i)
            }
        }
    }
}