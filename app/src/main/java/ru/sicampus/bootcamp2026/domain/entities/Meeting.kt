package ru.sicampus.bootcamp2026.domain.entities


data class Meeting(
    val id: Long,
    val title: String,
    val time: String,
    val status: String
)