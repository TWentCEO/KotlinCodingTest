import java.io.*


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var num = readLine()!!.toInt()

    val arr = Array(num+1) {0}

    if (num >= 3) arr[3] = 1
    if (num >= 5) arr[5] = 1

    for (i in 6 ..num) {
        if (i % 5 == 0) {
            arr[i] = arr[i - 5] + 1
        }
        else if (i % 3 == 0) {
            arr[i] = arr[i - 3] + 1
        }
        else {
            if (arr[i - 3] != 0 && arr[i - 5] != 0) {
                arr[i] = Math.min(arr[i - 3], arr[i - 5]) + 1
            }
        }
    }

    if (arr[num] == 0) {
        println(-1)
    }
    else println(arr[num])
}