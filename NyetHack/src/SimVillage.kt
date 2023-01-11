fun main(args: Array<String>) {
    runSimulation("Leon", ::printConstructionCost) { playerName, numBuildings ->
        val currentYear = 2023
        println("Adding $numBuildings houses")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
}
inline fun runSimulation(playerName: String,costPrinter: (Int) -> Unit, greetingFun: (String, Int) -> String) {
    val numBuildings = (1..5).shuffled().last()
    costPrinter(numBuildings)
    println(greetingFun(playerName, numBuildings))
}

fun printConstructionCost(numBuildings: Int) {
    val cost = 500
    println("construction cost: ${cost * numBuildings}")
}