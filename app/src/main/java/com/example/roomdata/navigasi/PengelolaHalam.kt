package com.example.roomdata.navigasi

import android.icu.text.CaseMap.Title
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.roomdata.R
import com.example.roomdata.ui.Halaman.DestinasiEntry
import com.example.roomdata.ui.Halaman.DestinasiHome
import com.example.roomdata.ui.Halaman.EntrySiswaScreen
import com.example.roomdata.ui.Halaman.HomeScreen
import java.io.StringReader
import androidx.compose.material3.IconButton as IconButton

@Composable
fun SiswaApp(navController : NavHostController= rememberNavController()){
    HostNavigasi(navController = navController)
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SiswaTopAppBar(
    title: String,
    canNavgateBack: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior = null,
    navigate: () -> Unit = {}
){
    CenterAlignedTopAppBar(title = { Text(title)}),
    modifier = modifier,
    scrollBehavior = scrollBehavior,
    navigationIcon = {
        if (canNavgateBack){
            IconButton(onClick = navigateup) {
                Icon(imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(id = R.string.back))
                
            }
        }
    }
}
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    navHost(navController=navController, startDestination = DestinasiHome.route, modifier=Modifier)
    {
        composable(DestinasiHome.route){
            HomeScreen(navigateToItemEntry = {navController.navigate(DestinasiEntry.route)}
            ),
        }
        composable(DestinasiEntry.route){
            EntrySiswaScreen(navigateBack = {navController.popBackStack()})
        }
    }
}