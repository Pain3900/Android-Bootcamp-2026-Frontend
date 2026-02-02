package ru.sicampus.bootcamp2026.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.time.YearMonth

@Composable
fun CompactCalendarScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            // ЗАГОЛОВОК ПО ЦЕНТРУ
            Text(
                text = "Календарь встреч",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                textAlign = TextAlign.Center
            )

            // КОНТЕЙНЕР КАЛЕНДАРЯ — АДАПТИВНЫЙ
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(
                        color = Color(0xFF1E1E1E),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Дни недели — АДАПТИВНОЕ РАСПРЕДЕЛЕНИЕ
                    DayOfWeekHeader()

                    Spacer(Modifier.height(12.dp))

                    // Сетка дат
                    CalendarGrid()
                }
            }

            // НИЖНЯЯ ПАНЕЛЬ НАВИГАЦИИ
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(vertical = 16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = "Profile",
                        tint = Color.Gray,
                        modifier = Modifier.size(36.dp)
                    )

                    FloatingActionButton(
                        onClick = {},
                        containerColor = Color(0xFF6200EE),
                        modifier = Modifier.size(64.dp)
                    ) {
                        Icon(
                            Icons.Default.DateRange,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(36.dp)
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun DayOfWeekHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        val daysOfWeek = listOf("Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс")
        daysOfWeek.forEach { day ->
            Text(
                text = day,
                color = Color.Gray,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(0.14f)
                    .wrapContentSize(Alignment.Center)
            )
        }
    }
}

@Composable
fun CalendarGrid() {
    val currentDate = remember { LocalDate.now() }
    val yearMonth = remember { YearMonth.of(currentDate.year, currentDate.month) }
    val daysInMonth = yearMonth.lengthOfMonth()
    val firstDayOfMonth = yearMonth.atDay(1).dayOfWeek.value

    // Создаём список дат с пустыми ячейками для выравнивания
    val dates = buildList {
        repeat(firstDayOfMonth - 1) { add(0) }
        repeat(daysInMonth) { add(it + 1) }
        val totalCells = ((firstDayOfMonth - 1 + daysInMonth + 6) / 7) * 7
        repeat(totalCells - (firstDayOfMonth - 1 + daysInMonth)) { add(0) }
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(7),
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(dates.size) { index ->
            val date = dates[index]
            CalendarDateItem(
                date = date,
                isToday = date == currentDate.dayOfMonth &&
                        yearMonth.monthValue == currentDate.monthValue &&
                        yearMonth.year == currentDate.year
            )
        }
    }
}

@Composable
fun CalendarDateItem(date: Int, isToday: Boolean) {
    if (date == 0) {
        Box(modifier = Modifier.size(56.dp))
    } else {
        Box(
            modifier = Modifier
                .size(56.dp)
                .clickable { /* ... */ }
                .background(
                    if (isToday) Color(0xFF6200EE) else Color.Transparent,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = date.toString(),
                color = if (isToday) Color.White else Color.White.copy(alpha = 0.95f),
                fontSize = 18.sp,
                fontWeight = if (isToday) FontWeight.Bold else FontWeight.Normal
            )
        }
    }
}