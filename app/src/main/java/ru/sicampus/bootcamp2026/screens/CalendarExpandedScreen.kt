package ru.sicampus.bootcamp2026.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CalendarExpandedScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(16.dp)
    ) {
        Spacer(Modifier.height(48.dp))
        Text("27 января", color = Color.White)

        Spacer(Modifier.height(24.dp))

        TimeSlot("8:00")
        EventItem("Собрание", Color(0xFF22C55E))
        TimeSlot("9:00")
        TimeSlot("10:00")
        EventItem("Конференция", Color(0xFF3B82F6))
        TimeSlot("11:00")
        TimeSlot("12:00")
        TimeSlot("13:00")
        TimeSlot("14:00")
        TimeSlot("15:00")
        TimeSlot("16:00")
        TimeSlot("17:00")
        TimeSlot("18:00")
        TimeSlot("19:00")
        TimeSlot("20:00")

        Spacer(Modifier.weight(1f))

        FloatingActionButton(
            onClick = {},
            containerColor = Color.White,
            modifier = Modifier.align(Alignment.End)
        ) {
            Icon(Icons.Default.Add, contentDescription = null)
        }
    }
}

@Composable
fun TimeSlot(time: String) {
    Spacer(Modifier.height(12.dp))
    Text(
        text = time,
        color = Color.Gray,
        modifier = Modifier.padding(vertical = 6.dp)

    )
}

@Composable
fun EventItem(title: String, color: Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color, RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        Text(title, color = Color.White)
    }
}
