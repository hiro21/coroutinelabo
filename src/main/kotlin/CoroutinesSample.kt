import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    println("test")
    runBlocking {
        launch {
            println("hello coroutines")
        }
    }
    println("test2")
}