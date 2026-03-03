fun main() {
    val words = listOf("Apple", "Banana", "Mango")
    val reversedList = mutableListOf<String>()

    for (i in words.size - 1 downTo 0) {
        reversedList.add(words[i])
    }

    println("Reversed list: $reversedList")
}