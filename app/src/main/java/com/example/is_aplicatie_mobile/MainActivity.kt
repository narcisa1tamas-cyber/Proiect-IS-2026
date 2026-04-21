package com.example.is_aplicatie_mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.is_aplicatie_mobile.screens.LoginScreen
import com.example.is_aplicatie_mobile.screens.MedBotApp
import com.example.is_aplicatie_mobile.screens.SplashScreen
import com.example.is_aplicatie_mobile.ui.theme.ISAplicatieMobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ISAplicatieMobileTheme {
                // Gestionăm starea navigării: "splash", "login" sau "main_app"
                var currentScreen by remember { mutableStateOf("splash") }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        when (currentScreen) {
                            "splash" -> {
                                SplashScreen(onContinue = { currentScreen = "login" })
                            }

                            "login" -> {
                                // Permite întoarcerea la logo cu butonul de Back
                                BackHandler { currentScreen = "splash" }

                                // Pasăm funcția onLoginSuccess pentru a naviga la aplicația principală
                                LoginScreen(onLoginSuccess = {
                                    currentScreen = "main_app"
                                })
                            }

                            "main_app" -> {
                                // Opțional: BackHandler aici te poate întoarce la Login
                                // sau poate închide aplicația, depinde de preferință.
                                BackHandler { currentScreen = "login" }

                                // Afișăm interfața cu Dashboard, Control, Inventar și Logs
                                MedBotApp()
                            }
                        }
                    }
                }
            }
        }
    }
}