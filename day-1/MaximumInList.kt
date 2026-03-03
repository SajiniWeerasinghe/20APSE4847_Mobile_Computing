fun main() {
    val numbers = listOf(10, 45, 23, 89, 12)
    var max = numbers[0]

    for (num in numbers) {
        if (num > max) {
            max = num
        }
    }

    println("Largest number: $max")
}
