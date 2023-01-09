fun main(args: Array<String>) {
    val greetingFun: (String) -> String = {
        val currentYear = 2023
        "Welcome to SimVillage, $it! (copyright $currentYear)"
    }

    println(greetingFun("Leon"))
}