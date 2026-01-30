package ru.sicampus.bootcamp2026.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.sicampus.bootcamp2026.components.PrimaryButton

@Composable
fun EventBottomSheet() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1E1E1E), RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .padding(16.dp)
    ) {

        Text("Конференция", color = Color.White)
        Spacer(Modifier.height(8.dp))
        Text("Описание:", color = Color.Gray)

        Spacer(Modifier.height(16.dp))

        Row {
            PrimaryButton("Принять", Color(0xFF22C55E)) {}
            Spacer(Modifier.width(12.dp))
            PrimaryButton("Отклонить", Color(0xFFEF4444)) {}
        }

        Spacer(Modifier.height(12.dp))
        PrimaryButton("Информация об участниках", Color(0xFF3B82F6)) {}
    }
}
