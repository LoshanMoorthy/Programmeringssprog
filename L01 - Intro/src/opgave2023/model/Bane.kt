package opgave2023.model

import java.time.LocalDate
import java.time.LocalTime

class Bane(val nummer: Int, val erIndendørs: Boolean, val kategori: Kategori, val førsteTid: LocalTime, val sidsteTid: LocalTime) {
    private val bookinger = mutableListOf<Booking>()

    fun addBooking(booking: Booking) {
        bookinger.add(booking)
    }

    fun bookedeTimerPåDato(dato: LocalDate): Int = bookinger.count() { it.dato == dato }

    fun antalBookingerPrTime(): IntArray {
        val timer = IntArray(sidsteTid.hour - førsteTid.hour) { 0 }
        bookinger.forEach {
            val index = it.tid.hour - førsteTid.hour
            if (index in timer.indices) {
                timer[index]++
            }
        }

        return timer
    }

    fun tidLedig(dato: LocalDate, tid: LocalTime): Boolean {
        return bookinger.none { it.dato == dato && it.tid == tid }
    }
}