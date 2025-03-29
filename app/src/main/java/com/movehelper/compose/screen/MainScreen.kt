package com.movehelper.compose.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.movehelper.R
import com.movehelper.compose.BoxCard
import com.movehelper.compose.navigation.BottomNavigationBar
import com.movehelper.compose.topbar.MainTopBar
import com.movehelper.ui.MoveHelperTheme
import com.movehelper.viewmodel.MainViewModel

@Composable
fun MainScreen(
	vm: MainViewModel,
	navigateWithNavController: (String) -> Unit,
	onSettingsClick: () -> Unit,
	onAddButtonClick: () -> Unit
) {
	MoveHelperTheme {
		Scaffold(
			topBar = { MainTopBar(onSettingsClick) },
			floatingActionButton = {
				Column(horizontalAlignment = Alignment.End) {
					SmallFloatingActionButton(
						onClick = onAddButtonClick, //TODO
						modifier = Modifier.padding(bottom = 8.dp)
					) {
						Icon(
							painter = painterResource(R.drawable.ic_camera),
							contentDescription = stringResource(R.string.scan_qr_tip)
						)
					}
					FloatingActionButton(onClick = onAddButtonClick) {
						Icon(
							imageVector = Icons.Rounded.Add,
							contentDescription = stringResource(R.string.add_new_box_tip)
						)
					}
				}
			},
			bottomBar = { BottomNavigationBar(navigateWithNavController) },
			modifier = Modifier.background(MaterialTheme.colorScheme.background)
		) { innerPadding ->
			Surface(
				modifier = Modifier
					.padding(innerPadding)
					.background(MaterialTheme.colorScheme.background) //TODO
			) {
				val boxes by vm.listOfBoxes.observeAsState(emptyList())

				LazyColumn(modifier = Modifier.fillMaxHeight()) {
					items(boxes) {
						BoxCard(it.id, it.name)
					}
				}
			}
		}
	}
}
