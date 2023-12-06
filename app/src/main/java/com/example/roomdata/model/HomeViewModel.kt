package com.example.roomdata.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdata.Data.Siswa
import com.example.roomdata.repositori.RepositoriSiswa
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class Homeviewmodel (private val repositoriSiswa: RepositoriSiswa): ViewModel(){
    companion object{
        private const val TIMEOUT_MILLIS = 5_000L
    }
    val homeUIState: StateFlow<HomeUiState> = repositoriSiswa.getAllSiswaStream().filterNotNull()
        .map { HomeUiState(listSiswa = it.toList()) }
        .stateIn(scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = HomeUiState()
        )

    data class HomeUiState(
        val listSiswa: List<Siswa> = listOf()
    )
}