package com.qguxxi.synthvoice.api

import com.qguxxi.synthvoice.BuildConfig
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.Call

data class OpenAIRequest(
    val model: String = "gpt-4",
    val messages: List<Message>,
    val temperature: Double = 0.7
)

data class Message(
    val role: String, // "user", "assistant"
    val content: String
)

data class OpenAIResponse(
    val choices: List<Choice>
)

data class Choice(
    val message: MessageContent
)

data class MessageContent(
    val role: String,
    val content: String
)

interface OpenAIApiService {
    @Headers(
        "Content-Type: application/json",
        "Authorization: ${BuildConfig.API_KEY}"
    )
    @POST("v1/chat/completions")
    suspend fun getChatCompletion(@Body request: OpenAIRequest): OpenAIResponse
}