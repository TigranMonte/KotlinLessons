package nyethack.extensions

fun <T> Iterable<T>.random() = this.shuffled().first()