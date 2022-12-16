fun main() {
    val list = mutableListOf<Int>()
    for(i in 1..10000){
        if(!list.contains(i)){
            println(i)
        }
        var tmp = i
        var sum = tmp

        while(tmp != 0){
            sum += tmp%10
            tmp /= 10
        }
        list.add(sum)
    }
}