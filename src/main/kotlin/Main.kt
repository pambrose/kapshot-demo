import io.koalaql.kapshot.CapturedBlock

val simple: () -> Int = {
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
    println("captured source:\n{${captured.source.text}}")
    with(captured.source.location) {
        println("Path: $path, from line: ${from.line + 1}, to line: ${to.line + 1}")
    }

    println(equation { 2 + 2 })
}