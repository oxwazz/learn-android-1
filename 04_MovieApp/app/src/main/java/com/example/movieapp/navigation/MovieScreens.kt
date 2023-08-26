package com.example.movieapp.navigation

enum class MovieScreens {
    HomeScreen,
    DetailsScreen,
    MovieScreen;

    companion object {
        fun fromRoute(route: String?): MovieScreens = when (route?.substringBefore('/')) {
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            MovieScreen.name -> MovieScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not registered!")
        }
    }
}