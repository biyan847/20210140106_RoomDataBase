package com.example.roomdata.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdata.repositori.RepositoriSiswa
import com.example.roomdata.ui.Halaman.ItemEditDesrination
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EditViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoriSiswa: RepositoriSiswa
): ViewModel() {
    var siswaUiState by mutableStateOf(UIStateSiswa())
        private set
    private val itemId: Int = checkNotNull(savedStateHandle[ItemEditDesrination.itemIdArg])

    init {
        viewModelScope.launch {
            siswaUiState = repositoriSiswa.getSiswaStream(itemId)
                .filterNotNull()
                .first()
                .toUIStateSista(true)
        }
    }
    suspend fun updateSiswa(){
        if (validasiInput(siswaUiState.detailSiswa)){
            repositoriSiswa.updateSiswa(siswaUiState.detailSiswa.toSiswa())
        }
        else {
            println("data tidak valid")
        }
    }
    fun updateUiState(detailSiswa: DetailSiswa){
        siswaUiState =
            UIStateSiswa(detailSiswa = detailSiswa, isEntryValid = validasiInput(detailSiswa))
    }
    private fun validasiInput(uiState:DetailSiswa = siswaUiState.detailSiswa): Boolean{
        return with(uiState){
            nama.isNotBlank() && alamat.isNotBlank() && telepon.isNotBlank()
        }
    }

}