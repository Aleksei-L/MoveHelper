package com.movehelper.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.movehelper.ui.MoveHelperTheme
import com.movehelper.viewmodel.MainViewModel

@Composable
fun MainScreen(
	vm: MainViewModel,
	onAddButtonClicked: () -> Unit
) {
	val boxesList by vm.listOfBoxes.observeAsState(emptyList())

	MoveHelperTheme {
		Scaffold(
			topBar = { TopBar() },
			bottomBar = { BottomBar(onAddButtonClicked) },
			modifier = Modifier.background(MaterialTheme.colorScheme.background)
		) { innerPadding ->
			Surface(
				modifier = Modifier
					.padding(innerPadding)
					.background(MaterialTheme.colorScheme.background) //TODO
			) {
				LazyColumn(modifier = Modifier.fillMaxHeight()) {
					items(boxesList) {
						BoxCard(it.id, it.name)
					}
				}
			}
		}
	}
}
