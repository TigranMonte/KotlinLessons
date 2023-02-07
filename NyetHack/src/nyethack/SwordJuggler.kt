package nyethack

fun main(args: Array<String>) {

    var swordsJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if (isJugglingProficient) {
        swordsJuggling = 2
    }
    try {
        proficiencyCheck(swordsJuggling)
        swordsJuggling = swordsJuggling!!.plus(1)
    } catch (e: Exception) {
        println(e)
    }
    println("You juggle $swordsJuggling swords")
}
fun proficiencyCheck(swordsJuggling: Int?) {
//    swordsJuggling?: throw nyethack.UnskilledSwordJugglerException()

//    функции проверки условий
//    checkNotNull(swordsJuggling, {"nyethack.Player cannot juggle swords"})
    if (swordsJuggling != null) {
        require(swordsJuggling >= 3, {"nyethack.Player cannot juggle swords"})
    }
}
class UnskilledSwordJugglerException() : IllegalStateException("nyethack.Player cannot juggle swords")