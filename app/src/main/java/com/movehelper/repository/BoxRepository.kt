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

	suspend fun storeNewBox(boxName: String, afterInsertCallback: () -> Unit) =
		withContext(Dispatchers.IO) {
			val boxId = generateBoxId()
			Timber.i("BoxRepository: storeNewBox(Box($boxId, $boxName))")
			boxDao.insertBox(Box(boxId, boxName))
			afterInsertCallback()
		}

	private suspend fun getBoxById(id: String): Box? = withContext(Dispatchers.IO) {
		Timber.i("BoxRepository: getBoxById($id)")
		return@withContext boxDao.getBoxById(id)
	}

	private suspend fun generateBoxId(): String {
		var boxId = (0..999).random()
		while (getBoxById(boxId.toString()) != null)
			boxId = (0..999).random()
		Timber.i("BoxRepository: id $boxId was generated")
		return when (boxId.toString().length) {
			1 -> "00$boxId"
			2 -> "0$boxId"
			else -> boxId.toString()
		}
	}
}
