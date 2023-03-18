fun main(args: Array<String>) {
    println("Madrigal has left the building".addEnthusiasm()).easyPrint()
    42.easyPrint()
}

fun Any.easyPrint() = println(this)

fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)