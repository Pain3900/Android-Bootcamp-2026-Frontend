package ru.sicampus.bootcamp2026.data.dto

data class MeetingDto(
    val id: Long,
    val title: String,
    val description: String?,
    val startTime: String,
    val endTime: String,
    val location: String?,
    val status: String
)