const val TAVERN_NAME = "John's Folly"
fun main(args: Array<String>) {
    placeOrder("vine, Dragon's Breath, 5.25")
}
private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)

    println("Madrigal speaks with $tavernMaster about their order")

//    val data = menuData.split(',')
//    val type = data[0]
//    val name = data[1]
//    val price = data[2]
    // деструктуризация - объявить и инициализировать несколько переменных
    val (type, name, price) = menuData.split(',')
    val message = "Madrigal buys a $name ($type) for $price"

    println(message)
}