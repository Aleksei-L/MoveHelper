package com.movehelper.compose.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.movehelper.compose.BoxCard
import com.movehelper.compose.navigation.BottomNavigationBar
import com.movehelper.ui.MoveHelperTheme
import com.movehelper.viewmodel.MainViewModel

@Composable
fun ThingsScreen(
	vm: MainViewModel,
	navigateWithNavController: (String) -> Unit
) {
	MoveHelperTheme {
		Scaffold(
			bottomBar = { BottomNavigationBar(navigateWithNavController) },
			modifier = Modifier.fillMaxSize()
		) { innerPaddings ->
			Column(
				modifier = Modifier
					.fillMaxSize()
					.padding(innerPaddings)
			) {
				val things by vm.listOfThings.observeAsState(emptyList())

				LazyColumn {
					items(things) {
						BoxCard(0, "Hi") //TODO
					}
				}
			}
		}
	}
}
