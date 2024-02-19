package opgave2023.controller

import opgave2023.model.*
import storage.Storage
import java.time.LocalDate
import java.time.LocalTime

class Controller {
    fun opretSpiller(navn: String, uddannelse: String): Spiller {
        val spiller = Spiller(navn, uddannelse)
        Storage.addSpiller(spiller)
        return spiller
    }

    fun opretBane(nummer: Int, erIndendørs: Boolean, kategori: Kategori): Bane {
        val bane = Bane(nummer, erIndendørs, kategori)
        Storage.addBane(bane)
        return bane
    }

    fun opretKategori(navn: String, singlePris: Int, doublePris: Int): Kategori {
        val kategori = Kategori(navn, singlePris, doublePris)
        Storage.addKategori(kategori)
        return kategori
    }

    fun opretBooking(spiller: Spiller, bane: Bane, dato: LocalDate, startTid: LocalTime, isDouble: Boolean): Booking {
        val booking = Booking(spiller, bane, dato, startTid, isDouble)
        spiller.addBooking(booking)
        bane.addBooking(booking)
        return booking
    }
}
