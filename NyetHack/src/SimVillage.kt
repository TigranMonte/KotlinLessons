fun main(args: Array<String>) {
    val greetingFun = { playerName: String, numBuildings: Int ->
        val currentYear = 2023
        println("Adding $numBuildings houses")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }

    println(greetingFun("Leon", 5))
}