package com.movehelper.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.movehelper.R
import com.movehelper.ui.MoveHelperTheme

@Composable
fun ItemCard(number: Int, message: String, modifier: Modifier = Modifier) {
	MoveHelperTheme {
		Card(modifier = modifier.fillMaxWidth()) {
			Row(
				modifier = Modifier
					.padding(all = 8.dp)
					.fillMaxWidth(),
				verticalAlignment = Alignment.CenterVertically,
				horizontalArrangement = Arrangement.SpaceBetween //TODO
			) {
				Text(
					text = number.toString(),
					fontFamily = FontFamily(Font(R.font.share_tech_mono)),
					fontSize = 32.sp
				)
				Text(text = message)
				IconButton(
					onClick = { } //TODO
				) {
					Icon(
						painter = painterResource(R.drawable.ic_qr_code),
						contentDescription = stringResource(R.string.qr_code_tip)
					)
				}
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
private fun ItemCardPreview() {
	ItemCard(123, "Android")
}
