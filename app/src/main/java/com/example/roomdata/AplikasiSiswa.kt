package com.example.roomdata

import android.app.Application
import com.example.roomdata.repositori.ContainerApp
import com.example.roomdata.repositori.ContainerDataApp

class AplikasiSiswa : Application() {

    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}