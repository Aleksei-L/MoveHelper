package com.movehelper.compose.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.movehelper.R
import com.movehelper.compose.topbar.CommonTopBar
import com.movehelper.ui.MoveHelperTheme

@Composable
fun AddBoxScreen(
	savedBoxName: String? = null,
	onBackClick: () -> Unit,
	saveBox: (String?) -> Unit
) {
	MoveHelperTheme {
		Scaffold(
			topBar = { CommonTopBar(stringResource(R.string.add_new_box), onBackClick) },
			modifier = Modifier.background(MaterialTheme.colorScheme.background)
		) { innerPadding ->
			Column(
				modifier = Modifier
					.padding(innerPadding)
					.fillMaxSize(),
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				var boxName by remember { mutableStateOf(savedBoxName) }

				TextField(
					value = boxName ?: "",
					onValueChange = { boxName = it },
					singleLine = true
				)

				Button(onClick = { saveBox(boxName) }) {
					Text(stringResource(R.string.add_new_box))
				}
			}
		}
	}
}

@Preview
@Composable
private fun AddBoxScreenPreview() {
	AddBoxScreen(savedBoxName = "Box 1", saveBox = {}, onBackClick = {})
}
