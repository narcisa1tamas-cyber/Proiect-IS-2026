package com.example.is_aplicatie_mobile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.is_aplicatie_mobile.ui.theme.*

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) { // Am adăugat parametrul aici
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightGray)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Autentificare Personal",
            style = MaterialTheme.typography.headlineSmall,
            color = MedicalBlue,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(32.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = PureWhite),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                // Numele introdus aici va fi identificatorul utilizatorului în Cloud
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Utilizator (Medic/Asistent)") },
                    leadingIcon = { Icon(Icons.Default.Person, contentDescription = null, tint = MedicalBlue) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Parolă") },
                    leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null, tint = MedicalBlue) },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                // Tema tehnică cere salvarea numelui în baza de date Cloud
                // Momentan doar declanșăm navigarea către dashboard
                if (username.isNotBlank()) {
                    onLoginSuccess()
                }
            },
            modifier = Modifier.fillMaxWidth().height(55.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MedicalBlue)
        ) {
            Text("CONECTARE", fontWeight = FontWeight.Bold)
        }
    }
}