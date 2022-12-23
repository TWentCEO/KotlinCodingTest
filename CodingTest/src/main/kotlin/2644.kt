import java.io.*
import java.util.*

private lateinit var nodes: Array<LinkedList<Int>>
private var visited = mutableListOf<Int>()
private var result = 0
private var count = 0
private var n = 0
private var m = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine()!!.toInt()
    val (t1, t2) = readLine()!!.split(" ").map { it.toInt() }
    m = readLine()!!.toInt()

    nodes = Array(n+1) { LinkedList<Int>() }

    for (i in 0 until m) {
        val (n1, n2) = readLine()!!.split(" ").map { it.toInt() }

        nodes[n1].add(n2)
        nodes[n2].add(n1)
    }

    dfs(t1, t2)

    if (result != 0) {
        println(result)
    }
    else println(-1)
}

private fun dfs(n: Int, t: Int) {
    if (n == t) {
        result = count
    }
    visited.add(n)
    for (i in nodes[n]) {
        if (!visited.contains(i)) {
            count++
            dfs(i, t)
            count--
        }
    }
}