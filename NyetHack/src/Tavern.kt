fun main(args: Array<String>) {
//    var beverage = readLine()?.let{
//        if (it.isNotBlank()) {     безопасный вызов с функцией let
//            it.capitalize()
//        } else {
//            "Hadiji Ale"
//        }
//    }

    var beverage = readLine()!!.capitalize() // оператор контроля non-null вызывается когда точно
                                            // известно, что никогда не получим null
    //    beverage = null
    println(beverage)
}