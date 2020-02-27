fun main(args: Array<String>) {
    println(whatShouldIDoToday("happy","sunny"))
    println(whatShouldIDoToday("sad"))
    print("How do you feel? ")
    println(whatShouldIDoToday(readLine()!!))
}

fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24) : String {
    return when {
        walkWeather(mood, weather) -> "go for a walk"
        sleepIn(mood, weather, temperature) -> "stay in bed"
        goSwimming(temperature) -> "go swimming"
        else -> "Stay home and read."
    }
}

fun walkWeather(mood: String, weather: String) = mood == "happy" && weather == "sunny"

fun sleepIn(mood: String, weather: String, temperature: Int) = mood == "sad" && weather == "rainy" && temperature == 0

fun goSwimming(temperature: Int) = temperature > 35

