package com.example.boilerplateandroid.di

import com.example.boilerplateandroid.presentation.nearby_list.NearbyViewModel
import com.example.boilerplateandroid.repository.nearbyme.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val nearbyListModule = module {

    single<FetchNearbyMeRepository> { FetchNearbyMeRepositoryImpl(get(), get())  }
    single<SportsmanModelMapper> { SportsmanModelMapperImpl() }

    viewModel { NearbyViewModel(get()) }
}