package com.example.marvel_app.functions

import androidx.compose.runtime.Composable

import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.marvel_app.data.HeroList

@Composable
fun NavMenu(){
    val navController = rememberNavController()
    NavHost(navController= navController, startDestination = "Home screen"){
        var index = 0
        composable("Home screen"){
            HomeScreen(heroList = HeroList.list, navController, initialItemIndex = index)
        }
        composable("Spider-Man"){
            index = 0
            HeroScreen(heroCard = HeroList.list[index], navController)
        }
        composable("Iron Man"){
            index = 1
            HeroScreen(heroCard = HeroList.list[index], navController)
        }
        composable("Hulk"){
            index = 2
            HeroScreen(heroCard = HeroList.list[index], navController)
        }
        composable("Captain\nAmerica"){
            index = 3
            HeroScreen(heroCard = HeroList.list[index], navController)
        }
    }
}