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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.movehelper.data.Box
import com.movehelper.ui.MoveHelperTheme

@Composable
fun MainScreen(
	onAddButtonClicked: () -> Unit,
	boxesList: List<Box>,
	modifier: Modifier = Modifier
) {
	MoveHelperTheme {
		Scaffold(
			topBar = { TopBar() },
			bottomBar = { BottomBar(onAddButtonClicked) },
			modifier = modifier.background(MaterialTheme.colorScheme.background)
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

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
	MainScreen({}, listOf(Box("123", "One"), Box("456", "two")))
}
