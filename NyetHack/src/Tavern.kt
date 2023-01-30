import kotlin.math.roundToInt
import java.io.File

const val TAVERN_NAME = "John's Folly"

var playerGold = 10
var playerSilver = 10
val patronList = mutableListOf("Bill", "Arthur", "Sadie")
val lastName = listOf("Russel", "Morris", "Pets")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("/Users/anigukasan/IdeaProjects/KotlinLessons/NyetHack/data/tavern-menu-items.txt")
    .readText()
    .split("\n")
fun main(args: Array<String>) {
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
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons += name
    }
    println(uniquePatrons)
}
fun performPurchase(price: Double) {
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")

    val remainingBalance = totalPurse - price
    println("Remaining balance: ${"%.2f".format(remainingBalance)}")

    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver
    displayBalance()
}
private fun displayBalance() {
    println("Player's purse balance: Gold: $playerGold, Silver: $playerSilver")
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

//    performPurchase(price.toDouble())

    val phrase = if (name == "Dragon's Breath") {
        "$patronName exclaims: ${toDragonSpeak("Ah delicious $name!")}"
    } else {
        "$patronName says: Thanks for the $name"
    }
    println(phrase)
}