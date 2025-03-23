package com.movehelper.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.movehelper.compose.screen.AddBoxScreen
import com.movehelper.compose.screen.MainScreen
import com.movehelper.compose.screen.SettingsScreen
import com.movehelper.viewmodel.MainViewModel

@Composable
fun MoveHelperApp(
	vm: MainViewModel,
	navController: NavHostController = rememberNavController()
) {
	NavHost(
		navController = navController,
		startDestination = Screen.HOME.name
	) {
		composable(route = Screen.HOME.name) {
			MainScreen(vm, onSettingsClick = {
				navController.navigate(Screen.SETTINGS.name)
			}) {
				navController.navigate(Screen.DETAILS.name)
			}
		}
		composable(route = Screen.DETAILS.name) {
			AddBoxScreen(onBackClick = {
				navController.popBackStack()
			}) {
				vm.saveNewBox(it)
				navController.popBackStack()
			}
		}
		composable(route = Screen.SETTINGS.name) {
			SettingsScreen {
				navController.popBackStack()
			}
		}
	}
}

enum class Screen {
	HOME,
	DETAILS,
	SETTINGS
}
