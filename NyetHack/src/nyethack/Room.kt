package nyethack

open class Room(val name: String) {

    protected open val dangerLevel = 5

    fun description() = "Room: $name\n" +
            "Danger level: $dangerLevel"

    open fun load() = "Nothing much to see here..."
}

class TownSquare : Room("Tom Square") {

    override val dangerLevel = super.dangerLevel - 3
    private var bellSound = "GWONG"
    override fun load() = "The villagers rally and cheer as you enter!"

    private fun ringBell() = "The bell tower announces your arrival. $bellSound"
}