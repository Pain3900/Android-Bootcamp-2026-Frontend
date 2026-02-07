package ru.sicampus.bootcamp2026.data.dto

import ru.sicampus.bootcamp2026.domain.entities.Meeting
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MeetingMapper {

    // Формат сервера: "yyyy-MM-dd HH:mm:ss"
    private val serverFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    // Желаемый формат для отображения: "10:00 – 11:00"
    private val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")

    fun map(dto: MeetingDto): Meeting {
        val formattedTime = try {
            // Парсим дату/время из серверного формата
            val start = LocalDateTime.parse(dto.startTime, serverFormatter)
            val end = LocalDateTime.parse(dto.endTime, serverFormatter)

            // Форматируем только время
            "${start.format(timeFormatter)} – ${end.format(timeFormatter)}"
        } catch (e: Exception) {
            // Fallback на случай ошибки парсинга
            "${dto.startTime.substringAfter(" ").substringBefore(":")}:${dto.startTime.substringAfter(":").substringBefore(":")} – " +
                    "${dto.endTime.substringAfter(" ").substringBefore(":")}:${dto.endTime.substringAfter(":").substringBefore(":")}"
        }

        return Meeting(
            id = dto.id,
            title = dto.title,
            time = formattedTime,
            status = dto.status
        )
    }
}