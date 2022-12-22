import java.io.*

private lateinit var map: Array<Array<Int>>
private lateinit var visited: Array<BooleanArray>

private val dx = arrayOf(0, 0, 1, -1)
private val dy = arrayOf(1, -1, 0, 0)

private var n = 0
private var count = 0
private var height = 0
private var maxCount = Integer.MIN_VALUE
private var maxHeight = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine()!!.toInt()

    map = Array(n) { Array(n) { 0 } }

    for (i in 0 until n) {
        readLine().split(" ").let {
            for (j in 0 until n) {
                if (maxHeight < it[j].toInt()) maxHeight = it[j].toInt()
                map[i][j] = it[j].toInt()
            }
        }
    }

    while (height <= maxHeight) {
        count = 0
        visited = Array(n) { BooleanArray(n) { false } }
        height++

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (map[i][j] > height && !visited[i][j]) {
                    count++
                    dfs(i, j)
                }
            }
        }
        if (count > maxCount) {
            maxCount = count
        }
    }
    if (maxCount == 0) {
        maxCount++
    }
    println(maxCount)
}

private fun dfs(x: Int, y: Int) {
    visited[x][y] = true
    for (i in 0 until 4) {
        var nx = x + dx[i]
        var ny = y + dy[i]

        if (nx in 0 until n && ny in 0 until n && !visited[nx][ny] && height < map[nx][ny] ) {
            dfs(nx,ny)
        }
    }
}