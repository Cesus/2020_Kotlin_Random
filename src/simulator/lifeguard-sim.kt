package simulator

fun main() {

    var name: String

    while(true) {
        print("Hi, welcome to hangman. Please enter your name: ")
        name = readLine().toString()
        if (name.isNotBlank()) break
    }

    println("Hello $name! Welcome to lifeguard simulator. Enter h for help or p to play..." +
            "\n(If this is your first time, enter h!)")

    while (true) {
        val input1 = readLine()
        if (input1 != null) {
            if (input1.toLowerCase() == "h") {
                printHelp()
                break
            }
            if (input1.toLowerCase() == "p") {
                gameStart()
                break
            }
            else println("Enter h for help or p to play")
        }
    }
}

fun printHelp() {
    println("Your mission is to save lives as a lifeguard. You must constantly scan the water for any dangers. " +
            "\nIn real life, you would try to prevent incidents by enforcing pool rules. To make this game more" +
            "\nsimplistic, you will only need to a) spot the incident b) blow whistle and signal c) rescue the victim " +
            "\n d) provide the correct standard first aid.") // TODO -> NLS course simplified ie types of victims, how to rescue, SFA

    while(true) {
        print("Press t to start the tutorial or p to play now (if you can't wait!): ")
        val input1 = readLine().toString()
        if (input1.isNotBlank()) {
            if (input1.toLowerCase() == "p") {
                gameStart()
                break
            }
            if (input1.toLowerCase() == "t") {
                tutorialStart()
                break
            }
            print("Press t to start the tutorial or p to play now (if you can't wait!): ")
        }
    }
}

fun gameStart() {
    println("Game is loading...")
}

fun tutorialStart() {
    println("Tutorial is loading...")
    println("A list of pool patrons will be shown: their current activities, physical attributes as well as phrases.")
    println("Example: [P1: Sitting on side / elderly male holding chest + flushed face] [P2: Swimming laps / adolescent female")
}