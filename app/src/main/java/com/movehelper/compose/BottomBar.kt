package com.movehelper.compose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.movehelper.R

@Composable
fun BottomBar(
	onAddButtonClick: () -> Unit
) {
	BottomAppBar(
		actions = {
			IconButton(
				onClick = { } //TODO
			) {
				Icon(
					painter = painterResource(R.drawable.ic_camera),
					contentDescription = stringResource(R.string.scan_qr_tip)
				)
			}
		},
		floatingActionButton = {
			FloatingActionButton(
				onClick = onAddButtonClick,
				elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
			) {
				Icon(
					imageVector = Icons.Rounded.Add,
					contentDescription = stringResource(R.string.add_new_box_tip)
				)
			}

		}
	)
}

@Preview(showBackground = true)
@Composable
private fun BottomBarPreview() {
	BottomBar({})
}
