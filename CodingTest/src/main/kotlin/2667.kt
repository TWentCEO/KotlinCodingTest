import java.io.*

private lateinit var map: Array<IntArray>
private lateinit var visited: Array<IntArray>
private var list = mutableListOf<Int>()

private val dx = mutableListOf<Int>(0,1,0,-1)
private val dy = mutableListOf<Int>(1,0,-1,0)
private var count = 0
private var num = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    num = readLine()!!.toInt()

    map = Array(num+2){IntArray(num+2){0}}
    visited = Array(num+2){IntArray(num+2){0}}

    for (i in 1 .. num) {
        readLine()!!.forEachIndexed { index, c -> map[i][index+1] = c-'0' }
    }

    for (i in 1..num) {
        for(j in 1..num) {
            if (map[i][j] == 1 && visited[i][j] == 0) {
                dfs(i,j)
                list.add(count)
                count = 0
            }
        }
    }

    println(list.size)
    list.sort()
    list.forEach{i -> println(i)}
}

fun dfs(x:Int, y:Int){
    visited[x][y] = 1
    count++
    for(i in 0 until 4) {
        var nx = x + dx[i]
        var ny = y + dy[i]
        if(map[nx][ny] == 1 && visited[nx][ny] == 0){
            dfs(nx, ny)
        }
    }
}