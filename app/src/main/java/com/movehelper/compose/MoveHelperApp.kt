package com.movehelper.compose

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.movehelper.R
import com.movehelper.compose.screen.AddBoxScreen
import com.movehelper.compose.screen.MainScreen
import com.movehelper.compose.screen.SettingsScreen
import com.movehelper.compose.screen.ThingsScreen
import com.movehelper.viewmodel.MainViewModel

@Composable
fun MoveHelperApp(
	vm: MainViewModel,
	navController: NavHostController = rememberNavController()
) {
	NavHost(
		navController = navController,
		startDestination = Screen.HOME_SCREEN.name
	) {
		composable(route = Screen.HOME_SCREEN.name) {
			MainScreen(
				vm,
				navigateWithNavController = navController::navigate,
				onSettingsClick = { navController.navigate(Screen.SETTINGS_SCREEN.name) }
			) {
				navController.navigate(Screen.DETAILS_SCREEN.name)
			}
		}
		composable(route = Screen.THINGS_SCREEN.name) {
			ThingsScreen(vm, navigateWithNavController = navController::navigate)
		}
		composable(route = Screen.DETAILS_SCREEN.name) {
			AddBoxScreen(onBackClick = { navController.popBackStack() }) {
				vm.saveNewBox(it)
				navController.popBackStack()
			}
		}
		composable(route = Screen.SETTINGS_SCREEN.name) {
			SettingsScreen {
				navController.popBackStack()
			}
		}
	}
}

enum class Screen {
	HOME_SCREEN,
	THINGS_SCREEN,
	DETAILS_SCREEN,
	SETTINGS_SCREEN
}

enum class Tabs(
	@StringRes val title: Int,
	@DrawableRes val icon: Int,
	val navigationDestination: String
) {
	HOME(R.string.tab_boxes, R.drawable.ic_boxes, Screen.HOME_SCREEN.name),
	THINGS(R.string.tab_things, R.drawable.ic_things, Screen.THINGS_SCREEN.name)
}
