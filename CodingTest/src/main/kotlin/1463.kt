import java.io.*
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var num = readLine()!!.toInt()

    val arr = Array(num+1) {0}

    for (i in 2 .. num) {
        arr[i] = arr[i - 1] + 1
        if (i % 3 == 0) arr[i] = min(arr[i], arr[i / 3] + 1)
        if (i % 2 == 0) arr[i] = min(arr[i], arr[i / 2] + 1)
    }

    println(arr[num])
}