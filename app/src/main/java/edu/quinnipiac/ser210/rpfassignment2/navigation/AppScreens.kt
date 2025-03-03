package edu.quinnipiac.ser210.rpfassignment2.navigation

enum class AppScreens {

    HomeScreen,
    DetailsScreen;
    companion object {
        fun fromRoute(route: String?): AppScreens
                = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}