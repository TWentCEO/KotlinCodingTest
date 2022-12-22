import java.io.*

private lateinit var map: Array<Array<Char>>
private var visited1 = mutableListOf<Char>()
private var visited2 = mutableListOf<Char>()

private val dx = arrayOf(0, 0, 1, -1)
private val dy = arrayOf(1, -1, 0, 0)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }

    map = Array(N) {Array(M) {' '} }

    for(i in 0 until N) {
        var string = readLine()
        for (j in 0 until M) {
            map[i][j] = string[j]
        }
    }

    visited1.add(map[0][0])
    visited2.add(map[0][0])

    dfs(0, 1, M, N, visited1)
    dfs(1, 0, M, N, visited2)

    val size1 = visited1.size
    val size2 = visited2.size

    if (size1 > size2) println(size1)
    else println(size2)
}

private fun dfs(x: Int, y: Int, M: Int, N: Int, visited: MutableList<Char>) {
    if (!visited.contains(map[y][x])) {
        visited.add(map[y][x])
        for (i in 0 until 4) {
            var nx = x + dx[i]
            var ny = y + dy[i]

            if (nx in 0 until M && ny in 0 until N && !visited.contains(map[ny][nx])) {
                dfs(nx, ny, M, N, visited)
            }
        }
    }
}