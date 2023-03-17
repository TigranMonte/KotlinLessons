fun main(args: Array<String>) {
    println("Madrigal has left the building".addEnthusiasm())
}

fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)