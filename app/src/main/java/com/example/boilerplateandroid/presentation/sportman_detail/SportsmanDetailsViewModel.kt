package com.example.boilerplateandroid.presentation.sportman_detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.boilerplateandroid.model.Sportsman
import com.example.boilerplateandroid.repository.sportman_detail.SportsmanDetailsRepository
import com.example.boilerplateandroid.utils.NetworkResult
import kotlinx.coroutines.launch

class SportsmanDetailsViewModel(
    private val repository: SportsmanDetailsRepository
) : ViewModel(){

    private val _sportsmanDetail: MutableLiveData<SportsmanDetailUIState> = MutableLiveData()
    val sportsmanDetail: LiveData<SportsmanDetailUIState> = _sportsmanDetail

    init {
        getSportsmanDetails()
    }

    private fun getSportsmanDetails() = viewModelScope.launch{
        safeFetchSportsmanDetails()
    }

    private suspend fun safeFetchSportsmanDetails(){

        runCatching {
            repository.fetchSportsmanDetails()
        }.onSuccess {

            if (it is NetworkResult.Success){

            }

            Log.i("TAG", "success")
        }.onFailure {
            Log.i("TAG", "success")
        }
    }

    sealed interface SportsmanDetailUIState{
        object Loading : SportsmanDetailUIState
        data class Error(val error: Throwable) : SportsmanDetailUIState
        data class Success(val data: Sportsman) : SportsmanDetailUIState
    }
}