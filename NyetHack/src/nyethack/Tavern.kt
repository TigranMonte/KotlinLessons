package nyethack

import nyethack.extensions.random
import java.io.File

const val TAVERN_NAME = "John's Folly"

val patronList = mutableListOf("Bill", "Arthur", "Sadie")
val lastName = listOf("Russel", "Morris", "Pets")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("/Users/anigukasan/IdeaProjects/KotlinLessons/NyetHack/data/tavern-menu-items.txt")
    .readText()
    .split("\n")
val patronGold = mutableMapOf<String, Double>()
fun main(args: Array<String>) {
    printFormattedTavernMenu(menuList)
    
    if (patronList.contains("Sadie")) {
        println("The tavern master says: Sadie is in the back playing cards.")
    } else {
        println("The tavern master says: Sadie isn't here")
    }
    if (patronList.containsAll(listOf("Bill", "Arthur"))) {
        println("The tavern master says: Yeah, they're seated next to window")
    } else {
        println("The tavern master says: Nay, they departed hours ago")
    }

    (0..9).forEach {
        val first = patronList.random()
        val last = lastName.random()
        val name = "$first $last"
        uniquePatrons += name
    }
    uniquePatrons.forEach {
        patronGold[it] = 6.0
    }

    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(uniquePatrons.random(),
            menuList.random())
        orderCount++
    }
    displayPatronBalances()
}
fun displayPatronBalances() {
    patronGold.forEach { patron, balance ->
        println("$patron, balance: ${"%.2f".format(balance)}")
    }
}
fun performPurchase(price: Double, patronName: String) {
    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price
}
private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }
private fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their order.")

//    val data = menuData.split(',')
//    val type = data[0]
//    val name = data[1]
//    val price = data[2]
    // деструктуризация - объявить и инициализировать несколько переменных
    val (type, name, price) = menuData.split(',')
    val message = "$patronName buys a $name ($type) for $price"

    println(message)

    performPurchase(price.toDouble(), patronName)

    val phrase = if (name == "Dragon's Breath") {
        "$patronName exclaims: ${toDragonSpeak("Ah delicious $name!")}"
    } else {
        "$patronName says: Thanks for the $name"
    }
    println(phrase)
}

fun printFormattedTavernMenu(menuList: List<String>) {
    println()
    println("*** Welcome to Taernyl's Folly ***")
    println()

    val menuGroups = readGroupsFromMenuList(menuList)
    val mutableMenuList = menuList.toMutableList()

    while (!menuGroups.isEmpty()) {
        val group = menuGroups.first()
        println("${formatGroupElement(group)}")
        mutableMenuList.forEach {
            val (type, name, price) = it.split(',')
            if (type == group) {
                val dots = menuDotsPerName(name.length, price.length)
                println("${capitalizeMenuItem(name)}$dots$price")
                //mutableMenuList.removeAt(it.in)
            }
        }
        menuGroups.remove(group)
    }
}

fun menuDotsPerName(nameLenght: Int, priceLength: Int, maxLength: Int = 33): String {
    val max = maxLength - nameLenght - priceLength
    val sb = StringBuffer().append("")
    (0..max).forEach {
        sb.append('.')
    }
    return sb.toString()
}
fun capitalizeMenuItem(item: String): String {
    val sb = StringBuffer()
    item.split(' ').forEach {
        if (it.length > 2) {
            sb.append(it.capitalize())
        } else {
            sb.append(it)
        }
        sb.append(' ')
    }
    sb.deleteCharAt(sb.length - 1)
    return sb.toString()
}
fun formatGroupElement(type: String, maxLength: Int = 33): String {
    val sb = StringBuffer()
    val length = maxLength / 2 - type.length / 2 - 2
    (0..length).forEach {
        sb.append(' ')
    }
    sb.append("~[$type]~")
    return sb.toString()
}
fun readGroupsFromMenuList(menuList: List<String>): MutableSet<String> {
    val groups = mutableSetOf<String>()
    menuList.forEach {
        var (group,_,_) = it.split(',')
        groups.add(group)
    }
    return groups
}