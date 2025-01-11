package com.movehelper.app

import android.app.Application
import com.movehelper.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MoveHelperApp : Application() {
	override fun onCreate() {
		super.onCreate()
		if (BuildConfig.DEBUG)
			Timber.plant(Timber.DebugTree())
	}
}
