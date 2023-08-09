import io.koalaql.kapshot.CapturedBlock

val simple = {
    println("Simple!")
    5
}

val captured =
    CapturedBlock {
        println("Hello!")
        4
    }

fun equation(block: CapturedBlock<Int>): String {
    val result = block() // invoke the block
    return "${block.source} = $result"
}

fun main(args: Array<String>) {
    println("simple returned: ${simple()}")
    println("captured returned: ${captured()}")
    println("captured source: ${captured.source.text}")

    captured.source.location.apply {
        println("Path: $path, From: ${from.line + 1}, To: ${to.line + 1}")
    }

    println(equation { 2 + 2 })
}