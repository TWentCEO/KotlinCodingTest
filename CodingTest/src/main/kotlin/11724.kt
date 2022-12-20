import java.io.*
import java.util.Arrays

private lateinit var node: Array<Array<Int>>
private lateinit var visited: BooleanArray

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (N, M) = readLine()!!.split(" ").map{ it.toInt() }

    node = Array(N+1) { Array(N+1) {0} }
    visited = BooleanArray(N+1)
    repeat(M) {
        val (S, E) = readLine()!!.split(" ").map { it.toInt() }
        node[S][E] = 1
        node[E][S] = 1
    }

    var count = 0

    for (v in 1 until N+1) {
        if(!visited[v]) {
            dfs(v)
            count++
        }
    }

    bw.write("$count")
    bw.flush()
    bw.close()
}

private fun dfs(v: Int) {
    visited[v] = true
    for (i in visited.indices) {
        if (node[v][i]==1 && !visited[i]) {
            dfs(i)
        }
    }
}


