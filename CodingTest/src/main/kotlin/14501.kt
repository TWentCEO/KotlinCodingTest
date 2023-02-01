import java.io.*

private lateinit var dL : Array<Int>
private lateinit var vL : Array<Int>

private var max = 0
private var num = 0
private var sum = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    num = readLine()!!.toInt()

    dL = Array<Int>(num+1) {0}
    vL = Array<Int>(num+1) {0}

    for (i in 1 .. num) {
        var (M, N) = readLine()!!.split(" ").map{it.toInt()}

        dL[i] = M
        vL[i] = N
    }

    for (i in 1 .. num) {
        if (i + dL[i] <= num + 1) {
            dp(i, 0)
        }
    }

    println(max)
}

private fun dp(d: Int, sV: Int) {
    if (d + dL[d] > num + 1) {
        max = Integer.max(max, sV)
    }
    else if (d+ dL[d] == num + 1) {
        sum = sV + vL[d]
        max = Integer.max(max, sV + vL[d])
    }
    else{
        sum = sV + vL[d]
        var tmp = sum
        for (i in d + dL[d] .. num) {
            sum = tmp
            dp(i, sum)
        }
    }
}