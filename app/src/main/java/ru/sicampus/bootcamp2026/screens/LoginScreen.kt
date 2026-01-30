package ru.sicampus.bootcamp2026.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.sicampus.bootcamp2026.components.*

@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Добро пожаловать\nв приложение для встреч!",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(24.dp))

        Avatar()

        Spacer(Modifier.height(24.dp))

        AppTextField(email, { email = it }, "Почта")
        Spacer(Modifier.height(12.dp))
        AppTextField(password, { password = it }, "Пароль")

        Spacer(Modifier.height(24.dp))
        PrimaryButton("Войти", Color(0xFF3B82F6)) {}
    }
}
