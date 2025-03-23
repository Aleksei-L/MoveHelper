package com.movehelper.compose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.movehelper.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(
	onSettingsClick: () -> Unit
) {
	CenterAlignedTopAppBar(
		title = {
			Text(stringResource(R.string.app_name))
		},
		colors = TopAppBarDefaults.topAppBarColors(
			containerColor = MaterialTheme.colorScheme.primaryContainer
		),
		actions = {
			IconButton(onClick = onSettingsClick) {
				Icon(
					imageVector = Icons.Rounded.Settings,
					contentDescription = stringResource(R.string.settings_tip)
				)
			}
		}
	)
}

@Preview(showBackground = true)
@Composable
private fun MainTopBarPreview() {
	MainTopBar {}
}
