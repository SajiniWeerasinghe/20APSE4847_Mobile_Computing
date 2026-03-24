fun main() {
    val correctNumber = 7
    var guess = 7

    while (guess != correctNumber) {
        print("Enter a number between 1 and 10: ")
        guess = readLine()!!.toInt()

        if (guess != correctNumber) {
            println("Wrong guess. Try again.")
        }
    }

    println("Correct! You guessed the number.")
}