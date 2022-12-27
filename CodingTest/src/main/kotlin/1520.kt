import java.io.*

private lateinit var map: Array<Array<Int>>
private lateinit var visited: Array<BooleanArray>

private val dx = arrayOf(0, 0, 1, -1)
private val dy = arrayOf(1, -1, 0, 0)

private var count = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }

    map = Array(N) { Array(M) { 0 } }
    visited = Array(N) { BooleanArray(M) }

    for (i in 0 until N) {
        readLine().split(" ").let {
            for (j in 0 until M) {
                map[i][j] = it[j].toInt()
            }
        }
    }

    dfs(0, 0, N, M)

    println(count)
}

private fun dfs(x: Int, y: Int, N: Int, M: Int) {
    if (x == M-1 && y == N-1) {
        count++
    }
    visited[y][x] = true
    for (i in 0 until 4) {
        var nx = x + dx[i]
        var ny = y + dy[i]

        if (nx in 0 until M && ny in 0 until N && map[y][x] > map[ny][nx] && !visited[ny][nx]) {
            dfs(nx, ny, N, M)
            visited[ny][nx] = false
        }
    }
}