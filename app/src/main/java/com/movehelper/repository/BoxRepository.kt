package com.movehelper.repository

import com.movehelper.data.Box
import com.movehelper.data.Thing
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

	suspend fun storeNewBox(boxName: String, afterInsertCallback: () -> Unit) =
		withContext(Dispatchers.IO) {
			val boxId = generateBoxId()
			Timber.i("BoxRepository: storeNewBox(Box($boxId, $boxName))")
			boxDao.insertBox(Box(boxId, boxName))
			afterInsertCallback()
		}

	private suspend fun getBoxById(id: Int): Box? = withContext(Dispatchers.IO) {
		Timber.i("BoxRepository: getBoxById($id)")
		return@withContext boxDao.getBoxById(id)
	}

	private suspend fun generateBoxId(): Int {
		var boxId = (0..999).random()
		while (getBoxById(boxId) != null)
			boxId = (0..999).random()
		Timber.i("BoxRepository: id $boxId was generated")
		return boxId
	}

	suspend fun getAllThings(): List<Thing> = withContext(Dispatchers.IO) {
		return@withContext boxDao.getAllThings()
	}
}
