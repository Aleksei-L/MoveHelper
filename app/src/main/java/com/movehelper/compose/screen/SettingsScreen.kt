package com.movehelper.compose.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.movehelper.R
import com.movehelper.compose.SettingItem
import com.movehelper.compose.topbar.CommonTopBar
import com.movehelper.ui.MoveHelperTheme

@Composable
fun SettingsScreen(
	onBackClick: () -> Unit
) {
	MoveHelperTheme {
		Scaffold(
			topBar = {
				CommonTopBar(stringResource(R.string.settings_tip)) { onBackClick() }
			}
		) { innerPadding ->
			Column(
				modifier = Modifier
					.padding(innerPadding)
					.fillMaxSize()
			) {
				SettingItem("Пункт 1")
				SettingItem("Пункт 2")
				SettingItem("Пункт 3")
			}
		}
	}
}

@Preview
@Composable
private fun SettingsScreenPreview() {
	SettingsScreen {}
}
