package ru.sicampus.bootcamp2026.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.sicampus.bootcamp2026.components.Avatar
import ru.sicampus.bootcamp2026.components.PrimaryButton

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Avatar(120.dp)
        Spacer(Modifier.height(16.dp))

        Text("UserName", color = Color.White)
        Text("Должность: Описание", color = Color.Gray)

        Spacer(Modifier.height(24.dp))
        PrimaryButton("Изменить профиль", Color(0xFF3B82F6)) {}
    }
}
