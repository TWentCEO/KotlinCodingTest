import java.io.*
import java.util.*

private lateinit var map : Array<Array<Int>>
private lateinit var visited : Array<BooleanArray>
private lateinit var copy: Array<Array<Int>>

private val dx = mutableListOf<Int>(-1,1,0,0)
private val dy = mutableListOf<Int>(0,0,-1,1)

private var N = 0
private var M = 0

private var ans = 0

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    readLine().split(" ").let {
        N = it[0].toInt()
        M = it[1].toInt()
    }

    map = Array(N) {Array(M) {0} }
    visited = Array(N) { BooleanArray(M){false} }
    copy = Array(N) {Array(M) {0} }

    for (i in 0 until N) {
        readLine().split(" ").let {
            for (j in 0 until M) {
                map[i][j] = it[j].toInt()
            }
        }
    }

    wall(0)
    println(ans)
}

private fun wall(cnt: Int) {
    if (cnt == 3) {
        for (i in 0 until N) {
            for (j in 0 until M) {
                visited[i][j] = false
                copy[i][j] = map[i][j]
            }
        }
        bfs()
        return
    }

    for(i in 0 until N){
        for(j in 0 until M){
            if(map[i][j]==0){
                map[i][j]=1
                wall(cnt+1)
                map[i][j]=0
            }
        }
    }
}

private fun bfs() {
    var q:Queue<Pair<Int,Int>> = LinkedList()
    for(i in 0 until N) {
        for(j in 0 until M) {
            if(copy[i][j]==2){
                q.add(Pair(i,j))
                visited[i][j]=true
            }
        }
    }

    while(!q.isEmpty()){
        var a = q.poll()
        for(i in 0 until 4){
            var dx = a.first + dx[i]
            var dy = a.second + dy[i]
            if(dx<0 || dx>=N || dy<0 || dy>=M || visited[dx][dy]){
                continue
            }
            if (copy[dx][dy] != 0)
                continue
            copy[dx][dy]=2
            visited[dx][dy]=true
            q.add(Pair(dx,dy))
        }
    }
    var count = 0
    for(i in 0 until N){
        for(j in 0 until M){
            if(copy[i][j]==0){
                count++
            }
        }
    }
    if(count>ans){
        ans=count
    }
    q.clear()
}