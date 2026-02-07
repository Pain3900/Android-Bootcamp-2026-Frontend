package ru.sicampus.bootcamp2026.data.dto
import kotlinx.serialization.Serializable
@Serializable
data class CreateMeetingDto(
    val title: String,
    val description: String? = null,
    val startTime: String,
    val endTime: String,
    val location: String? = null
)
