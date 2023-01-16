fun main(args: Array<String>) {
    var beverage = readLine()?.let{
        if (it.isNotBlank()) {
            it.capitalize()
        } else {
            "Hadiji Ale"
        }
    }
//    beverage = null
    println(beverage)
}