package spring.ai.learning.OpenAI.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.ai.learning.OpenAI.advisors.DebugAdvisor;
import spring.ai.learning.OpenAI.tools.WeatherTool;

@RestController
public class WeatherController {

    private final ChatClient chatClient;
    private final WeatherTool weatherTool;

    public WeatherController(ChatClient.Builder builder,
                             WeatherTool weatherTool) {

        this.chatClient = builder.defaultAdvisors(new DebugAdvisor()).build();
        this.weatherTool = weatherTool;
    }

    @GetMapping("/weather")
    public String ask(@RequestParam String question) {

        return chatClient.prompt()
                .user(question)
                .tools(weatherTool)
                .call()
                .content();
    }
}