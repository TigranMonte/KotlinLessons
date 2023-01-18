fun main(args: Array<String>) {
//    var beverage = readLine()?.let{
//        if (it.isNotBlank()) {     безопасный вызов с функцией let
//            it.capitalize()
//        } else {
//            "Hadiji Ale"
//        }
//    }
//    оператор контроля !!. non-null вызывается когда точно известно, что никогда не получим null
//    var beverage = readLine()!!.capitalize()

    var beverage = readLine()
//  beverage = null
    if (beverage != null) {
        beverage = beverage.capitalize()
    } else {
        println("Can't do that without crashing - beverage was null")
    }
    val beverageServed: String = beverage ?: "Хадыженское Эль"
    println(beverageServed)
}