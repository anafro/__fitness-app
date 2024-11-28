package ru.anafro.fitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.anafro.fitnessapp.navigation.NavigationRoutes
import ru.anafro.fitnessapp.screens.AuthScreen
import ru.anafro.fitnessapp.screens.LoginScreen
import ru.anafro.fitnessapp.screens.RegisterScreen
import ru.anafro.fitnessapp.ui.theme.FitnessAppTheme
import ru.anafro.fitnessapp.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitnessAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = White
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationRoutes.AUTH) {
        composable(route = NavigationRoutes.AUTH) {
            AuthScreen(navController)
        }

        composable(route = NavigationRoutes.LOGIN) {
            LoginScreen(navController)
        }

        composable(route = NavigationRoutes.REGISTER) {
            RegisterScreen(navController)
        }
    }
}

@Composable
fun Back(navHostController: NavHostController) {
    Text(
        "Back",
        modifier = Modifier
            .clickable(onClick = { navHostController.navigate(NavigationRoutes.AUTH) })
    )
}