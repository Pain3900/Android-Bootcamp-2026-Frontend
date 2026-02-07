package ru.sicampus.bootcamp2026.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.sicampus.bootcamp2026.ui.components.AppTextField
import ru.sicampus.bootcamp2026.ui.components.Avatar
import ru.sicampus.bootcamp2026.ui.components.PrimaryButton

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
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            text = "Добро Пожаловать\nв приложение для встреч!",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            fontSize = 32.sp,
            lineHeight = 40.sp

        )

        Spacer(Modifier.height(40.dp))

        Avatar()

        Spacer(Modifier.height(40.dp))

        AppTextField(email, { email = it }, "Почта")
        Spacer(Modifier.height(12.dp))
        AppTextField(password, { password = it }, "Пароль")

        Spacer(Modifier.height(24.dp))
        PrimaryButton("Войти", Color(0xFF3B82F6)) {}
    }
}
