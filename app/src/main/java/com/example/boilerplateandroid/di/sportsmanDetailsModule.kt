package com.example.boilerplateandroid.di

import com.example.boilerplateandroid.presentation.sportman_detail.SportsmanDetailsViewModel
import com.example.boilerplateandroid.repository.nearbyme.SportsmanModelMapper
import com.example.boilerplateandroid.repository.nearbyme.SportsmanModelMapperImpl
import com.example.boilerplateandroid.repository.sportman_detail.SportsmanDetailsRepository
import com.example.boilerplateandroid.repository.sportman_detail.SportsmanDetailsRepositoryImpl
import com.example.boilerplateandroid.repository.sportman_detail.SportsmanResponseToModelMapper
import com.example.boilerplateandroid.repository.sportman_detail.SportsmanResponseToModelMapperImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val sportsmanDetailsModule = module {

    single<SportsmanDetailsRepository> { SportsmanDetailsRepositoryImpl(get(), get()) }
    single<SportsmanResponseToModelMapper> { SportsmanResponseToModelMapperImpl() }


    viewModel { SportsmanDetailsViewModel(get()) }
}