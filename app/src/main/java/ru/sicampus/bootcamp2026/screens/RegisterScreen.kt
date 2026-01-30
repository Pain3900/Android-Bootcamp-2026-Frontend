package ru.sicampus.bootcamp2026.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ru.sicampus.bootcamp2026.components.*

@Composable
fun RegisterScreen() {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var position by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Зарегистрируйте\nсвой аккаунт",
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(24.dp))
        Avatar()

        Spacer(Modifier.height(24.dp))
        AppTextField(name, { name = it }, "Имя")
        Spacer(Modifier.height(12.dp))
        AppTextField(email, { email = it }, "Почта")
        Spacer(Modifier.height(12.dp))
        AppTextField(password, { password = it }, "Пароль")
        Spacer(Modifier.height(12.dp))
        AppTextField(position, { position = it }, "Должность")

        Spacer(Modifier.height(24.dp))
        PrimaryButton("Зарегистрироваться", Color(0xFF3B82F6)) {}
    }
}
