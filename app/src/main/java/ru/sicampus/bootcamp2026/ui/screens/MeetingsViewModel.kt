package ru.sicampus.bootcamp2026.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.sicampus.bootcamp2026.domain.GetMeetingsUseCase
import ru.sicampus.bootcamp2026.domain.entities.Meeting

class MeetingsViewModel(
    private val getMeetingsUseCase: GetMeetingsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<MeetingsUiState>(MeetingsUiState.Loading)
    val uiState: StateFlow<MeetingsUiState> = _uiState

    init {
        loadMeetings()
    }

    fun loadMeetings() {
        viewModelScope.launch {
            _uiState.value = MeetingsUiState.Loading
            val result = getMeetingsUseCase()

            _uiState.value = if (result.isSuccess) {
                MeetingsUiState.Success(result.getOrNull() ?: emptyList())
            } else {
                MeetingsUiState.Error(result.exceptionOrNull()?.message ?: "Неизвестная ошибка")
            }
        }
    }
}

sealed interface MeetingsUiState {
    object Loading : MeetingsUiState
    data class Success(val meetings: List<Meeting>) : MeetingsUiState
    data class Error(val message: String) : MeetingsUiState
}