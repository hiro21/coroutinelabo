import kotlinx.coroutines.*

/**
 * 意図した動きをしないasyncのサンプル
 * すべてメインthreadで動いている
 */
fun main(args: Array<String>) = runBlocking {
    val resultADeferred = methodA()
    val resultBDeferred = methodB()
    println("${resultADeferred.await()},${resultBDeferred.await()}")
}

private suspend fun methodA() = coroutineScope {
    async {
        println("beforeA")
        delay(1000)
        println("afterA")
        "result A"
    }
}

private suspend fun methodB() = coroutineScope {
    async{
        println("beforeB")
        delay(3000)
        println("afterB")
        "result B"
    }
}

