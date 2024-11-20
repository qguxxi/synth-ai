package com.qguxxi.synthvoice.ui.screen.home


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qguxxi.synthvoice.api.Message
import com.qguxxi.synthvoice.api.OpenAIRequest
import com.qguxxi.synthvoice.data.source.remote.RetrofitClient
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AIViewModel : ViewModel() {
    var question: String = ""
    var answer: String = ""

    fun sendToOpenAI(userQuestion: String, onResult: (String) -> Unit, onError: (String) -> Unit) {
        question = userQuestion
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val request = OpenAIRequest(
                    messages = listOf(Message(role = "user", content = userQuestion))
                )
                val response = RetrofitClient.apiService.getChatCompletion(request)
                val aiAnswer = response.choices.firstOrNull()?.message?.content ?: "Không có phản hồi."
                answer = aiAnswer

                withContext(Dispatchers.Main) {
                    onResult(aiAnswer)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    onError("Lỗi: ${e.message}")
                }
            }
        }
    }
}