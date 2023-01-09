import java.io.*
import java.util.StringTokenizer

private var nL = intArrayOf()
private var oL = intArrayOf(0, 0, 0, 0)
private var max = Integer.MIN_VALUE
private var min = Integer.MAX_VALUE
private var N = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    N = readLine()!!.toInt()

    var st = StringTokenizer(readLine(), " ")

    nL = IntArray(N)

    repeat(N) {
        nL[it] = Integer.parseInt(st.nextToken())
    }

    st = StringTokenizer(readLine(), " ")

    for (i in 0 until 4) {
        oL[i] = Integer.parseInt(st.nextToken())
    }

    dfs(nL[0], 1);

    println(max);
    println(min);
}

private fun dfs(num: Int, index: Int) {
    if (index == N) {
        println("$num, $index")
        max = Integer.max(max, num)
        min = Integer.min(min, num)
        return
    }

    for (i in 0 until 4) {
        if (oL[i] > 0) {
            oL[i]--

            when (i) {
                0 -> dfs(num + nL[index], index + 1)
                1 -> dfs(num - nL[index], index + 1)
                2 -> dfs(num * nL[index], index + 1)
                3 -> dfs(num / nL[index], index + 1)
            }

            oL[i]++
        }
    }
}