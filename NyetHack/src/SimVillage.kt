fun main(args: Array<String>) {
    runSimulation()
}

fun runSimulation() {
    val greetingFun  = configureGreetingFun()
    println(greetingFun("Leon"))
}

fun configureGreetingFun(): (String) -> String {
    val structureType = "hospitals"
    var numBuildings = 5
    return { playerName: String ->
        val currentYear = 2023
        numBuildings += 1
        println("Adding $numBuildings $structureType")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
}