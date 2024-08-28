package com.example.SpringOllama;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    @GetMapping
    public String getAnswerForQuestion() {
        return chatClient.prompt()
                .user("Powiedź, jaka jest dzisiaj pogoda.")
                .call()
                .content();
    }
}
