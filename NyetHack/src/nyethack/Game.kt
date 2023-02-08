package nyethack

fun main(args: Array<String>) {

    val player = Player()
    player.castFireball()

    printPlayerStatus(player)
// Aura
    player.auraColor()
}
private fun printPlayerStatus(player: Player) {
    println("(Aura: ${player.auraColor()}) " +
            "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}

