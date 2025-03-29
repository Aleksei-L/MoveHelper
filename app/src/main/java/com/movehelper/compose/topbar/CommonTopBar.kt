package com.movehelper.compose.topbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.movehelper.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonTopBar(
	title: String,
	onBackClick: () -> Unit
) {
	TopAppBar(
		colors = TopAppBarDefaults.topAppBarColors(
			containerColor = MaterialTheme.colorScheme.primaryContainer
		),
		title = { Text(title) },
		navigationIcon = {
			IconButton(
				onClick = onBackClick
			) {
				Icon(
					Icons.AutoMirrored.Rounded.ArrowBack,
					stringResource(R.string.back_tip)
				)
			}
		}
	)
}

@Preview
@Composable
private fun CommonTopBarPreview() {
	CommonTopBar("Title") {}
}
