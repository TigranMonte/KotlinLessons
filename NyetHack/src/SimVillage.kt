fun main(args: Array<String>) {
    val greetingFun: (String) -> String = { playerName ->
        val currentYear = 2023
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }

    println(greetingFun("Leon"))
}