package com.example.boilerplateandroid

import android.app.Application
import com.example.boilerplateandroid.di.nearbyListModule
import com.example.boilerplateandroid.di.networkModule
import com.example.boilerplateandroid.di.sportsmanDetailsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                listOf(
                    networkModule,
                    nearbyListModule,
                    sportsmanDetailsModule
                )
            )
        }
    }
}