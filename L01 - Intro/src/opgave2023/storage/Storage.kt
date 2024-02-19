package storage

import opgave2023.model.*

object Storage {
    val spillere = mutableListOf<Spiller>()
    val baner = mutableListOf<Bane>()
    val kategorier = mutableListOf<Kategori>()

    fun addSpiller(spiller: Spiller) {
        spillere.add(spiller)
    }

    fun addBane(bane: Bane) {
        baner.add(bane)
    }

    fun addKategori(kategori: Kategori) {
        kategorier.add(kategori)
    }
}
