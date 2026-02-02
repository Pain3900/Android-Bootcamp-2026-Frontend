package ru.sicampus.bootcamp2026.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.sicampus.bootcamp2026.components.PrimaryButton

@Composable
fun EventBottomSheet() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF121212))
            .fillMaxHeight()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Конференция",
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(8.dp))

        Text(
            text = "Описание:",
            color = Color.Gray,
            fontSize = 16.sp
        )

        Spacer(Modifier.height(8.dp))

        Text(
            text = "Конференция по современным технологиям",
            color = Color(0xFF9CA3AF),
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(Modifier.height(32.dp))

        // Две кнопки рядом по 50% ширины
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            PrimaryButton(
                text = "Принять",
                color = Color(0xFF22C55E),
                modifier = Modifier.weight(1f),
                onClick = { /* ... */ }
            )

            PrimaryButton(
                text = "Отклонить",
                color = Color(0xFFEF4444),
                modifier = Modifier.weight(1f),
                onClick = { /* ... */ }
            )
        }

        Spacer(Modifier.height(16.dp))

        // Широкая кнопка на всю ширину контейнера
        PrimaryButton(
            text = "Информация об участниках",
            color = Color(0xFF3B82F6),
            modifier = Modifier.fillMaxWidth(),
            onClick = { /* ... */ }
        )
    }
}