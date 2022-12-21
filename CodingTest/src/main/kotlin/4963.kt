import java.io.*

private lateinit var map: Array<Array<Int>>
private lateinit var visited: Array<Array<Int>>

private val dx = intArrayOf(0, 1, 0, -1, 1, 1, -1, -1)
private val dy = intArrayOf(1, 0, -1, 0, -1, 1, -1, 1)

fun main() = with (BufferedReader(InputStreamReader(System.`in`))) {
    while (true) {
        var count = 0
        val (W, H) = readLine()!!.split(" ").map { it.toInt() }

        if(W == 0 && H == 0){
            break
        }

        map = Array(H) { Array(W) {0} }
        visited = Array(H) { Array(W) {0} }

        for (i in 0 until H) {
            readLine()!!.split(" ").let {
                for (j in it.indices) {
                    map[i][j] = it[j].toInt()
                }
            }
        }

        for (i in 0 until H) {
            for (j in 0 until W) {
                if (map[i][j] == 1 && visited[i][j] == 0) {
                    dfs(i, j)
                    count++
                }
            }
        }
        println(count)
    }
}

private fun dfs(h: Int, w: Int) {
    visited[h][w] = 1
    for (i in 0 until 8) {
        var nx = w + dx[i]
        var ny = h + dy[i]
        if (nx in 0 until map[0].size && ny in map.indices && map[ny][nx] == 1 && visited[ny][nx] == 0) {
            dfs(ny, nx)
        }
    }
}