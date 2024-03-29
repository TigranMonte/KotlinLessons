package nyethack
import nyethack.extensions.random as randomizer
import java.io.File
class Player(_name: String,
             override var healthPoints: Int = 100,
             var isBlessed: Boolean,
             private var isImmortal: Boolean): Fightable {

    override val diceCount: Int = 3

    override val diceSides: Int = 6

    override val damageRoll: Int
        get() = TODO("Not yet implemented")

    override fun attack(opponent: Fightable): Int {
        val damageDealt = if (isBlessed) {
            damageRoll * 2
        } else {
            damageRoll
        }
        opponent.healthPoints -= damageDealt
        return damageDealt
    }
    var name = _name
        // переопределение метода чтения
        get() = "${field.capitalize()} of $hometown"
        private set(value) {
            field = value.trim()
        }
    val hometown by lazy { selectHometown() }
    var currentPosition = Coordinate(0, 0)

    // блок инициализации
    init {
        require(healthPoints > 0) {"healthPoints must be greater than zero."}
        require(name.isNotBlank()) {"Player must have a name."}
    }
    // вторичный конструктор (можно внести доп
    constructor(name: String) : this(name, healthPoints = 100,
                isBlessed = true,
                isImmortal = false){
        if (name.toLowerCase() == "kar") healthPoints = 40
    }
    fun auraColor(): String {
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        val aura = if (auraVisible) "GREEN" else "NONE"
        return aura
    }
    fun formatHealthStatus() =
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
    fun castFireball(numFireballs: Int = 2) =
        println("A glass of Fireball springs into existence. (x$numFireballs)")
    private fun selectHometown() = File("/Users/anigukasan/IdeaProjects/KotlinLessons/NyetHack/data/towns.txt")
        .readText()
        .split("\n")
        .randomizer()
}