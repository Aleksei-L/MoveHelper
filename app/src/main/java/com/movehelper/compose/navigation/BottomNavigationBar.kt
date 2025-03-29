package com.movehelper.compose.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BottomNavigationBar(
	navigateWithNavController: (String) -> Unit
) {
	NavigationBar {
		bottomNavigationItems.forEach { item ->
			NavigationBarItem(
				alwaysShowLabel = true,
				icon = {
					Icon(
						painterResource(item.icon),
						contentDescription = null
					)
				},
				label = { Text(stringResource(item.title)) },
				selected = false, //TODO
				onClick = { navigateWithNavController(item.navigationDestination) }
			)
		}
	}
}

@Preview
@Composable
private fun BottomNavigationBarPreview() {
	BottomNavigationBar {}
}
