//import java.io.*
//
//private lateinit var map : Array<Array<Int>>
//private lateinit var visited: Array<Array<Int>>
//
//private var N = 0
//private var M = 0
//
//private var x = 0
//private var y = 0
//Ï
//private var d = 0
//private val dx = intArrayOf(-1, 0, 1, 0)
//private val dy = intArrayOf(0, 1, 0, -1)
//
//fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//    readLine().split(" ").let {
//        N = it[0].toInt()
//        M = it[1].toInt()
//    }
//    readLine()!!.split(" ").let {
//        x = it[0].toInt()
//        y = it[1].toInt()
//        d = it[2].toInt()
//    }
//
//    map = Array(N) {Array(M) {0} }
//    visited = Array(N) {Array(M) {0} }
//
//    for (i in 0 .. N) {
//        readLine().split(" ").let {
//            for (j in 0 .. M) {
//                map[i][j] = it[j].toInt()
//            }
//        }
//    }
//}
//
//private fun clean() {
//
//}