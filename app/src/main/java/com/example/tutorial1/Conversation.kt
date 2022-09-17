package com.example.tutorial1.ui.theme

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.tutorial1.Message
import com.example.tutorial1.MessageCard
import com.example.tutorial1.SampleData

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    Tutorial1Theme() {
        Conversation(messages = SampleData.conversationSample)
    }
}