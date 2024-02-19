package opgave2023.model

import java.time.LocalDate
import java.time.LocalTime

class Booking(val spiller: Spiller, val bane: Bane, val dato: LocalDate, val startTid: LocalTime, val isDouble: Boolean, val tid: LocalTime) {
    init {
        spiller.addBooking(this)
        bane.addBooking(this)
    }
}