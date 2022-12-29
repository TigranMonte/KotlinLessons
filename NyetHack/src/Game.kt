fun main(args: Array<String>) {
    val name = "Madrigal"
    var HP = 100
    val B = true
    val isImmortal = false

    // aura
    val auraVisible = B && HP > 50 || isImmortal
    val A = if (auraVisible) "GREEN" else "NONE"


    val H = when (HP) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (B) {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }
    val statusFormatString = "(HP: $HP) (Aura: $A) -> $name $H"
    println(statusFormatString)
}