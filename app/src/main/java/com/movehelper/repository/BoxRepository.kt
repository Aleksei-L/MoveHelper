package com.movehelper.repository

import com.movehelper.data.Box
import com.movehelper.db.BoxDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class BoxRepository @Inject constructor(
	private val boxDao: BoxDao
) {
	suspend fun getAllBoxes() = withContext(Dispatchers.IO) {
		Timber.i("BoxRepository: getAllBoxes()")
		boxDao.getAllBoxes()
	}

	suspend fun storeNewBox(box: Box) = withContext(Dispatchers.IO) {
		Timber.i("BoxRepository: storeNewBox($box)")
		boxDao.insertBox(box)
	}
}
