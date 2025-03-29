package com.movehelper.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.movehelper.data.Box
import com.movehelper.data.Thing
import com.movehelper.data.ThingsInBoxes

@Dao
interface BoxDao {
	@Query("SELECT * FROM Box")
	fun getAllBoxes(): List<Box>

	@Query("SELECT * FROM Box WHERE id = :id")
	fun getBoxById(id: Int): Box?

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertBox(box: Box)

	@Delete
	fun deleteBox(box: Box)

	@Transaction
	@Query("SELECT * FROM Thing WHERE id = :boxId")
	fun getThingsInBoxes(boxId: Int): ThingsInBoxes?

	@Query("SELECT * FROM Thing")
	fun getAllThings(): List<Thing>
}
