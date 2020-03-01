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


    var secretWord = genRandomWord(name)

    // Declare variables
    var gameOver: Boolean ?= false
    var strikes = 0
    // Find the following solution online
    val secretLetters = secretWord.toLowerCase().toCharArray().toHashSet()
    val correctGuesses = mutableSetOf<Char>()
    val wrongGuesses = mutableSetOf<Char>()

    // If player has not guessed all the word, keep iterating
    loop@ while (secretLetters != correctGuesses) {

        // Check if player has lost or not, if so, exit while loop
        if (strikes >= 6) {
            gameOver = true
            break
        }

        // Function prints all known letters
        printKnownLetters(secretWord, correctGuesses)

        println("\nWrong Guesses: $wrongGuesses")

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

                // Print out the hangman
                when (strikes) {
                    1 -> println("\n  O\n")
                    2 -> println("\n  O\n" +
                            "  |\n")
                    3 -> println("\n  O\n" +
                            " -|\n")
                    4 -> println("\n  O\n" +
                            " -|-\n")
                    5 -> println("\n  O\n" +
                            " -|-\n" +
                            " / ")
                    6 -> println("\n  O\n" +
                            " -|-\n" +
                            " / \\")
                }
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

fun genRandomWord(name: String): String {
    // Generate random number
    val numPick = Random().nextInt((10 - 1)) + 1
    val possibleWords = mutableListOf<String>("kotlin", "jazz", "cat", "dog", "halloween", "christmas", "macdonald", "starbucks", "coffee", name)
    return when (numPick) {
        1 -> possibleWords[0]
        2 -> possibleWords[1]
        3 -> possibleWords[2]
        4 -> possibleWords[3]
        5 -> possibleWords[4]
        6 -> possibleWords[5]
        7 -> possibleWords[6]
        8 -> possibleWords[7]
        9 -> possibleWords[8]
        else -> possibleWords[9]
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