package com.example.boilerplateandroid.presentation.nearby_sportman_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.boilerplateandroid.model.Sportsman
import com.example.boilerplateandroid.repository.nearbyme.FetchNearbyMeRepository
import com.example.boilerplateandroid.utils.NetworkResult
import kotlinx.coroutines.launch

class NearbyViewModel(
    private val repository: FetchNearbyMeRepository
) : ViewModel() {

    private val _nearbyMe : MutableLiveData<NearbyMeListUIState> = MutableLiveData()
    val nearbyMe : LiveData<NearbyMeListUIState> = _nearbyMe

    init {
        getNearbyMeCall()
    }

    private fun getNearbyMeCall() = viewModelScope.launch {
        safeNearbyMeCall()
    }

    private suspend fun safeNearbyMeCall(){
        runCatching {
            repository.fetchNearbyMe()
        }.onSuccess {
            Log.i("TAG", "SUCCESS")
            if (it is NetworkResult.Success){
                Log.i("TAG", it.data[0].name)
                _nearbyMe.postValue(NearbyMeListUIState.Success(it.data))
            }
        }.onFailure {
            Log.i("TAG", "ERROR")
        }
    }

    sealed interface NearbyMeListUIState{
        object Loading : NearbyMeListUIState
        data class Error(val error: Throwable) : NearbyMeListUIState
        data class Success(val data: List<Sportsman>) : NearbyMeListUIState
    }
}