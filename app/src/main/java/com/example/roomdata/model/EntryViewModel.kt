package com.example.roomdata.model

import androidx.lifecycle.ViewModel
import com.example.roomdata.repositori.RepositoriSiswa

class EntryViewModel(private val repositoriSiswa: RepositoriSiswa): ViewModel() {



}
    /** status ui untuk siswa */
data class  UIStateSiswa(
    val detailSiswa: DetailSiswa = DetailSiswa(),
    val isEntryValid: Boolean = false
)
data class  DetailSiswa(
    val id: Int =0,
    val nama: String ="",
    val alamat: String ="",
    val telepon: String ="",

    )