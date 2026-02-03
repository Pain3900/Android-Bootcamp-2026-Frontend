package ru.sicampus.bootcamp2026.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.sicampus.bootcamp2026.ui.components.Avatar
import ru.sicampus.bootcamp2026.ui.components.PrimaryButton

@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
    ) {
        // ОСНОВНОЙ КОНТЕНТ
        Column(
            modifier = Modifier
                .fillMaxSize()
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

        // НИЖНЯЯ ПАНЕЛЬ НАВИГАЦИИ
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .align(Alignment.BottomCenter)
                .padding(vertical = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Иконка профиля (активная)
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile",
                    tint = Color(0xFF6200EE),  // Синий цвет для активной иконки
                    modifier = Modifier.size(36.dp)
                )

                // Кнопка календаря
                FloatingActionButton(
                    onClick = {},
                    containerColor = Color(0xFF1E1E1E),  // Фон как в тёмной теме
                    modifier = Modifier.size(64.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = null,
                        tint = Color.Gray,  // Серый цвет для неактивной иконки
                        modifier = Modifier.size(36.dp)
                    )
                }
            }
        }
    }
}