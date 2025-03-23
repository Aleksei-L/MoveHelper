package com.movehelper.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SettingItem(
	itemName: String
) {
	var switched by remember { mutableStateOf(false) }

	Row(
		modifier = Modifier.padding(horizontal = 12.dp,vertical = 8.dp),
		verticalAlignment = Alignment.CenterVertically
	) {
		Text(text = itemName, modifier = Modifier.weight(1f))
		Switch(checked = switched, onCheckedChange = { switched = it })
	}
}

@Preview
@Composable
private fun SettingItemPreview() {
	SettingItem("Item name")
}
