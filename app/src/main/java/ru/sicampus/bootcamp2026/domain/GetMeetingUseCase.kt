package ru.sicampus.bootcamp2026.domain

import ru.sicampus.bootcamp2026.data.MeetingsRepository
import ru.sicampus.bootcamp2026.domain.entities.Meeting

class GetMeetingsUseCase(
    private val repository: MeetingsRepository
) {
    suspend operator fun invoke(): Result<List<Meeting>> {
        return try {
            val meetings = repository.getMeetings()
            Result.success(meetings)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}