fun main() {
    val text = "Kotlin"
    var count = 0

    for (char in text.lowercase()) {
        if (char == 'a' || char == 'e' || char == 'i' || char == 'o' || char == 'u') {
            count++
        }
    }

    println("Number of vowels: $count")
}