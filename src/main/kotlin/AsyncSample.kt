import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val resultADeferred = async { methodA() }
    val resultBDeferred = async { methodB() }
    println("${resultADeferred.await()}, ${resultBDeferred.await()}")
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
