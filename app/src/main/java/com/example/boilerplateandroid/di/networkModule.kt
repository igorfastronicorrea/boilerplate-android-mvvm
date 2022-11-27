package com.example.boilerplateandroid.di

import com.example.boilerplateandroid.data.NetworkService
import org.koin.dsl.module

val networkModule = module {
    single { NetworkService.getAPI() }
}