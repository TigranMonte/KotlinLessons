fun main(args: Array<String>) {
    val greetingFun: () -> String = {
        val currentYear = 2023
        "Welcome to SimVillage, Mayor! (copyright $currentYear)"
    }

    println(greetingFun())
}