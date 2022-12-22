import java.io.*
import java.util.*

private lateinit var nodes: Array<LinkedList<Int>>
private lateinit var visited: BooleanArray

private var list = mutableListOf<Node>()

data class Node(val p: Int, val c: Int)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val num = readLine()!!.toInt()

    nodes = Array(num+1) { LinkedList<Int>() }
    visited = BooleanArray(num+1)
    for (i in 1 until num) {
        val (N, M) = readLine().split(" ").map { it.toInt() }

        nodes[N].add(M)
        nodes[M].add(N)
    }

    dfs(1)

    list.sortWith(compareBy<Node> {it.c})

    list.forEach { node ->
        println(node.p)
    }
}

private fun dfs(x: Int) {
    visited[x] = true

    for (i in nodes[x]) {
        if (!visited[i]) {
            dfs(i)
            list.add(Node(x, i))
        }
    }
}