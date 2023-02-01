import java.io.*
import java.util.*

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val num = readLine().toInt()
    val deque = LinkedList<Int>()
    repeat(num) {
        readLine().split(" ").let {
            when(it[0]) {
                "push_front" -> deque.addFirst(it[1].toInt())
                "push_back" -> deque.add(it[1].toInt())
                "pop_front" -> if(deque.size != 0) println(deque.pollFirst()) else println("-1")
                "pop_back" -> if(deque.size != 0) println(deque.removeLast()) else println("-1")
                "size" -> println(deque.size)
                "empty" -> if(deque.size ==0) println("1") else println("0")
                "front" -> if (deque.size != 0) println(deque.first) else println("-1")
                else -> if (deque.size != 0) println(deque.last) else println("-1")
            }
        }
    }
}