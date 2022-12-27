import java.io.*
import java.util.*
import kotlin.collections.HashMap

private lateinit var map: Array<Array<Int>>

private val dx = arrayOf(0, 0, 1, -1)
private val dy = arrayOf(1, -1, 0, 0)

data class Position(val x: Int, val y: Int)


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }

    map = Array(N+2){ Array(M+2) { 0 } }

    for(i in 1 .. N){
        var temp  = readLine()!!.toCharArray()

        for(j in 1 .. M){
            map[i][j] = Integer.parseInt(temp.get(j-1).toString())
        }
    }

    bfs(1,1)

    println(map[N][M])
}

private fun bfs(x: Int, y: Int) {
    val queue = LinkedList<Position>()
    queue.add(Position(x, y))
    while (!queue.isEmpty()) {
        val (x, y) = queue.poll()

        for (i in 0 until 4) {
            var nx = x + dx[i]
            var ny = y + dy[i]

            if (map[ny][nx] == 1) {
                map[ny][nx] = map[y][x]
                map[ny][nx]++
                queue.add(Position(nx, ny))
            }
        }
    }
}