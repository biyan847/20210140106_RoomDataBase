package com.example.roomdata.navigasi


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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.roomdata.ui.Halaman.DestinasiEntry
import com.example.roomdata.ui.Halaman.DestinasiHome
import com.example.roomdata.ui.Halaman.EntrySiswaScreen
import com.example.roomdata.ui.Halaman.HomeScreen
import androidx.compose.material3.IconButton as IconButton
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.roomdata.R
import com.example.roomdata.ui.Halaman.DetailDestination
import com.example.roomdata.ui.Halaman.DetailScreen
import com.example.roomdata.ui.Halaman.ItemEditDesrination
import com.example.roomdata.ui.Halaman.ItemEditScreen

@Composable
fun SiswaApp(navController: NavHostController= rememberNavController()){
    HostNavigasi(navController = navController)
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SiswaTopAppBar(
    title:String,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    scrollBevaior: TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {}
){
    CenterAlignedTopAppBar(title = {Text(title)},
        modifier = modifier,
        scrollBehavior = scrollBevaior,
        navigationIcon = {
            if (canNavigateBack){
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back)
                    )
                }
            }
        }
    )
}
@Composable 
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier
    )
    {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                onDetailClick = {
                    navController.navigate("${DetailDestination.route}/$it")
                },
            )
        }
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(
                navigateBack = { navController.popBackStack() },
            )
        }
        composable(
            DetailDestination.routeWithArgs,
            arguments = listOf(navArgument(DetailDestination.siswaIdArg) {
                type = NavType.IntType
            })
        ){
            DetailScreen(
                navigateBack = {navController.popBackStack()},
                navigateToEditItem = {
                    navController.navigate("${ItemEditDesrination.route}/$it")
                }
            )

        }
        composable(
            ItemEditDesrination.routeWithArgs,
            arguments = listOf(navArgument(ItemEditDesrination.itemIdArg){
                type = NavType.IntType
            })
        ){
            ItemEditScreen(
                navgateBack = {navController.popBackStack()},
                onNavigateUp = {navController.navigateUp()})
        }

    }
}
