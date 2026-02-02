package ru.sicampus.bootcamp2026.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ParticipantsScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) // ЗАГОЛОВОК С КНОПКОЙ НАЗАД
        {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Кнопка "Назад" слева
            IconButton(
                onClick = { },
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Назад",
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
            }

            // Заголовок по центру
            Text(
                text = "Создание встречи",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )

            // Пустое пространство справа
            Spacer(modifier = Modifier.size(48.dp))
        }


            // Заголовок
            Text(
                text = "Участники встречи",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                textAlign = TextAlign.Center
            )

            // Список участников
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(
                        color = Color(0xFF1E1E1E),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(16.dp)
            ) {
                items(participantsList) { participant ->
                    ParticipantItem(
                        name = participant.name,
                        avatarUrl = participant.avatarUrl
                    )
                }
            }
        }
    }
}

@Composable
fun ParticipantItem(name: String, avatarUrl: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
            .clickable { /* Обработка клика по участнику */ },
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Аватар
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(Color(0xFF2D2D2D), CircleShape)
                .padding(4.dp)
        ) {
            // Здесь можно добавить изображение через Coil или Icon
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF6200EE), CircleShape)
            ) {
                Text(
                    text = name.take(1),
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

        Spacer(Modifier.width(16.dp))

        // Имя участника
        Text(
            text = name,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

// Данные для примера
data class Participant(
    val name: String,
    val avatarUrl: String
)

val participantsList = listOf(
    Participant("Narek", ""),
    Participant("Kot", ""),
    Participant("Роман", ""),
    Participant("Собака", ""),
    Participant("Семён", ""),
    Participant("Ильдар", "")
)