package com.movehelper.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.movehelper.compose.AddBoxScreen
import com.movehelper.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddBoxActivity : ComponentActivity() {
	private val vm: MainViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			AddBoxScreen(
				savedBoxName = null, //TODO
				saveBox = vm::saveNewBox
			)
		}
	}
}
