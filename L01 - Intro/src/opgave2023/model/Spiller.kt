package opgave2023.model

import java.awt.print.Book

class Spiller(val navn: String, val uddannelse: String) {
    private val bookinger = mutableListOf<Booking>();

    fun addBooking(booking: Booking) {
        bookinger.add(booking);
    }

    fun getBookinger(): List<Booking> = bookinger;
}