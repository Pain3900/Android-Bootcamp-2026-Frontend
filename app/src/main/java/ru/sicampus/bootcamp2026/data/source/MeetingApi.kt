package ru.sicampus.bootcamp2026.data.source

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.*
import io.ktor.http.*
import ru.sicampus.bootcamp2026.data.source.Network
import ru.sicampus.bootcamp2026.data.dto.CreateMeetingDto
import ru.sicampus.bootcamp2026.data.dto.MeetingDto

class MeetingApi(
    private val client: HttpClient = Network.client
) {

    suspend fun getMeetings(): List<MeetingDto> =
        client.get("${Network.HOST}/meetings").body()

    suspend fun createMeeting(dto: CreateMeetingDto) {
        client.post("${Network.HOST}/meetings/create") {
            contentType(ContentType.Application.Json)
            setBody(dto)
        }
    }

    suspend fun getUserMeetingsByDay(
        userId: Long,
        date: String // yyyy-MM-dd
    ): List<MeetingDto> =
        client.get("${Network.HOST}/meetings/user/$userId") {
            parameter("date", date)
        }.body()

    suspend fun deleteMeeting(id: Long) {
        client.delete("${Network.HOST}/meetings/delete/$id")
    }
}
