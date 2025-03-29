package com.movehelper.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movehelper.data.Box
import com.movehelper.data.Thing
import com.movehelper.repository.BoxRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
	private val boxRepository: BoxRepository
) : ViewModel() {
	private val mListOfBoxes = MutableLiveData<List<Box>>()
	val listOfBoxes: LiveData<List<Box>> = mListOfBoxes

	private val mListOfThings = MutableLiveData<List<Thing>>()
	val listOfThings: LiveData<List<Thing>> = mListOfThings

	init {
		updateListOfBoxes()
		getAllThings() //TODO
	}

	private fun updateListOfBoxes() = viewModelScope.launch {
		mListOfBoxes.postValue(boxRepository.getAllBoxes())
		Timber.i("MainViewModel: privateListOfBoxes field was updated")
	}

	fun saveNewBox(boxName: String?) = viewModelScope.launch {
		if (boxName == null)
			TODO()
		boxRepository.storeNewBox(boxName) {
			updateListOfBoxes()
		}
	}

	private fun getAllThings() = viewModelScope.launch {
		val thingsInBoxes = boxRepository.getAllThings()
		mListOfThings.postValue(thingsInBoxes)
	}
}
