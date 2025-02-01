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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.movehelper.R

@OptIn(ExperimentalMaterial3Api::class) //TODO WTF
@Composable
fun TopBar(modifier: Modifier = Modifier) {
	CenterAlignedTopAppBar(
		title = {
			Text(stringResource(R.string.app_name))
		},
		colors = TopAppBarDefaults.topAppBarColors(
			containerColor = MaterialTheme.colorScheme.primaryContainer,
			titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
		),
		actions = {
			IconButton(onClick = { }) { //TODO
				Icon(
					imageVector = Icons.Rounded.Settings,
					contentDescription = stringResource(R.string.settings_tip)
				)
			}
		},
		modifier = modifier
	)
}

@Preview(showBackground = true)
@Composable
private fun TopBarPreview() {
	TopBar()
}
