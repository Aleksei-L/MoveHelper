package com.movehelper.di

import android.content.Context
import androidx.room.Room
import com.movehelper.db.BoxDao
import com.movehelper.db.BoxDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
	@Provides
	@Singleton
	fun provideBoxDatabase(@ApplicationContext appContext: Context): BoxDatabase =
		Room.databaseBuilder(
			appContext,
			BoxDatabase::class.java,
			"box_database"
		).build()

	@Provides
	@Singleton
	fun provideBoxDao(db: BoxDatabase): BoxDao = db.boxDao()
}
