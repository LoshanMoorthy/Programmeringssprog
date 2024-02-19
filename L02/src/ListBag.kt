class ListBag<E : Any> : Bag<E> {
    private val elements = mutableListOf<E>()

    override fun add(item: E): Boolean {
        elements.add(item)
        return true
    }

    override fun remove(): E? = if (elements.isNotEmpty()) elements.removeAt(0) else null

    override fun remove(item: E): Boolean = elements.remove(item)

    override fun clear() = elements.clear()

    override fun isEmpty(): Boolean = elements.isEmpty()

    override fun countOf(item: E): Int = elements.count { it == item }

    override fun contains(item: E): Boolean = elements.contains(item)

    override fun toArray(): Array<Any> = elements.toTypedArray()
}

fun main() {
    val bag = ListBag<Int>()
}