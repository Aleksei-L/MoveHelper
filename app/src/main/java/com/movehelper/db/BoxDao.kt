package com.movehelper.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.movehelper.data.Box

@Dao
interface BoxDao {
	@Query("SELECT * FROM Box")
	fun getAllBoxes(): List<Box>

	@Query("SELECT * FROM Box WHERE id = :id")
	fun getBoxById(id: String): Box?

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertBox(box: Box)

	@Delete
	fun deleteBox(box: Box)
}
