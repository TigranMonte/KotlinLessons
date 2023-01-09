fun main(args: Array<String>) {
    val greetingFun: (String, Int) -> String = {playerName, numBuildings ->
        val currentYear = 2023
        println("Adding $numBuildings houses")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }

    println(greetingFun("Leon", 5))
}