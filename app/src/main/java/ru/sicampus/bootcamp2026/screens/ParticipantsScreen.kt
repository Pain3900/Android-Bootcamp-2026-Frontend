package ru.sicampus.bootcamp2026.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.sicampus.bootcamp2026.components.Avatar

@Composable
fun ParticipantsScreen() {
    val users = listOf("Ник", "Кот", "Роман", "Собака", "Сэм")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(16.dp)
    ) {

        Text("Участники встречи", color = Color.White)

        Spacer(Modifier.height(16.dp))

        users.forEach {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray, RoundedCornerShape(8.dp))
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Avatar(40.dp)
                Spacer(Modifier.width(12.dp))
                Text(it, color = Color.White)
            }
            Spacer(Modifier.height(8.dp))
        }
    }
}
