import kotlin.math.absoluteValue
import kotlin.math.sign

fun String.toRational(): Rational {
    val parts = split("/")
    return if (parts.size == 2) {
        Rational(parts[0].toInt(), parts[1].toInt())
    } else {
        Rational(parts[0].toInt(), 1)
    }
}

infix fun Int.divBy(denominator: Int): Rational = Rational(this, denominator)



class Rational(n: Int, d: Int) : Comparable<Rational> {
    private val numerator: Int
    private val denominator: Int

    init {
        require(d != 0) { "Denominator must not be zero" }
        val gcd = gcd(n.absoluteValue, d.absoluteValue)
        numerator = n / gcd * if (d < 0) -1 else 1
        denominator = d.absoluteValue / gcd
    }

    private fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    override fun equals(other: Any?): Boolean = when {
        this == other -> true
        other !is Rational -> false
        else -> numerator == other.numerator && denominator == other.denominator
    }

    override fun hashCode(): Int = 31 * numerator + denominator

    override fun toString(): String = "$numerator/${denominator}"

    override fun compareTo(other: Rational): Int =
        (numerator.toLong() * other.denominator - other.numerator.toLong() * denominator).sign

    operator fun plus(other: Rational) = Rational(
        numerator * other.denominator + other.numerator * denominator,
        denominator * other.denominator
    )

    operator fun minus(other: Rational) = Rational(
        numerator * other.denominator - other.numerator * denominator,
        denominator * other.denominator
    )

    operator fun times(other: Rational) = Rational(
        numerator * other.numerator,
        denominator * other.denominator
    )

    operator fun div(other: Rational) = Rational(
        numerator * other.denominator,
        denominator * other.numerator
    )

    operator fun unaryMinus() = Rational(-numerator, denominator)
}

fun main() {
    val test1 = "1/2".toRational().toString() == "1/2"
    val test2 = "2/4".toRational().toString() == "1/2"
    val test3 = "117/1098".toRational().toString() == "13/122"
    val test4 = "23".toRational().toString() == "23/1"

    val test5 = ("1/2".toRational() + "1/3".toRational()).toString() == "5/6"
    val test6 = ("1/2".toRational() - "1/3".toRational()).toString() == "1/6"
    val test7 = ("1/2".toRational() * "1/3".toRational()).toString() == "1/6"
    val test8 = ("1/2".toRational() / "1/4".toRational()).toString() == "2"

    val test9 = (1 divBy 2) < (2 divBy 3)
    val test10 = (1 divBy 2) in (1 divBy 3)..(2 divBy 3)

    val test11 = (-(1 divBy 2)).toString() == "-1/2"

    val results = listOf(test1, test2, test3, test4, test5, test6, test7, test8, test9, test10, test11)
    results.forEachIndexed { index, result ->
        println("Test ${index + 1}: ${if (result) "Passed" else "Failed"}")
    }
}
