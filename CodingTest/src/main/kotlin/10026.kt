import java.io.*

private val dx = arrayOf(0, 0, 1, -1)
private val dy = arrayOf(1, -1, 0, 0)

private var firstCount = 0
private var secondCount = 0

private var n = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()

    val colorMap1 = Array(n) { Array(n) {' '} }
    val colorMap2 = Array(n) { Array(n) {' '} }

    for (i in 0 until n) {
        val string = readLine()!!
        for (j in 0 until n) {
            colorMap1[i][j] = string[j]

            if (string[j] == 'G') colorMap2[i][j] = 'R'
            else colorMap2[i][j] = string[j]
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (colorMap1[i][j] != ' ') {
                firstCount++
                dfs(i, j, colorMap1)
            }
            if (colorMap2[i][j] != ' ') {
                secondCount++
                dfs(i, j, colorMap2)
            }
        }
    }

    println("$firstCount $secondCount")

}

private fun dfs(x: Int, y: Int, colorMap: Array<Array<Char>>) {
    val color = colorMap[x][y]
    colorMap[x][y] = ' '
    for (i in 0 until 4) {
        var nx = x + dx[i]
        var ny = y + dy[i]
        if (nx in 0 until n && ny in 0 until n && color != ' ' && color == colorMap[nx][ny]) {
            dfs(nx, ny, colorMap)
        }
    }
}
