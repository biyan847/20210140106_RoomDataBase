package com.example.roomdata.ui.Halaman

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.example.roomdata.R
import com.example.roomdata.navigasi.DestinasiNavigasi

object DestinasiHome : DestinasiNavigasi{
    override val route = "home"
    override val titleRes = R.string.app_name

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen