package nyethack
fun main(args: Array<String>) {

    Game.play()
}
object Game {
    private val player = Player("Madrigal")
    private val currentRoom: Room = TownSquare()
    init {
        println("Welcome, adventurer.")
        player.castFireball()
    }
    fun play() {
        while (true) {
            println(currentRoom.description())
            println(currentRoom.load())
            // состояние игрока
            printPlayerStatus(player)

            print("> Enter your command: ")
            println("Last command: ${readLine()}")
        }
    }
    private fun printPlayerStatus(player: Player) {
        println("(Aura: ${player.auraColor()}) " +
                "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
        println("${player.name} ${player.formatHealthStatus()}")
    }
}

