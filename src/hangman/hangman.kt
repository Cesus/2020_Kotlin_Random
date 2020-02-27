package hangman

// Import random class
import java.util.*

// Starts the program
fun main() {

    // Initialize a variable for the name of the user (doesn't work in a while loop)
    var name: String

    // Get name from user
    while(true) {
        print("Hi, welcome to hangman. Please enter your name: ")
        name = readLine().toString()
        if (name.isNotBlank()) break
    }

    // Initialize a variable that the user will have to guess
    var secretWord: String

    // Generate true or false, if false user will have to guess kotlin, if true user will need to guess their own name
    val flipACoin = Random().nextBoolean()
    secretWord = when (flipACoin) {
        true -> name
        false -> "kotlin"
    }

    // Declare variables
    var gameOver: Boolean ?= false
    var strikes = 0
    val secretLetters = secretWord.toLowerCase().toCharArray().toHashSet()
    val correctGuesses = mutableSetOf<Char>()
    val wrongGuesses = mutableSetOf<Char>()

    // If player has not guessed all the word, keep iterating
    while (secretLetters != correctGuesses) {

        // Check if player has lost or not, if so, exit while loop
        if (strikes >= 5) {
            gameOver = true
            break
        }

        // Function prints all known letters
        printKnownLetters(secretWord, correctGuesses)

        println("\nWrong Guesses: $wrongGuesses \nTotal: $strikes")

        // Ask user for a letter, if it is empty or null, user is told to input 1 letter TODO (no # allowed)
        print("Guess letter: ")
        val guess = readLine()
        if (guess == null) {
            continue
        } else if (guess.length != 1) {
            println("Please enter ONE letter")
            continue
        }

        /* If user's guess was already picked, user is told to choose a different letter;
           If user's guess is part of the secret word, it is added to an array of letters the user guessed correctly;
           Else, it is wrong and user gets a strike;
        */
        when {
            wrongGuesses.contains(guess.single()) or correctGuesses.contains(guess.single()) -> {
                println("You have already entered this.")
            }
            secretWord.toLowerCase().contains(guess.toLowerCase()) -> {
                correctGuesses.add(guess[0].toLowerCase())
            }
            else -> {
                wrongGuesses.add(guess[0].toLowerCase())
                println("Sorry, there is no $guess")
                strikes++
            }
        }

    }

    // ** GAME ENDS **
    // Display incorrect guesses and total incorrect entries
    println("\nWrong Guesses: $wrongGuesses Total: $strikes")

    // If user loses, wish them luck next time. If user wins, congratulate them.
    if (gameOver == true) {
        print("Darn, $name ran out of tries! The word was $secretWord. Better luck next time!")
    }
    else {
        print("AWESOME! $name got it! The word was $secretWord.")
    }
}

fun printKnownLetters(secretWord: String, correctGuesses: Set<Char>) {
    // Print an empty line
    println("")

    // For loop that prints every character in string 'secretWord'
    for (letter in secretWord.toLowerCase()) {
        // If user has guessed the letter, show the letter; else just show a blank
        if (correctGuesses.contains(letter)) {
            print("$letter ")
        } else {
            print("_ ")
        }
    }
}