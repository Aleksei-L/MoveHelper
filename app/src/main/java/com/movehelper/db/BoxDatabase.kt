package com.movehelper.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.movehelper.data.Box

@Database(entities = [Box::class], version = 1)
//TODO @TypeConverters(GenreConverter::class, CountryConverter::class)
abstract class BoxDatabase : RoomDatabase() {
	abstract fun boxDao(): BoxDao
}
