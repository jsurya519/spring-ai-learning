package spring.ai.learning.OpenAI.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AiController {

    private final ChatClient chatClient;

    static List<Message> messages;

    // Use constructor injection to get the ChatClient.Builder
    public AiController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
        messages = new ArrayList<>();
        messages.add(new SystemMessage("You are a helpful assistant."));
        messages.add(new UserMessage("My name is jayasurya and I'm preparing seriously for interviews to achieve my 1cr+ package goal"));

    }

    @GetMapping("/ai/simple")
    public String simplePrompt(@RequestParam String question) {
        messages.add(new UserMessage(question));

        String result = chatClient.prompt()
                .messages(messages)
                .call()
                .content();

        messages.add(new AssistantMessage(result));

        return result;
    }

    @GetMapping("/get")
    public String get() {
        return "good!";
    }
}

