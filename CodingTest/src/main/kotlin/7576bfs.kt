import java.io.*
import java.util.LinkedList

private lateinit var map: Array<Array<Int>>
private var queue = LinkedList<Position>()

private val dx = arrayOf(0, 0, 1, -1)
private val dy = arrayOf(1, -1, 0, 0)

private var count = 0

private data class Position(val x: Int, val y: Int)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }

    map = Array(M) {Array(N) {0} }

    for (i in 0 until M) {
        var arr = readLine().split(" ").map { it.toInt() }
        for (j in 0 until N) {
            map[i][j] = arr[j]
        }
    }

    for (i in 0 until M) {
        for (j in 0 until N) {
            if (map[i][j] == 1) {
                queue.add(Position(j, i))
            }
        }
    }

    while (!queue.isEmpty()) {
        var (x, y) = queue.poll()
        for (i in 0 until 4) {
            var nx = x + dx[i]
            var ny = y + dy[i]

            if ( nx in 0 until N && ny in 0 until M && map[ny][nx] == 0) {
                map[ny][nx] = map[y][x]
                count = map[ny][nx]++
                queue.add(Position(nx, ny))
            }
        }
    }

    for (i in 0 until M) {
        for (j in 0 until N) {
            if (map[i][j] == 0) {
                count = -1
            }
        }
    }

    if (count == -1) {
        println(count)
    }
    else println(count)
}