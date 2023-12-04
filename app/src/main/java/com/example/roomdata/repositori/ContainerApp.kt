package com.example.roomdata.repositori

import android.content.Context
import com.example.roomdata.Data.DatabaseSiswa

interface ContainerApp {
    val repositoriSiswa : RepositoriSiswa
}
class ContainerDataApp(private val context: Context): ContainerApp{
    override val repositoriSiswa: RepositoriSiswa by lazy{
        OfflineRepositoriSiswa(DatabaseSiswa.getDatabase(context).siswaDao())
    }
}