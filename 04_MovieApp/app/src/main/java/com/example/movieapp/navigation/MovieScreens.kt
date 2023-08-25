package com.example.movieapp.navigation

enum class MovieScreens {
    HomeScreen,
    MovieScreen;

    companion object {
        fun fromRoute(route: String?): MovieScreens = when (route?.substringBefore('/')) {
            HomeScreen.name -> HomeScreen
            MovieScreen.name -> MovieScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not registered!")
        }
    }
}