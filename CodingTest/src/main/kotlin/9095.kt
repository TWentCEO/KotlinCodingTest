import java.io.*

private var t = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    t = readLine()!!.toInt()

    repeat(t) {
        var num = readLine()!!.toInt()

        val arr = Array(num+1) {0}

        val m = when(num) {
            1 -> 1
            2 -> 2
            3 -> 4
            else -> null
        }

        if (m != null) {
            println(m)
        }
        else {
            arr[1] = 1
            arr[2] = 2
            arr[3] = 4
            for (i in 4..num) {
                arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3]
            }
            println(arr[num])
        }
    }
}