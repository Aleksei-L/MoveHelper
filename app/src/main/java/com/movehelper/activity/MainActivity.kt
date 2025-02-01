package com.movehelper.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.movehelper.compose.MainScreen
import com.movehelper.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	private val vm: MainViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			val listOfBoxes by vm.listOfBoxes.observeAsState(initial = emptyList())
			MainScreen(
				onAddButtonClicked = {
					startActivity(Intent(this@MainActivity, AddBoxActivity::class.java))
				},
				boxesList = listOfBoxes
			)
		}
	}
}
