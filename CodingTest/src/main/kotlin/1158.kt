import java.io.*
import java.util.LinkedList

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (M, N) = readLine().split(" ").map { it.toInt() }

    var deque = LinkedList<Int>()

    for (i in 1 .. M) {
        deque.add(i)
    }

    var num = 0
    var str ="<"
    while (deque.size != 0) {
        num++
        if (num == N) {
            str = "$str${deque.poll()}"
            if (deque.isNotEmpty()) {
                str += ", "
            }
            num = 0
        }
        else {
            deque.add(deque.pop())
        }
    }
    str += ">"

    println(str)
}