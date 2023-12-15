package com.example.roomdata.ui.Halaman

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.roomdata.R
import com.example.roomdata.model.EditViewModel
import com.example.roomdata.navigasi.DestinasiNavigasi
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.roomdata.model.PenyediaViewModel
import com.example.roomdata.navigasi.SiswaTopAppBar
import kotlinx.coroutines.launch

object ItemEditDesrination : DestinasiNavigasi {
    override val route = "item_edit"
    override val titleRes = R.string.edit_siswa
    const val  itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemEditScreen(
    navgateBack: () ->Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EditViewModel = viewModel(factory = PenyediaViewModel.Factory)

){
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            SiswaTopAppBar(title = stringResource(ItemEditDesrination.titleRes),
                canNavigateBack = true,
                navigateUp = onNavigateUp
            )
        },
    ){ innerPading ->
        EntrySiswaBody(
            uiStateSiswa = viewModel.siswaUiState,
            onSiswaValueChange =viewModel::updateUiState ,
            onSaveClick = { coroutineScope.launch {
                viewModel.updateSiswa()
                navgateBack()
            }
            },
            modifier = Modifier.padding(innerPading)
        )
    }
}