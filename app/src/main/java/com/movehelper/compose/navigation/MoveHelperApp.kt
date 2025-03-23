package com.movehelper.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.movehelper.compose.AddBoxScreen
import com.movehelper.compose.MainScreen
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
			MainScreen(vm) {
				navController.navigate(Screen.DETAILS.name)
			}
		}
		composable(route = Screen.DETAILS.name) {
			AddBoxScreen {
				vm.saveNewBox(it)
				navController.popBackStack()
			}
		}
	}
}

enum class Screen {
	HOME,
	DETAILS
}
