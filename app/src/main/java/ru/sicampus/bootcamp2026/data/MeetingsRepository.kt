package ru.sicampus.bootcamp2026.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import ru.sicampus.bootcamp2026.data.dto.MeetingMapper
import ru.sicampus.bootcamp2026.data.source.MeetingApi
import ru.sicampus.bootcamp2026.domain.entities.Meeting

class MeetingsRepository(
    private val api: MeetingApi,
    private val mapper: MeetingMapper
) {
    private val _meetings = MutableStateFlow<List<Meeting>>(emptyList())
    val meetings: StateFlow<List<Meeting>> = _meetings.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    fun loadMeetings() {
        coroutineScope.launch {
            _isLoading.value = true
            _error.value = null

            try {
                val dtos = api.getMeetings()
                _meetings.value = dtos.map { mapper.map(it) }
            } catch (e: Exception) {
                _error.value = "Ошибка загрузки: ${e.message ?: "Неизвестная ошибка"}"
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }

    suspend fun getMeetings(): List<Meeting> {
        return try {
            api.getMeetings().map { mapper.map(it) }
        } catch (e: Exception) {
            throw RuntimeException("Не удалось загрузить встречи: ${e.message}", e)
        }
    }
}