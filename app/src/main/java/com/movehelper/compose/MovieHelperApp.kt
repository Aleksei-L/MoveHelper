package com.movehelper.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.LifecycleOwner
import com.movehelper.ui.MoveHelperTheme
import com.movehelper.viewmodel.MainViewModel

@Composable
fun MoveHelperApp(
	onAddButtonClicked: () -> Unit,
	context: LifecycleOwner,
	vm: MainViewModel,
	modifier: Modifier = Modifier
) {
	MoveHelperTheme {
		Scaffold(
			topBar = { TopBar() },
			bottomBar = { BottomBar(onAddButtonClicked) },
			modifier = modifier.background(MaterialTheme.colorScheme.background)
		) { innerPadding ->
			Surface(modifier = Modifier.padding(innerPadding)) {
				LazyColumn {
					vm.listOfBoxes.observe(context) { boxesList -> //TODO
						items(boxesList) {
							ItemCard(it.id, it.name)
						}
					}
				}
			}
		}
	}
}
