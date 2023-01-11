fun main(args: Array<String>) {
    runSimulation("Leon") { playerName, numBuildings ->
        val currentYear = 2023
        println("Adding $numBuildings houses")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
}
inline fun runSimulation(playerName: String, greetingFun: (String, Int) -> String) {
    val numBuildings = (1..5).shuffled().last()
    println(greetingFun(playerName, numBuildings))
}