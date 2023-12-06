package com.example.roomdata.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.roomdata.repositori.RepositoriSiswa

class EntryViewModel(private val repositoriSiswa: RepositoriSiswa): ViewModel() {
    /** berisi status siswa saat ini*/
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    /** fungsi validasi input*/
    private fun  validationInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa): Boolean{
        return with(uiState){
            nama.isNotBlank() && alamat.isNotBlank() && telepon.isNotBlank()
        }
    }
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