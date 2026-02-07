package ru.sicampus.bootcamp2026

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import ru.sicampus.bootcamp2026.data.MeetingsRepository
import ru.sicampus.bootcamp2026.data.dto.MeetingMapper
import ru.sicampus.bootcamp2026.data.source.MeetingApi
import ru.sicampus.bootcamp2026.ui.screens.CreateMeetingScreen
import ru.sicampus.bootcamp2026.ui.theme.AndroidBootcamp2026FrontendTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidBootcamp2026FrontendTheme {

                val api = remember { MeetingApi() }
                val mapper = remember { MeetingMapper() }
                val repository = remember { MeetingsRepository(api, mapper) }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CreateMeetingScreen(

                    )
                }
            }
        }
    }
}