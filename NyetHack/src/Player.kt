class Player {

    var name = "madrigal"
        // переопределение метода чтения
        get() = field.capitalize()
        private set(value) {
            field = value.trim()
        }
    fun castFireball(numFireballs: Int = 2) =
        println("A glass of Fireball springs into existence. (x$numFireballs)")
}