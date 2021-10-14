package com.example.composesample.navigation

import androidx.navigation.NavHostController
import com.example.composesample.util.Action
import com.example.composesample.util.Constants.LIST_SCREEN
import com.example.composesample.util.Constants.SPLASH_SCREEN

class Screens(navHostController: NavHostController) {

    val splash:()->Unit = {
        navHostController.navigate(route = "list/${Action.NO_ACTION}"){
            popUpTo(SPLASH_SCREEN){
                inclusive= true
            }
        }
    }

    val list: (Action) -> Unit = { action ->
        navHostController.navigate(route = "list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }
    val task: (Int) -> Unit = { taskId ->
        navHostController.navigate(route = "task/$taskId")
    }
}