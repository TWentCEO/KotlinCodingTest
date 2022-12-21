import java.io.*
import java.util.Arrays

private lateinit var map: Array<Array<Int>>
private var M = 0
private var N = 0

private val dx = arrayOf(0,1,0,-1)
private val dy = arrayOf(1,0,-1,0)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var T = readLine()!!.toInt()

    repeat(T){
        var count = 0
        var list = mutableListOf<Int>()
        val MNK = readLine()!!.split(" ")
        M = MNK[0].toInt()
        N = MNK[1].toInt()
        var K = MNK[2].toInt()

        map = Array(N){ Array<Int>(M){0} }

        repeat(K) {
            val (X, Y) = readLine()!!.split(" ").map { it.toInt() }
            map[Y][X] = 1
        }
        for (y in 0 until N) {
            for (x in 0 until M) {
                if(map[y][x] == 1){
                    find(x, y)
                    count++
                }
            }
        }
        println(count)
    }
}

private fun find(x: Int, y: Int) {
    map[y][x] = 0
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx in 0 until M && ny in 0 until N){
            if(map[ny][nx] == 1){
                find(nx, ny)
            }
        }
    }
}