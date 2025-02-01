package com.movehelper.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movehelper.data.Box
import com.movehelper.repository.BoxRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
	private val boxRepository: BoxRepository
) : ViewModel() {
	private var privateListOfBoxes = MutableLiveData<List<Box>>()
	val listOfBoxes: LiveData<List<Box>> = privateListOfBoxes

	init {
		updateListOfBoxes()
	}

	private fun updateListOfBoxes() = viewModelScope.launch {
		privateListOfBoxes.postValue(boxRepository.getAllBoxes())
		Timber.i("MainViewModel: privateListOfBoxes field was updated")
	}

	fun saveNewBox(boxName: String?) = viewModelScope.launch {
		if (boxName == null)
			TODO()
		boxRepository.storeNewBox(boxName) {
			updateListOfBoxes()
		}
	}
}
