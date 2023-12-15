package com.example.roomdata.ui.Halaman

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.roomdata.Data.Siswa
import com.example.roomdata.R
import com.example.roomdata.model.DetailViewModel
import com.example.roomdata.navigasi.DestinasiNavigasi
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Delete
import com.example.roomdata.model.PenyediaViewModel

object  DetailDestination : DestinasiNavigasi {
    override val route= "item_details"
    override val titleRes= R.string.detail_siswa
    const val siswaIdArg = "item_id"
    val routeWithArgs = "$route/{$siswaIdArg}"
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    navigateBack: () -> Unit,
    navigateToEditItem: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = viewModel(factory = PenyediaViewModel.Factory)
    
){
    
}
@Composable
private fun ItemDetailsRow(
    @StringRes labelResID: Int, itemDetail: String, modifier: Modifier =Modifier
){
    Row(modifier = modifier) {
        Text(text = stringResource(id = labelResID))
        Spacer(modifier = Modifier.weight(1f))
        Text(text = itemDetail, fontWeight = FontWeight.Bold)
    }
}


@Composable
private fun DeleteConfirmationDialog(
    onDeleteConfirm: ( )->Unit,
    onDeleteCancel: () -> Unit,
    modifier: Modifier = Modifier
){
    AlertDialog(
        onDismissRequest = { /*Do Nothing*/ }, 
        title = { Text(stringResource(id = R.string.attention))},
        text = { Text(stringResource(id = R.string.delete))},
        modifier =modifier,
        dismissButton = {
                        TextButton(onClick = onDeleteCancel) {
                            Text(text = stringResource(id = R.string.no))
                            
                        }
        },
        confirmButton = { 
            TextButton(onClick = onDeleteConfirm) {
                Text(text = stringResource(id = R.string.yes))
                
            }
        })
}