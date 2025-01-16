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
	suspend fun getAllBoxes(): List<Box> = withContext(Dispatchers.IO) {
		Timber.i("BoxRepository: getAllBoxes()")
		return@withContext boxDao.getAllBoxes()
	}

	suspend fun storeNewBox(box: Box, afterInsertCallback: () -> Unit) =
		withContext(Dispatchers.IO) {
			Timber.i("BoxRepository: storeNewBox($box)")
			boxDao.insertBox(box)
			afterInsertCallback()
		}
}
