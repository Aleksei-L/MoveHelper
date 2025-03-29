package com.movehelper.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.movehelper.data.Box
import com.movehelper.data.Thing

@Database(entities = [Box::class, Thing::class], version = 1)
//TODO @TypeConverters(GenreConverter::class, CountryConverter::class)
abstract class BoxDatabase : RoomDatabase() {
	abstract fun boxDao(): BoxDao
}
