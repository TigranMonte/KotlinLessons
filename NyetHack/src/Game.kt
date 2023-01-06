fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 100
    val isBlessed = true
    val isImmortal = false

    // aura
    val aura = auraColor(isBlessed, healthPoints, isImmortal)

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    printPlayerStatus(healthPoints, aura, isBlessed,name, healthStatus)

    castFireball(5)
}
private fun printPlayerStatus(healthPoints: Int, aura: String, isBlessed: Boolean, name: String, healthStatus: String) {
    val statusFormatString = "(HP: $healthPoints) (Aura: $aura) " +
            "(Blessed: ${if (isBlessed) "YES" else "NO"}) -> $name $healthStatus"
    println(statusFormatString)
}
private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val aura = if (auraVisible) "GREEN" else "NONE"
    return aura
}
private fun castFireball(numFireballs: Int = 2) =
    println("A glass of Fireball springs into existence. (x$numFireballs)")
private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
    when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
}