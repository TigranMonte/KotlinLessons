fun main(args: Array<String>) {
    val greetingFun = { playerName: String, numBuildings: Int ->
        val currentYear = 2023
        println("Adding $numBuildings houses")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }

    runSimulation("Leon", greetingFun)
}
fun runSimulation(playerName: String, greetingFun: (String, Int) -> String) {
    val numBuildings = (1..5).shuffled().last()
    println(greetingFun(playerName, numBuildings))
}